--
-- Archivo generado con SQLiteStudio v3.4.4 el vie. mar. 15 16:50:41 2024
--
-- Codificación de texto usada: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Tabla: ingrexpro
CREATE TABLE IF NOT EXISTS ingrexpro (
    id_igxpro INTEGER PRIMARY KEY,
    id_prod_ent INTEGER,
    id_producto INTEGER,
    FOREIGN KEY (id_prod_ent) REFERENCES iv_prod_ent(id_prod_ent),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);
INSERT INTO ingrexpro (id_igxpro, id_prod_ent, id_producto) VALUES (1, 1, 1);
INSERT INTO ingrexpro (id_igxpro, id_prod_ent, id_producto) VALUES (2, 2, 2);
INSERT INTO ingrexpro (id_igxpro, id_prod_ent, id_producto) VALUES (3, 3, 3);
INSERT INTO ingrexpro (id_igxpro, id_prod_ent, id_producto) VALUES (4, 4, 4);
INSERT INTO ingrexpro (id_igxpro, id_prod_ent, id_producto) VALUES (5, 5, 5);
INSERT INTO ingrexpro (id_igxpro, id_prod_ent, id_producto) VALUES (6, 1, 6);
INSERT INTO ingrexpro (id_igxpro, id_prod_ent, id_producto) VALUES (7, 3, 7);
INSERT INTO ingrexpro (id_igxpro, id_prod_ent, id_producto) VALUES (8, 5, 1);

-- Tabla: iv_prod_ent
CREATE TABLE IF NOT EXISTS iv_prod_ent (
    id_prod_ent INTEGER PRIMARY KEY,
    nombre TEXT,
    cantsal INTEGER,
    fecha DATE
);
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (1, 'Tomate', 50, '2024-03-15');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (2, 'Harina', 30, '2024-03-14');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (3, 'Lechuga', 40, '2024-03-13');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (4, 'Arroz', 25, '2024-03-12');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (5, 'Aceite de oliva', 20, '2024-03-11');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (6, 'Arroz', 100, '2024-03-01');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (7, 'Frijoles', 150, '2024-03-02');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (8, 'Carne de res', 200, '2024-03-03');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (9, 'Pescado', 80, '2024-03-04');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (10, 'Pollo', 120, '2024-03-05');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (11, 'Tomate', 50, '2024-03-06');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (12, 'Lechuga', 60, '2024-03-07');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (13, 'Papa', 70, '2024-03-08');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (14, 'Cebolla', 40, '2024-03-09');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantsal, fecha) VALUES (15, 'Zanahoria', 30, '2024-03-10');

-- Tabla: iv_prod_sal
CREATE TABLE IF NOT EXISTS iv_prod_sal (
    id_prod_sal INTEGER PRIMARY KEY,
    nombre TEXT,
    cantsal INTEGER,
    fecha DATE
);

-- Tabla: iv_temp
CREATE TABLE IF NOT EXISTS iv_temp (
    id_iv_temp INTEGER PRIMARY KEY,
    nombre TEXT,
    cantent INTEGER,
    cantsal INTEGER,
    fecha DATE,
    iv_prod_sal_id_prod_sal INTEGER,
    iv_prod_ent_id_prod_ent INTEGER,
    FOREIGN KEY (iv_prod_sal_id_prod_sal) REFERENCES iv_prod_sal(id_prod_sal),
    FOREIGN KEY (iv_prod_ent_id_prod_ent) REFERENCES iv_prod_ent(id_prod_ent)
);

-- Tabla: prod_categoria
CREATE TABLE IF NOT EXISTS prod_categoria (
    id_cat_prod INTEGER PRIMARY KEY,
    cat_prod_nom TEXT
);
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (1, 'Bebidas');
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (2, 'Postres');
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (3, 'Ensaladas');
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (4, 'Platos principales');
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (5, 'Aperitivos');
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (6, 'Sopas');
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (7, 'Desayunos');

-- Tabla: productos
CREATE TABLE IF NOT EXISTS productos (
    id_producto INTEGER PRIMARY KEY,
    nombre TEXT,
    cantidad INTEGER,
    precio REAL,
    id_cat_prod INTEGER,
    FOREIGN KEY (id_cat_prod) REFERENCES prod_categoria(id_cat_prod)
);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (1, 'Refresco de limón', 50, 2.5, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (2, 'Pastel de chocolate', 10, 15.99, 2);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (3, 'Ensalada César', 20, 8.99, 3);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (4, 'Filete de salmón', 15, 25.99, 4);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (5, 'Alitas de pollo', 30, 12.5, 5);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (6, 'Sopa de tomate', 25, 6.75, 6);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (7, 'Desayuno continental', 5, 9.99, 7);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
