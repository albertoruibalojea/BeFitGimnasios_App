Insert into usuario values ('54127855T', 'Sofia Martinez',   'sofia.marpa25@gmail.com', 698149747, true);
Insert into usuario values ('43678572G', 'Juan Perez',       'jp@gmail.com',            634848275, true);
Insert into usuario values ('93475284M', 'Javier Alvarez',   'javialv@gmail.com',       628492748, false);
Insert into usuario values ('41998572G', 'Laura Arias',      'larias@gmail.com',        601938472, false);
Insert into usuario values ('43926572F', 'Lara Padrón',      'larapadron@outlook.es',   656743224, false);
Insert into usuario values ('43975262K', 'María del Carmen', 'mcarmen@gmail.com',       651671472, false);


Insert into establecimiento values (0, 'Seiken',      'A Coruña', 981234567, 'c/Orzan, 18');
Insert into establecimiento values (1, 'Olympo',      'Santiago', 981485649, 'c/Romero Donallo, 25');
Insert into establecimiento values (2, 'Fit Factory', 'Vigo',     986454649, 'c/Val Miñor, 70');


Insert into equipamiento (modelo) values ('Pesas');
Insert into ejemplar (ano_compra, establecimiento) values (2018, 0);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 0);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 1);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 2);
Insert into equipamiento (modelo) values ('Maquina de Correr');
Insert into ejemplar (ano_compra, establecimiento) values (2018, 0);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 1);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 1);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 2);
Insert into equipamiento (modelo) values ('Esterilla');
Insert into ejemplar (ano_compra, establecimiento) values (2018, 0);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 1);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 2);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 2);
Insert into equipamiento (modelo) values ('Bicicleta Elíptica');
Insert into ejemplar (ano_compra, establecimiento) values (2018, 0);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 1);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 2);
Insert into equipamiento (modelo) values ('Stepper');
Insert into ejemplar (ano_compra, establecimiento) values (2018, 0);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 1);
Insert into ejemplar (ano_compra, establecimiento) values (2018, 2);

Insert into administrador (dni_admin, contrasena, nombre, telefono, email, ano_contratacion, establecimiento) values ('58274953F', 'pwdmarta',  'marta',  685629457, 'marta@befit.com',  2018, 0);
Insert into administrador (dni_admin, contrasena, nombre, telefono, email, ano_contratacion, establecimiento) values ('58234533P', 'pwdadrian', 'Adrian', 682346546, 'adrian@befit.com', 2018, 1);
Insert into administrador (dni_admin, contrasena, nombre, telefono, email, ano_contratacion, establecimiento) values ('58234458P', 'pwdlaura',  'Laura',  687678846, 'laura@befit.com',  2018, 2);


Insert into monitor (dni_monitor, nombre, telefono, email, horario, ano_contratacion, establecimiento) values ('38183753R', 'Martin',   683653958, 'martin@mbefit.com',     'mañana', 2018, 0);
Insert into monitor (dni_monitor, nombre, telefono, email, horario, ano_contratacion, establecimiento) values ('54563453E', 'Manuel',   683654567, 'manuel@mbefit.com',     'mañana', 2018, 0);
Insert into monitor (dni_monitor, nombre, telefono, email, horario, ano_contratacion, establecimiento) values ('44343427J', 'Pedro',    664593222, 'pedro@mbefit.com',      'tarde',  2019, 0);
Insert into monitor (dni_monitor, nombre, telefono, email, horario, ano_contratacion, establecimiento) values ('11233347U', 'Santiago', 612345678, 'santiago@mbefit.com',   'tarde',  2019, 0);
Insert into monitor (dni_monitor, nombre, telefono, email, horario, ano_contratacion, establecimiento) values ('21385347G', 'Alberto',  671293857, 'alberto@mbefit.com',    'tarde',  2019, 1);
Insert into monitor (dni_monitor, nombre, telefono, email, horario, ano_contratacion, establecimiento) values ('75395146L', 'María',    951245369, 'maría@mbefit.com',      'tarde',  2019, 1);
Insert into monitor (dni_monitor, nombre, telefono, email, horario, ano_contratacion, establecimiento) values ('35124784N', 'Mónica',   624513798, 'monica@mbefit.com',     'mañana', 2019, 1);
Insert into monitor (dni_monitor, nombre, telefono, email, horario, ano_contratacion, establecimiento) values ('45214789P', 'Lucía',    645127389, 'lucia@mbefit.com',      'mañana', 2019, 1);
Insert into monitor (dni_monitor, nombre, telefono, email, horario, ano_contratacion, establecimiento) values ('21387847G', 'Raul',     692847268, 'raul@mbefit.com',       'tarde',  2019, 2);
Insert into monitor (dni_monitor, nombre, telefono, email, horario, ano_contratacion, establecimiento) values ('47851269R', 'Paula',    685124539, 'paula@mbefit.com',      'tarde',  2019, 2);
Insert into monitor (dni_monitor, nombre, telefono, email, horario, ano_contratacion, establecimiento) values ('24157937S', 'Rodrigo',  678451379, 'rodrigo@mbefit.com',    'mañana', 2019, 2);
Insert into monitor (dni_monitor, nombre, telefono, email, horario, ano_contratacion, establecimiento) values ('58741298W', 'Atenea',   631245798, 'atenea@mbefit.com',     'mañana', 2019, 2);



Insert into actividad values ('Zumba',   0);
Insert into actividad values ('Spinning',1);
Insert into actividad values ('Boxeo',   2);
Insert into actividad values ('Danza',   3);
Insert into actividad values ('Acroyoga',4);

Insert into sesion (actividad, dni_monitor,fecha_inicio,plazas,establecimiento) values(0, '38183753R',  '29/04/2019 10:00:00', 20, 0);
Insert into sesion (actividad, dni_monitor,fecha_inicio,plazas,establecimiento) values(1, '21385347G',  '29/04/2019 17:00:00', 20, 1);
Insert into sesion (actividad, dni_monitor,fecha_inicio,plazas,establecimiento) values(2, '21387847G',  '29/04/2019 15:00:00', 20, 2);

INSERT INTO usuario_en_sesion(usuario, sesion, establecimiento) VALUES ('93475284M', 1, 0);
INSERT INTO usuario_en_sesion(usuario, sesion, establecimiento) VALUES ('54127855T', 2, 1);
INSERT INTO usuario_en_sesion(usuario, sesion, establecimiento) VALUES ('43975262K', 3, 2);
