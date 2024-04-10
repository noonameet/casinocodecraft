--
-- Archivo generado con SQLiteStudio v3.4.4 el ma. abr. 9 19:18:03 2024
--
-- Codificaci�n de texto usada: System
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

-- Tabla: Producto_Ingrediente
CREATE TABLE IF NOT EXISTS Producto_Ingrediente (
    id_producto INTEGER,
    id_ingrediente INTEGER,
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto),
    FOREIGN KEY (id_ingrediente) REFERENCES iv_prod_ent(id_prod_ent),
    PRIMARY KEY (id_producto, id_ingrediente)
);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99669, 21);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99658, 1);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99658, 3);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99658, 4);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99658, 17);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99661, 1);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99661, 3);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99661, 5);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99661, 6);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99659, 1);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99659, 3);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99659, 4);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99659, 17);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99660, 13);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99663, 1);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99663, 9);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99663, 10);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99662, 1);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99662, 3);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99662, 4);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99660, 1);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99660, 3);
INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (99660, 4);

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

-- Tabla: reg_cliente
CREATE TABLE IF NOT EXISTS reg_cliente (id_cliente INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, nom_cliente TEXT NOT NULL, ape_cliente TEXT NOT NULL, ced_cliente TEXT UNIQUE NOT NULL, direccion TEXT NOT NULL, telefono TEXT UNIQUE NOT NULL);
INSERT INTO reg_cliente (id_cliente, nom_cliente, ape_cliente, ced_cliente, direccion, telefono) VALUES (0, 'John', 'Brandon', '932193182', 'djad838282', '030349943');
INSERT INTO reg_cliente (id_cliente, nom_cliente, ape_cliente, ced_cliente, direccion, telefono) VALUES (1, 'Laderson', 'Leon', '1002037384', 'dkadi848284', '3813919333');
INSERT INTO reg_cliente (id_cliente, nom_cliente, ape_cliente, ced_cliente, direccion, telefono) VALUES (2, 'SoniaUGU', 'AlegreUGU', '81847189415', 'dadsada1515', '3215165166');
INSERT INTO reg_cliente (id_cliente, nom_cliente, ape_cliente, ced_cliente, direccion, telefono) VALUES (3, 'SoniaUGUXX', 'AlegreUGUXX', '8184718941afgfa5', 'dadsad41a1515', '32151651665151');
INSERT INTO reg_cliente (id_cliente, nom_cliente, ape_cliente, ced_cliente, direccion, telefono) VALUES (4, 'SoniaPopo', 'AlegrePopo', '333333333333333333', '44444444444444444444', '213414141551');
INSERT INTO reg_cliente (id_cliente, nom_cliente, ape_cliente, ced_cliente, direccion, telefono) VALUES (5, 'dasdad', 'adasdad', '4141', '51dadad', 'daxaadffgw');
INSERT INTO reg_cliente (id_cliente, nom_cliente, ape_cliente, ced_cliente, direccion, telefono) VALUES (6, 'dadadw', 'adasxada', '5253532', 'ca52525', '67475567666666');

-- Tabla: reg_empleados
CREATE TABLE IF NOT EXISTS reg_empleados (id_empleados INTEGER PRIMARY KEY AUTOINCREMENT, nom_empleados TEXT NOT NULL, ape_empleados TEXT NOT NULL, ced_empleados TEXT UNIQUE NOT NULL, tel_empleados TEXT UNIQUE NOT NULL, usuario TEXT UNIQUE NOT NULL, clave TEXT NOT NULL, rol INTEGER NOT NULL REFERENCES emple_rol (id_rol));
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (1, 'dasdasda', 'dadada', '23214124', '42151515', 'Akaioiida', '4224242', 3);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (2, 'Laderson', 'Leon', '1002384954', '8382932934', 'AkaiSti', 'LeonLaderson', 2);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (3, 'Leon', 'dadad', '4241414', '151515', 'lolin', 'uwu', 3);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (4, 'Leond', 'dadadff', '4241414546', '1515156464', 'lolina', 'uwua', 3);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (5, 'wew', 'wew', 'ewe', 'wew', 'we', 'we', 2);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (6, 'ad', 'sd', '2424', '5325', 'kio', '123', 1);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (7, 'Laderson', 'Leon', '888888', '123456', 'Akai', '1223', 1);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (8, 'Ingrese su Nombre', 'Ingrese su Apellido', 'Ingrese su C�dula', 'Inrgese su Tel�fono', 'Ingrese su Usuario', 'aaa', 2);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (9, '', '', '', '', '', '', 1);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (10, 'Sonia', 'Alegre', '14215135', '4215151554152', 'uwu', 'nya', 1);
INSERT INTO reg_empleados (id_empleados, nom_empleados, ape_empleados, ced_empleados, tel_empleados, usuario, clave, rol) VALUES (11, 'dawdawdwa', '515151', 'dadadad', 'dadsadad', '123', '123', 3);

-- Tabla: reg_mesa
CREATE TABLE IF NOT EXISTS reg_mesa (id_mesa INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, cant_sillas INTEGER NOT NULL, tipo TEXT NOT NULL, estado TEXT NOT NULL);
INSERT INTO reg_mesa (id_mesa, cant_sillas, tipo, estado) VALUES (1, 10, 'Buffet', 'Desocupada');
INSERT INTO reg_mesa (id_mesa, cant_sillas, tipo, estado) VALUES (2, 2, 'Pareja', 'Desocupada');

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
