CREATE TABLE reg_empleados (
  id_emple INTEGER PRIMARY KEY,
  nom_emple TEXT,
  ape_emple TEXT,
  ced_emple TEXT,
  tele_emple TEXT,
  usuario TEXT,
  clave TEXT,
  rol INTEGER,
  FOREIGN KEY(rol) REFERENCES emple_rol(id_rol)
);

CREATE TABLE emple_rol (
  id_rol INTEGER PRIMARY KEY,
  nom_rol TEXT
);

CREATE TABLE aud_empleado (
  id_aud_emple INTEGER PRIMARY KEY,
  usuario INTEGER,
  hora TIME,
  fecha DATE,
  accion INTEGER,
  FOREIGN KEY(usuario) REFERENCES reg_empleados(id_emple),
  FOREIGN KEY(accion) REFERENCES emple_accion(id_desc_accion)
);

CREATE TABLE emple_accion (
  id_desc_accion INTEGER PRIMARY KEY,
  nombre TEXT
);

CREATE TABLE aud_cierre_caja (
  id_cierre_caja INTEGER PRIMARY KEY,
  usuario INTEGER,
  saldo_inicio REAL,
  entrada REAL,
  caja REAL,
  valor_actual REAL,
  hora_cierre TIME,
  fecha_cierre DATE,
  FOREIGN KEY(usuario) REFERENCES reg_empleados(id_emple)
);

CREATE TABLE tmp_pedidos (
  id_pedidos INTEGER,
  mesa INTEGER,
  mesero INTEGER,
  producto TEXT,
  cantidad INTEGER,
  estado TEXT,
  hora TIME,
  FOREIGN KEY(mesa) REFERENCES reg_mesa(id_mesa),
  FOREIGN KEY(mesero) REFERENCES reg_empleados(id_emple)
);

CREATE TABLE reg_mesa (
  id_mesa INTEGER PRIMARY KEY,
  cant_sillas INTEGER,
  tipo TEXT,
  estado TEXT
);

CREATE TABLE reg_cliente (
  id_cliente INTEGER PRIMARY KEY,
  nom_cliente TEXT,
  ap_cliente TEXT,
  ced_ruc TEXT,
  direccion TEXT,
  telefono TEXT
);

CREATE TABLE fact_cabe (
  id_cab_fact INTEGER PRIMARY KEY,
  id_dle INTEGER,
  id_tipo_pago TEXT,
  id_mesero INTEGER,
  id_cajero INTEGER,
  descuento REAL,
  iva REAL,
  total REAL,
  hora_fact TIME,
  fecha_fact DATE,
  fact_detalle_id_det_fact INTEGER,
  FOREIGN KEY(id_dle) REFERENCES reg_cliente(id_cliente),
  FOREIGN KEY(id_cajero) REFERENCES reg_empleados(id_emple),
  FOREIGN KEY(fact_detalle_id_det_fact) REFERENCES fact_detalle(id_det_fact)
);

CREATE TABLE fact_detalle (
  id_det_fact INTEGER PRIMARY KEY,
  num_fact TEXT,
  producto TEXT,
  cant_prod INTEGER,
  unit_prod REAL,
  total REAL
);

CREATE TABLE iv_prod_sal (
  id_prod_sal INTEGER,
  nombre TEXT,
  cantsal INTEGER,
  fecha DATE
);

CREATE TABLE iv_prod_ent (
  id_prod_ent INTEGER,
  nombre TEXT,
  cantsal INTEGER,
  fecha DATE
);

CREATE TABLE iv_temp (
  id_iv_temp INTEGER PRIMARY KEY,
  nombre TEXT,
  cantent INTEGER,
  cantsal INTEGER,
  fecha DATE,
  iv_prod_sal_id_prod_sal INTEGER,
  iv_prod_ent_id_prod_ent INTEGER,
  FOREIGN KEY(iv_prod_sal_id_prod_sal) REFERENCES iv_prod_sal(id_prod_sal),
  FOREIGN KEY(iv_prod_ent_id_prod_ent) REFERENCES iv_prod_ent(id_prod_ent)
);

CREATE TABLE prod_porciones (
  id_porciones INTEGER PRIMARY KEY,
  nombre TEXT,
  cantidad INTEGER,
  precio REAL
);

CREATE TABLE prod_platos (
  id_plato INTEGER PRIMARY KEY,
  nombre TEXT,
  cantidad INTEGER,
  precio REAL
);

CREATE TABLE prod_preparacion (
  id_preparacion INTEGER PRIMARY KEY,
  id_plato INTEGER,
  id_porcion INTEGER,
  cantidad INTEGER,
  FOREIGN KEY(id_plato) REFERENCES prod_platos(id_plato),
  FOREIGN KEY(id_porcion) REFERENCES prod_porciones(id_porciones)
);

CREATE TABLE prod_cat (
  id_cat_prod INTEGER PRIMARY KEY,
  cat_prod_nom TEXT
);

CREATE TABLE prod_bebidas (
  id_prod_bebi INTEGER PRIMARY KEY,
  nombre TEXT,
  cantidad INTEGER,
  precio REAL
);
