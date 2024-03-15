--
-- Archivo generado con SQLiteStudio v3.4.4 el vie. mar. 15 16:43:15 2024
--
-- Codificación de texto usada: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Tabla: aud_cierre_caja
CREATE TABLE IF NOT EXISTS aud_cierre_caja (id_cierre_caja INTEGER PRIMARY KEY UNIQUE NOT NULL, usuario INTEGER NOT NULL, saldo_inicio REAL NOT NULL, entrada REAL NOT NULL, caja REAL NOT NULL, valor_actual REAL NOT NULL, hora_cierre NUMERIC NOT NULL, fecha_cierre NUMERIC NOT NULL);

-- Tabla: aud_empleado
CREATE TABLE IF NOT EXISTS aud_empleado (id_aud_empleado INTEGER PRIMARY KEY UNIQUE NOT NULL, usuario INTEGER UNIQUE NOT NULL REFERENCES reg_empleados (id_empleados), hora NUMERIC NOT NULL, fecha NUMERIC NOT NULL, accion INTEGER NOT NULL);

-- Tabla: emple_accion
CREATE TABLE IF NOT EXISTS emple_accion (id_desc_accion INTEGER PRIMARY KEY NOT NULL, nombre TEXT NOT NULL);

-- Tabla: emple_rol
CREATE TABLE IF NOT EXISTS emple_rol (id_rol INTEGER PRIMARY KEY NOT NULL, nom_rol TEXT NOT NULL);
INSERT INTO emple_rol (id_rol, nom_rol) VALUES (1, 'Administrador');
INSERT INTO emple_rol (id_rol, nom_rol) VALUES (2, 'Cajero');
INSERT INTO emple_rol (id_rol, nom_rol) VALUES (3, 'Mesero');

-- Tabla: fact_cabe
CREATE TABLE IF NOT EXISTS fact_cabe (id_cab_fact INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, id_clie INTEGER NOT NULL REFERENCES reg_cliente (id_cliente) UNIQUE, id_tipo_pago TEXT NOT NULL REFERENCES tipo_pago (id_tipoP) UNIQUE, id_mesero INTEGER NOT NULL UNIQUE REFERENCES reg_empleados (id_empleados), id_cajero INTEGER NOT NULL REFERENCES reg_empleados (id_empleados) UNIQUE, num_fact INTEGER UNIQUE NOT NULL, descuento REAL NOT NULL, iva REAL NOT NULL, total REAL NOT NULL, hora_fact NUMERIC NOT NULL, fecha_fact NUMERIC NOT NULL);

-- Tabla: iv_prod_ent
CREATE TABLE IF NOT EXISTS iv_prod_ent (id_prod_ent INTEGER PRIMARY KEY UNIQUE NOT NULL, nombre TEXT NOT NULL, cantent INTEGER NOT NULL, fecha NUMERIC NOT NULL);

-- Tabla: iv_prod_sal
CREATE TABLE IF NOT EXISTS iv_prod_sal (id_prod_sal INTEGER PRIMARY KEY NOT NULL UNIQUE, nombre TEXT NOT NULL, cantsal INTEGER NOT NULL, fecha NUMERIC NOT NULL);

-- Tabla: iv_temp
CREATE TABLE IF NOT EXISTS iv_temp (id_iv_temp INTEGER PRIMARY KEY UNIQUE NOT NULL, nombre TEXT NOT NULL, cantent INTEGER NOT NULL, cantsal INTEGER NOT NULL, fecha NUMERIC NOT NULL, iv_prod_sal_id_prod_sal INTEGER NOT NULL, iv_prod_ent_id_prod_ent INTEGER NOT NULL);

-- Tabla: prod_categoria
CREATE TABLE IF NOT EXISTS prod_categoria (id_cat_prod INTEGER PRIMARY KEY NOT NULL, cat_prod_nom TEXT NOT NULL);
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (1, 'platos');
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (2, 'porciones');
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (3, 'bebidas');

