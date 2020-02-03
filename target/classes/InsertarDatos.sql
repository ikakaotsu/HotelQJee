INSERT INTO cliente
(apellido, domicilio, email, localidad, nombre, pais, provincia, telefono, estado_civil, fechanacimiento, nro_documento, ocupacion, tipo_documento)
VALUES('Iturraspe', 'Las Heras 123', 'iturraspe23@gmail.com', 0, 'Juan Carlos', 0, 0, '155454477', 0, '13/02/2018', '23477855', 'Empleado', 0);

INSERT INTO usuario_perfil
("type")
VALUES('USER');
INSERT INTO usuario_perfil
("type")
VALUES('ADMIN');
INSERT INTO usuario_perfil
("type")
VALUES('DBA');


INSERT INTO usuario
(apellido, domicilio, email, localidad, nombre, pais, provincia, telefono, categoria, cuil, password, profesion, sso_id)
VALUES('Smith', 'Ramirez 123', 'pedrito233@gmail.com', 0, 'Sam', 0, 0, '154787744', 'Recepcionista', 0, '$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Empleado', 'sam');

INSERT INTO usuario_usuario_perfil
(usuario_id, usuario_perfil_id)
VALUES(1, 2);
