--
-- Archivo generado con SQLiteStudio v3.4.4 el mar. mar. 5 15:03:31 2024
--
-- Codificación de texto usada: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Tabla: aud_cierre_caja
CREATE TABLE IF NOT EXISTS aud_cierre_caja (id_cierre_caja INTEGER PRIMARY KEY UNIQUE NOT NULL, usuario INTEGER, saldo_inicio REAL, entrada REAL, caja REAL, valor_actual REAL, hora_cierre NUMERIC, fecha_cierre NUMERIC);

-- Tabla: aud_empleado
CREATE TABLE IF NOT EXISTS aud_empleado (id_aud_empleado INTEGER PRIMARY KEY UNIQUE NOT NULL, usuario INTEGER UNIQUE NOT NULL REFERENCES reg_empleados (id_empleados), hora NUMERIC NOT NULL, fecha NUMERIC NOT NULL, accion INTEGER NOT NULL);

-- Tabla: emple_accion
CREATE TABLE IF NOT EXISTS emple_accion (id_desc_accion INTEGER PRIMARY KEY REFERENCES aud_empleado (accion), nombre TEXT);

-- Tabla: emple_rol
CREATE TABLE IF NOT EXISTS emple_rol (id_rol INTEGER PRIMARY KEY, nom_rol TEXT);
INSERT INTO emple_rol (id_rol, nom_rol) VALUES (1, 'Administrador');
INSERT INTO emple_rol (id_rol, nom_rol) VALUES (2, 'Cajero');
INSERT INTO emple_rol (id_rol, nom_rol) VALUES (3, 'Mesero');

-- Tabla: fact_cabe
CREATE TABLE IF NOT EXISTS fact_cabe (id_cab_fact INTEGER PRIMARY KEY REFERENCES reg_cliente (nom_cliente), num_fact TEXT, id_dle INTEGER, id_tipo_pago TEXT, id_mesero INTEGER, id_cajero INTEGER, descuento REAL, iva REAL, total REAL, hora_fact NUMERIC, fecha_fact NUMERIC, fact_detalle_id_det_fact INTEGER);

-- Tabla: fact_detalle
CREATE TABLE IF NOT EXISTS fact_detalle (id_det_factura INTEGER PRIMARY KEY REFERENCES fact_cabe (fact_detalle_id_det_fact), num_factura TEXT, producto TEXT, cant_producto INTEGER, prec_unitario REAL, total REAL);

-- Tabla: iv_prod_ent
CREATE TABLE IF NOT EXISTS iv_prod_ent (id_prod_ent INTEGER PRIMARY KEY UNIQUE NOT NULL, nombre TEXT NOT NULL, cantent INTEGER NOT NULL, fecha NUMERIC NOT NULL);

-- Tabla: iv_prod_sal
CREATE TABLE IF NOT EXISTS iv_prod_sal (id_prod_sal INTEGER PRIMARY KEY NOT NULL UNIQUE, nombre TEXT NOT NULL, cantsal INTEGER NOT NULL, fecha NUMERIC NOT NULL);

-- Tabla: iv_temp
CREATE TABLE IF NOT EXISTS iv_temp (id_iv_temp INTEGER PRIMARY KEY UNIQUE NOT NULL, nombre TEXT NOT NULL, cantent INTEGER NOT NULL, cantsal INTEGER NOT NULL, fecha NUMERIC NOT NULL, iv_prod_sal_id_prod_sal INTEGER NOT NULL, iv_prod_ent_id_prod_ent INTEGER NOT NULL);

-- Tabla: prod_categoria
CREATE TABLE IF NOT EXISTS prod_categoria(
  id_cat_prod INTEGER primary key,
  cat_prod_nom TEXT
);
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (1, 'platos');
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (2, 'porciones');
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (3, 'bebidas');

-- Tabla: prod_preparacion
CREATE TABLE IF NOT EXISTS prod_preparacion (
  id_preparacion INTEGER primary key,
  id_producto INTEGER, cantidad INTEGER,
  foreign key (id_producto) references productos(id_producto)
);

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
CREATE TABLE IF NOT EXISTS reg_cliente (id_cliente INTEGER PRIMARY KEY UNIQUE NOT NULL, nom_cliente TEXT UNIQUE NOT NULL, ape_cliente TEXT UNIQUE NOT NULL, ced_cliente TEXT UNIQUE NOT NULL, direccion TEXT NOT NULL, telefono UNIQUE NOT NULL);
INSERT INTO reg_cliente (id_cliente, nom_cliente, ape_cliente, ced_cliente, direccion, telefono) VALUES (0, 'John', 'Brandon', '932193182', 'djad838282', '030349943');

-- Tabla: reg_empleados
CREATE TABLE IF NOT EXISTS reg_empleados (id_empleados INTEGER UNIQUE PRIMARY KEY REFERENCES fact_cabe (id_cajero), nom_empleados TEXT NOT NULL, ape_empleados NOT NULL, ced_empleados TEXT UNIQUE NOT NULL, tel_empleados TEXT UNIQUE NOT NULL, usuario TEXT UNIQUE NOT NULL, clave TEXT UNIQUE NOT NULL, rol INTEGER NOT NULL);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (0, 'dadada', 1, 'owiweiw', '3123123', '312414', 'Akaiugu', 3123123);

-- Tabla: reg_mesa
CREATE TABLE IF NOT EXISTS reg_mesa (id_mesa PRIMARY KEY UNIQUE NOT NULL, cant_sillas INTEGER NOT NULL, tipo TEXT, estado TEXT NOT NULL);

-- Tabla: reg_saldo_inicial
CREATE TABLE IF NOT EXISTS reg_saldo_inicial (id_sald_ini INTEGER PRIMARY KEY UNIQUE NOT NULL, monto REAL NOT NULL, fecha NUMERIC NOT NULL, hora NUMERIC NOT NULL);

-- Tabla: tmp_pedidos
CREATE TABLE IF NOT EXISTS tmp_pedidos (id_pedidos INTEGER PRIMARY KEY UNIQUE NOT NULL, mesa INTEGER, mesero INTEGER, "producto " TEXT, cantidad INTEGER, estado TEXT, hora NUMERIC);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
