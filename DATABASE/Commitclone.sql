--
-- Archivo generado con SQLiteStudio v3.4.4 el Sun Mar 17 22:01:46 2024
--
-- Codificacion de texto usada: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Tabla: iv_prod_ent
CREATE TABLE IF NOT EXISTS iv_prod_ent (id_prod_ent INTEGER PRIMARY KEY UNIQUE NOT NULL, nombre TEXT NOT NULL, cantent INTEGER NOT NULL, fecha NUMERIC NOT NULL);
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (1, 'Harina', 100, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (2, 'Azucar', 200, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (3, 'Sal', 150, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (4, 'Aceite de oliva', 300, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (5, 'Mantequilla', 250, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (6, 'Leche', 400, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (7, 'Huevos', 50, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (8, 'Tomate', 80, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (9, 'Cebolla', 70, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (10, 'Pimiento', 60, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (11, 'Ajo', 90, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (12, 'Pasta', 120, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (13, 'Arroz', 180, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (14, 'Lentejas', 110, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (15, 'Garbanzos', 130, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (16, 'Fideos', 170, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (17, 'Carne de res', 220, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (18, 'Pollo', 240, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (19, 'Pescado', 210, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (20, 'Langostinos', 320, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (21, 'Calamares', 280, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (22, 'Pan', 270, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (23, 'Queso', 230, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (24, 'Jamon', 260, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (25, 'Espinacas', 290, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (26, 'Zanahorias', 330, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (27, 'Patatas', 340, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (28, 'Calabaza', 350, '2024-03-17');
INSERT INTO iv_prod_ent (id_prod_ent, nombre, cantent, fecha) VALUES (29, 'Brocoli', 360, '2024-03-17');

-- Tabla: prod_categoria
CREATE TABLE IF NOT EXISTS prod_categoria (id_cat_prod INTEGER PRIMARY KEY NOT NULL, cat_prod_nom TEXT NOT NULL);
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (1, 'platos');
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (2, 'porciones');
INSERT INTO prod_categoria (id_cat_prod, cat_prod_nom) VALUES (3, 'bebidas');

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
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99659, 'Tacos', 15, 7.99, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99660, 'Sushi Variado', 12, 12.5, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99661, 'Pasta Alfredo', 20, 9.75, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99662, 'Tostadas de Atun', 10, 6.25, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99663, 'Empanadas', 18, 5.5, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99664, 'Papas a la Francesa', 22, 4.75, 2);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99665, 'Palitos de Queso', 14, 6.99, 2);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99666, 'Bruschettas', 16, 8.25, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99667, 'Torta de Chocolate', 10, 4.5, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99668, 'Helado de Vainilla', 25, 3.0, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99669, 'Ceviche', 12, 10.99, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99670, 'Churros', 20, 2.99, 2);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99671, 'Popcorn', 30, 1.99, 2);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99672, 'Tequenos', 16, 7.5, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99673, 'Croquetas de Pollo', 18, 5.25, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99674, 'Sopa de Verduras', 15, 6.75, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99675, 'Tiramisu', 10, 4.99, 1);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99676, 'Cerveza Artesanal', 20, 4.5, 3);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99677, 'Vino Tinto', 18, 8.99, 3);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99678, 'Margarita', 15, 6.5, 3);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99679, 'Mojito', 14, 7.25, 3);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99680, 'Pina Colada', 16, 5.99, 3);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99681, 'Caipirinha', 20, 6.75, 3);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99682, 'Mimosa', 18, 5.5, 3);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99683, 'Agua de Horchata', 25, 2.25, 3);
INSERT INTO productos (id_producto, nombre, cantidad, precio, id_cat_prod) VALUES (99684, 'Agua de Jamaica', 22, 2.0, 3);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
