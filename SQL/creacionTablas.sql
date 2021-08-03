Create sequence seq_equipamiento_id_equipamiento;
Create sequence seq_actividad_id_actividad;
Create sequence seq_sesion_id_sesion;


Create table equipamiento (
  modelo varchar(60) not null ,
  id_equipamiento integer default nextval('seq_equipamiento_id_equipamiento') not null primary key
);

Create table actividad (
  nombre varchar(60) not null,
  id_actividad integer default nextval('seq_actividad_id_actividad') not null primary key
);

Create table establecimiento(
  id_establecimiento integer not null primary key,
  nombre varchar(60),
  ciudad varchar(60),
  telefono varchar(15),
  direccion varchar(100) NOT NULL UNIQUE
);

Create table monitor(
  dni_monitor varchar(9) not null primary key,
  nombre varchar(60),
  telefono varchar(15),
  email varchar(60),
  horario varchar(7),
  sueldo integer,
  ano_contratacion integer not null,

  establecimiento integer not null,
  foreign key (establecimiento) references establecimiento(id_establecimiento)
    on delete cascade on update cascade
);

Create table sesion(
  actividad integer default currval ('seq_actividad_id_actividad') not null,
  id_sesion integer default nextval('seq_sesion_id_sesion') not null,
  dni_monitor varchar (9) not null,
  fecha_inicio varchar(30) not null ,
  plazas integer not null,
  establecimiento integer not null,

  primary key (id_sesion, establecimiento),
  foreign key (establecimiento) references establecimiento(id_establecimiento)
    on delete cascade on update cascade,
  foreign key(actividad) references actividad(id_actividad)
    on delete cascade on update cascade,
  foreign key (dni_monitor) references monitor (dni_monitor)
    on delete cascade on update cascade
);


--Secuencias
create or replace function controla_secuencias_equipamiento() returns trigger as $cse$
  declare
    ejemplar integer;
  begin
    case TG_OP
      when 'INSERT' then
        execute 'create sequence seq_ejemplares_equipamiento_' ||cast(NEW.id_equipamiento as text);
        return new;
      when 'UPDATE' then
        IF OLD.id_equipamiento <> NEW.id_equipamiento THEN
          ejemplar := nextval ('seq_ejemplares_equipamiento_'||cast(OLD.id_equipamiento as text));
          execute 'drop sequence seq_ejemplares_equipamiento_'||cast(OLD.id_equipamiento as text);
          execute 'create sequence seq_ejemplares_equipamiento_'||cast(NEW.id_equipamiento as text)|| ' start '||cast(ejemplar as text);
        END IF;
        return new;
      when 'DELETE' then
        execute 'drop sequence seq_ejemplares_equipamiento_'||cast(OLD.id_equipamiento as text);
        return old;
      else null;
    end case;
  end;
  $cse$ Language plpgsql;

create or replace function controla_secuencias_actividad() returns trigger as $csa$
  declare
    actividad integer;
  begin
    case TG_OP
      when 'INSERT' then
        execute 'create sequence seq_sesiones_actividad_' ||cast(NEW.id_actividad as text);
        return new;
      when 'UPDATE' then
        IF OLD.id_actividad <> NEW.id_actividad THEN
          actividad := nextval ('seq_sesiones_actividad_'||cast(OLD.id_actividad as text));
          execute 'drop sequence seq_sesiones_actividad_'||cast(OLD.id_actividad as text);
          execute 'create sequence seq_sesiones_actividad_'||cast(NEW.id_actividad as text)|| ' start '||cast(sesion as text);
        END IF;
        return new;
      when 'DELETE' then
        execute 'drop sequence seq_sesiones_actividad_'||cast(OLD.id_actividad as text);
        return old;
      else null;
    end case;
  end;
  $csa$ Language plpgsql;

create or replace function controla_secuencias_sesion() returns trigger as $css$
  declare
    sesion integer;
  begin
    case TG_OP
      when 'INSERT' then
        execute 'create sequence seq_sesion_id_sesion' ||cast(NEW.id_sesion as text);
        return new;
      when 'UPDATE' then
        IF OLD.id_sesion <> NEW.id_sesion THEN
          sesion := nextval ('seq_sesion_id_sesion'||cast(OLD.id_sesion as text));
          execute 'drop sequence seq_sesion_id_sesion'||cast(OLD.id_sesion as text);
          execute 'create sequence seq_sesion_id_sesion'||cast(NEW.id_sesion as text)|| ' start '||cast(sesion as text);
        END IF;
        return new;
      when 'DELETE' then
        execute 'drop sequence seq_sesion_id_sesion'||cast(OLD.id_sesion as text);
        return old;
      else null;
    end case;
  end;
  $css$ Language plpgsql;


--Disparadores
create trigger afterEquipamientos after insert or update or delete on equipamiento
  for each row execute procedure controla_secuencias_equipamiento();

create trigger afterActividades after insert or update or delete on actividad
  for each row execute procedure controla_secuencias_actividad();

create trigger afterSesiones after insert or update or delete on sesion
  for each row execute procedure controla_secuencias_sesion();


create or replace function introduce_id_actividad() returns trigger as $csa$
  begin
    new.id_actividad:=nextval('seq_sesiones_actividad_'||cast(new.actividad as text));
  return new;
end;
$csa$ Language plpgsql;

create or replace function introduce_id_sesion() returns trigger as $css$
  begin
    new.id_sesion:=nextval('seq_sesion_id_sesion'||cast(new.sesion as text));
  return new;
end;
$css$ Language plpgsql;



create table ejemplar(
  equipamiento integer default currval ('seq_equipamiento_id_equipamiento') not null,
  id_ejemplar integer not null,
  descripcion varchar(100),
  ano_compra integer not null,
  establecimiento integer not null,

  primary key (equipamiento, id_ejemplar),
  foreign key (equipamiento) references equipamiento(id_equipamiento)
      on delete cascade on update cascade,
  foreign key (establecimiento) references establecimiento (id_establecimiento)
	on delete cascade on update cascade
);

--Disparador de ejemplar
create or replace function introduce_id_ejemplar() returns trigger as $cse$
  begin
    new.id_ejemplar:=nextval('seq_ejemplares_equipamiento_'||cast(new.equipamiento as text));
    return new;
  end;
  $cse$ Language plpgsql;

create trigger beforeInsertEjemplares before insert on ejemplar
 for each row execute procedure introduce_id_ejemplar();





Create table usuario (
  dni_usuario varchar (9) not null primary key,
  nombre varchar(60),
  email varchar (60),
  telefono varchar(15),
  socio boolean not null
);

Create table administrador(
  dni_admin varchar(9) not null primary key,
  contrasena varchar(16) not null,
  nombre varchar(60),
  telefono varchar(15),
  email varchar(60),
  sueldo integer,
  ano_contratacion integer not null,

  establecimiento integer not null,
  foreign key (establecimiento) references establecimiento(id_establecimiento)
    on delete cascade on update cascade
);

Create table usuario_en_sesion
(
  usuario varchar (9) not null,
  sesion integer default currval('seq_sesion_id_sesion') not null,
  establecimiento integer not null,

  primary key (usuario,sesion,establecimiento),
  foreign key (usuario) references usuario(dni_usuario)
    on delete restrict on update cascade,
  foreign key (sesion,establecimiento) references sesion(id_sesion,establecimiento)
    on delete cascade on update cascade
);