-- Tabla: prod_preparacion
CREATE TABLE IF NOT EXISTS prod_preparacion (id_preparacion INTEGER PRIMARY KEY NOT NULL, id_producto INTEGER NOT NULL, cantidad INTEGER NOT NULL, FOREIGN KEY (id_producto) REFERENCES productos (id_producto));

-- Tabla: productos
CREATE TABLE IF NOT EXISTS productos (
  id_producto INTEGER primary key,
  nombre TEXT,
  cantidad INTEGER ,
  precio REAL,
  id_cat_prod INTEGER,
  foreign key (id_cat_prod) references prod_categoria(id_cat_prod)
);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99658, 'Hamburguesa', 100, 15000.0, 2);

-- Tabla: reg_cliente
CREATE TABLE IF NOT EXISTS reg_cliente (id_cliente INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, nom_cliente TEXT NOT NULL, ape_cliente TEXT NOT NULL, ced_cliente TEXT UNIQUE NOT NULL, direccion TEXT NOT NULL, telefono TEXT UNIQUE NOT NULL);
INSERT INTO reg_cliente (id_cliente, nom_cliente, ape_cliente, ced_cliente, direccion, telefono) VALUES (0, 'John', 'Brandon', '932193182', 'djad838282', '030349943');
INSERT INTO reg_cliente (id_cliente, nom_cliente, ape_cliente, ced_cliente, direccion, telefono) VALUES (1, 'Laderson', 'Leon', '1002037384', 'dkadi848284', '3813919333');

-- Tabla: reg_empleados
CREATE TABLE IF NOT EXISTS reg_empleados (id_empleados INTEGER PRIMARY KEY AUTOINCREMENT, nom_empleados TEXT NOT NULL, ape_empleados TEXT NOT NULL, ced_empleados TEXT UNIQUE NOT NULL, tel_empleados TEXT UNIQUE NOT NULL, usuario TEXT UNIQUE NOT NULL, clave TEXT UNIQUE NOT NULL, rol INTEGER NOT NULL REFERENCES emple_rol (id_rol));
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (1, 'dasdasda', 'dadada', '23214124', '42151515', 'Akaioiida', '4224242', 3);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (2, 'Laderson', 'Leon', '1002384954', '8382932934', 'AkaiSti', 'LeonLaderson', 2);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (3, 'Leon', 'dadad', '4241414', '151515', 'lolin', 'uwu', 3);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (4, 'Leond', 'dadadff', '4241414546', '1515156464', 'lolina', 'uwua', 3);

-- Tabla: reg_mesa
CREATE TABLE IF NOT EXISTS reg_mesa (id_mesa PRIMARY KEY UNIQUE NOT NULL, cant_sillas INTEGER NOT NULL, tipo TEXT NOT NULL, estado TEXT NOT NULL);

-- Tabla: reg_saldo_inicial
CREATE TABLE IF NOT EXISTS reg_saldo_inicial (id_sald_ini INTEGER PRIMARY KEY UNIQUE NOT NULL, monto REAL NOT NULL, fecha NUMERIC NOT NULL, hora NUMERIC NOT NULL);

-- Tabla: tipo_pago
CREATE TABLE IF NOT EXISTS tipo_pago (id_tipoP INTEGER PRIMARY KEY UNIQUE NOT NULL, nombre TEXT NOT NULL UNIQUE);
INSERT INTO tipo_pago (id_tipoP, nombre) VALUES (1, 'efectivo');
INSERT INTO tipo_pago (id_tipoP, nombre) VALUES (2, 'tarjeta');

-- Tabla: tmp_pedidos
CREATE TABLE IF NOT EXISTS tmp_pedidos (id_pedidos INTEGER PRIMARY KEY UNIQUE NOT NULL, mesa INTEGER REFERENCES reg_mesa (id_mesa) NOT NULL, mesero INTEGER REFERENCES reg_empleados (id_empleados) NOT NULL, "producto " TEXT NOT NULL, cantidad INTEGER NOT NULL, estado TEXT NOT NULL, hora NUMERIC NOT NULL);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
