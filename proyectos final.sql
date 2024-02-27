--
-- File generated with SQLiteStudio v3.4.4 on mar. feb. 27 17:05:47 2024
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: aud_cierre_caja
CREATE TABLE IF NOT EXISTS aud_cierre_caja (id_cierre_caja INTEGER PRIMARY KEY UNIQUE NOT NULL, usuario INTEGER, saldo_inicio REAL, entrada REAL, caja REAL, valor_actual REAL, hora_cierre NUMERIC, fecha_cierre NUMERIC);

-- Table: aud_empleado
CREATE TABLE IF NOT EXISTS aud_empleado (id_aud_empleado INTEGER PRIMARY KEY UNIQUE NOT NULL, usuario INTEGER UNIQUE NOT NULL REFERENCES reg_empleados (id_empleados), hora NUMERIC NOT NULL, fecha NUMERIC NOT NULL, accion INTEGER NOT NULL);

-- Table: emple_accion
CREATE TABLE IF NOT EXISTS emple_accion (id_desc_accion INTEGER PRIMARY KEY REFERENCES aud_empleado (accion), nombre TEXT);

-- Table: emple_rol
CREATE TABLE IF NOT EXISTS emple_rol (id_rol INTEGER PRIMARY KEY, nom_rol TEXT);

-- Table: fact_cabe
CREATE TABLE IF NOT EXISTS fact_cabe (id_cab_fact INTEGER PRIMARY KEY REFERENCES reg_cliente (nom_cliente), num_fact TEXT, id_dle INTEGER, id_tipo_pago TEXT, id_mesero INTEGER, id_cajero INTEGER, descuento REAL, iva REAL, total REAL, hora_fact NUMERIC, fecha_fact NUMERIC, fact_detalle_id_det_fact INTEGER);

-- Table: fact_detalle
CREATE TABLE IF NOT EXISTS fact_detalle (id_det_factura INTEGER PRIMARY KEY REFERENCES fact_cabe (fact_detalle_id_det_fact), num_factura TEXT, producto TEXT, cant_producto INTEGER, prec_unitario REAL, total REAL);

-- Table: iv_prod_ent
CREATE TABLE IF NOT EXISTS iv_prod_ent (id_prod_ent INTEGER PRIMARY KEY UNIQUE NOT NULL, nombre TEXT NOT NULL, cantent INTEGER NOT NULL, fecha NUMERIC NOT NULL);

-- Table: iv_prod_sal
CREATE TABLE IF NOT EXISTS iv_prod_sal (id_prod_sal INTEGER PRIMARY KEY NOT NULL UNIQUE, nombre TEXT NOT NULL, cantsal INTEGER NOT NULL, fecha NUMERIC NOT NULL);

-- Table: iv_temp
CREATE TABLE IF NOT EXISTS iv_temp (id_iv_temp INTEGER PRIMARY KEY UNIQUE NOT NULL, nombre TEXT NOT NULL, cantent INTEGER NOT NULL, cantsal INTEGER NOT NULL, fecha NUMERIC NOT NULL, iv_prod_sal_id_prod_sal INTEGER NOT NULL, iv_prod_ent_id_prod_ent INTEGER NOT NULL);

-- Table: prod_bebidas
CREATE TABLE IF NOT EXISTS prod_bebidas (id_prod_bebidas INTEGER PRIMARY KEY UNIQUE NOT NULL, nombre TEXT NOT NULL, cantidad INTEGER NOT NULL, pedido REAL NOT NULL);

-- Table: prod_cat
CREATE TABLE IF NOT EXISTS prod_cat (id_cat_prod INTEGER PRIMARY KEY UNIQUE NOT NULL, cat_prod_nom TEXT NOT NULL);

-- Table: prod_platos
CREATE TABLE IF NOT EXISTS prod_platos (id_platos INTEGER PRIMARY KEY UNIQUE NOT NULL, nombre TEXT NOT NULL, cantidad INTEGER NOT NULL, precio REAL NOT NULL);

-- Table: prod_porciones
CREATE TABLE IF NOT EXISTS prod_porciones (id_porciones INTEGER PRIMARY KEY UNIQUE NOT NULL, nombre TEXT NOT NULL, cantidad INTEGER NOT NULL, precio REAL);

-- Table: prod_preparacion
CREATE TABLE IF NOT EXISTS prod_preparacion (id_preparacion INTEGER PRIMARY KEY UNIQUE NOT NULL, id_plato INTEGER NOT NULL, id_porcion INTEGER NOT NULL, cantidad NOT NULL);

-- Table: reg_cliente
CREATE TABLE IF NOT EXISTS reg_cliente (id_cliente INTEGER PRIMARY KEY UNIQUE NOT NULL, nom_cliente TEXT UNIQUE NOT NULL, ape_cliente TEXT UNIQUE NOT NULL, ced_cliente TEXT UNIQUE NOT NULL, direccion TEXT NOT NULL, telefono UNIQUE NOT NULL);

-- Table: reg_empleados
CREATE TABLE IF NOT EXISTS reg_empleados (id_empleados INTEGER UNIQUE PRIMARY KEY REFERENCES fact_cabe (id_cajero), nom_empleados TEXT NOT NULL, ced_empleados TEXT UNIQUE NOT NULL, tel_empleados TEXT UNIQUE NOT NULL, usuario TEXT UNIQUE NOT NULL, clave TEXT UNIQUE NOT NULL, rol INTEGER NOT NULL);

-- Table: reg_mesa
CREATE TABLE IF NOT EXISTS reg_mesa (id_mesa PRIMARY KEY UNIQUE NOT NULL, cant_sillas INTEGER NOT NULL, tipo TEXT, estado TEXT NOT NULL);

-- Table: reg_saldo_inicial
CREATE TABLE IF NOT EXISTS reg_saldo_inicial (id_sald_ini INTEGER PRIMARY KEY UNIQUE NOT NULL, monto REAL NOT NULL, fecha NUMERIC NOT NULL, hora NUMERIC NOT NULL);

-- Table: tmp_pedidos
CREATE TABLE IF NOT EXISTS tmp_pedidos (id_pedidos INTEGER PRIMARY KEY UNIQUE NOT NULL, mesa INTEGER, mesero INTEGER, "producto " TEXT, cantidad INTEGER, estado TEXT, hora NUMERIC);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
