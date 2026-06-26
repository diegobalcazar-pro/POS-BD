-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-06-2026 a las 02:39:28
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditorias_stocks`
--

CREATE TABLE `auditorias_stocks` (
  `id_auditoria_stock` int(11) NOT NULL,
  `tipo_movimiento` enum('ingreso','venta','traslado') NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `fk_variante_producto` int(11) NOT NULL,
  `fk_usuario` int(11) NOT NULL,
  `fk_deposito_origen` int(11) DEFAULT NULL,
  `fk_deposito_destino` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `auditorias_stocks`
--

INSERT INTO `auditorias_stocks` (`id_auditoria_stock`, `tipo_movimiento`, `cantidad`, `fecha`, `fk_variante_producto`, `fk_usuario`, `fk_deposito_origen`, `fk_deposito_destino`) VALUES
(1, 'traslado', 9, '2026-06-04 05:57:38', 1, 3, 2, 1),
(2, 'ingreso', 13, '2026-06-24 11:53:55', 2, 3, NULL, 2),
(3, 'ingreso', 11, '2026-06-24 11:53:55', 3, 3, NULL, 2),
(4, 'ingreso', 9, '2026-06-24 11:53:55', 4, 3, NULL, 2),
(5, 'ingreso', 10, '2026-06-24 11:53:55', 5, 3, NULL, 2),
(6, 'ingreso', 12, '2026-06-24 11:53:55', 6, 3, NULL, 2),
(7, 'ingreso', 8, '2026-06-24 11:53:55', 7, 3, NULL, 2),
(8, 'ingreso', 20, '2026-06-24 11:53:55', 8, 3, NULL, 2),
(9, 'ingreso', 17, '2026-06-24 11:53:55', 9, 3, NULL, 2),
(10, 'ingreso', 15, '2026-06-24 11:53:55', 10, 3, NULL, 2),
(11, 'ingreso', 13, '2026-06-24 11:53:55', 11, 3, NULL, 2),
(12, 'ingreso', 15, '2026-06-24 11:53:55', 12, 3, NULL, 2),
(13, 'ingreso', 11, '2026-06-24 11:53:55', 13, 3, NULL, 2),
(14, 'ingreso', 13, '2026-06-24 11:53:55', 14, 3, NULL, 2),
(15, 'ingreso', 16, '2026-06-24 11:53:55', 15, 3, NULL, 2),
(16, 'ingreso', 11, '2026-06-24 11:53:55', 16, 3, NULL, 2),
(17, 'ingreso', 11, '2026-06-24 11:53:55', 17, 3, NULL, 2),
(18, 'ingreso', 13, '2026-06-24 11:53:55', 18, 3, NULL, 2),
(19, 'ingreso', 9, '2026-06-24 11:53:55', 19, 3, NULL, 2),
(20, 'ingreso', 8, '2026-06-24 11:53:55', 20, 3, NULL, 2),
(21, 'ingreso', 10, '2026-06-24 11:53:55', 21, 3, NULL, 2),
(22, 'ingreso', 6, '2026-06-24 11:53:55', 22, 3, NULL, 2),
(23, 'ingreso', 16, '2026-06-24 11:53:55', 23, 3, NULL, 2),
(24, 'ingreso', 14, '2026-06-24 11:53:55', 24, 3, NULL, 2),
(25, 'ingreso', 12, '2026-06-24 11:53:55', 25, 3, NULL, 2),
(26, 'ingreso', 25, '2026-06-24 11:53:55', 26, 3, NULL, 2),
(27, 'ingreso', 20, '2026-06-24 11:53:55', 27, 3, NULL, 2),
(28, 'ingreso', 14, '2026-06-24 11:53:55', 28, 3, NULL, 2),
(29, 'ingreso', 11, '2026-06-24 11:53:55', 29, 3, NULL, 2),
(30, 'venta', 2, '2026-06-24 13:51:55', 3, 2, 1, NULL),
(31, 'venta', 3, '2026-06-24 13:51:55', 9, 2, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL,
  `nombre_categoria` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `nombre_categoria`) VALUES
(1, 'Deporte'),
(2, 'Moda'),
(3, 'Moda'),
(4, 'Deporte');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre_cliente` varchar(45) NOT NULL,
  `apellido_cliente` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `tipo` enum('minorista','mayorista') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre_cliente`, `apellido_cliente`, `correo`, `telefono`, `direccion`, `tipo`) VALUES
(1, 'Consumidor Final', '-', 'consumidor@final.com', '1199999999', 'Sin Direccion', 'minorista'),
(2, 'Mateo', 'Gomez', 'mateo.gomez@gmail.com', '1123456789', 'Av Rivadavia 1234', 'minorista'),
(3, 'Sofia', 'Martinez', 'sofia.martinez@gmail.com', '1134567890', 'Av Corrientes 2450', 'minorista'),
(4, 'Lucas', 'Fernandez', 'lucas.fernandez@gmail.com', '1145678901', 'Av Santa Fe 3100', 'minorista'),
(5, 'Valentina', 'Lopez', 'valentina.lopez@gmail.com', '1156789012', 'Av Cabildo 1500', 'minorista'),
(6, 'Tomas', 'Rodriguez', 'tomas.rodriguez@gmail.com', '1167890123', 'Av Juan B Justo 890', 'minorista'),
(7, 'Camila', 'Perez', 'camila.perez@gmail.com', '1178901234', 'Av Nazca 2200', 'minorista'),
(8, 'Benjamin', 'Sanchez', 'benjamin.sanchez@gmail.com', '1189012345', 'Av Directorio 1800', 'minorista'),
(9, 'Martina', 'Diaz', 'martina.diaz@gmail.com', '1190123456', 'Av San Martin 3400', 'minorista'),
(10, 'Nicolas', 'Torres', 'nicolas.torres@gmail.com', '1122103344', 'Av Scalabrini Ortiz 1200', 'minorista'),
(11, 'Julieta', 'Ramirez', 'julieta.ramirez@gmail.com', '1133204455', 'Av Independencia 760', 'minorista'),
(12, 'Urban Sport', 'Compras', 'compras@urbansport.com', '1144305566', 'Av Avellaneda 3000', 'mayorista'),
(13, 'Sport Center', 'Ventas', 'ventas@sportcenter.com', '1155406677', 'Av Cordoba 4200', 'mayorista'),
(14, 'Mega Deportes', 'Mayorista', 'contacto@megadeportes.com', '1166507788', 'Av Pueyrredon 900', 'mayorista'),
(15, 'Adidas Store', 'Sucursal Norte', 'norte@adidasstore.com', '1177608899', 'Av Libertador 5500', 'mayorista'),
(16, 'Running Shop', 'Administracion', 'admin@runningshop.com', '1188709900', 'Av Congreso 2100', 'mayorista'),
(17, 'Fit Clothes', 'Compras', 'compras@fitclothes.com', '1199801010', 'Av La Plata 1300', 'mayorista'),
(18, 'Training Pro', 'Ventas', 'ventas@trainingpro.com', '1122998877', 'Av Boedo 850', 'mayorista'),
(19, 'Moda Urbana', 'Mayorista', 'contacto@modaurbana.com', '1133887766', 'Av Acoyte 500', 'mayorista'),
(20, 'Deportes Sur', 'Compras', 'compras@deportessur.com', '1144776655', 'Av Pavon 3900', 'mayorista'),
(21, 'Outlet Deportivo', 'Ventas', 'ventas@outletdeportivo.com', '1155665544', 'Av Entre Rios 1100', 'mayorista');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depositos`
--

CREATE TABLE `depositos` (
  `id_deposito` int(11) NOT NULL,
  `lugar_deposito` enum('local','almacen') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `depositos`
--

INSERT INTO `depositos` (`id_deposito`, `lugar_deposito`) VALUES
(1, 'local'),
(2, 'almacen');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuentos`
--

CREATE TABLE `descuentos` (
  `id_descuento` int(11) NOT NULL,
  `nombre_descuento` varchar(45) NOT NULL,
  `porcentaje_descuento` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `descuentos`
--

INSERT INTO `descuentos` (`id_descuento`, `nombre_descuento`, `porcentaje_descuento`) VALUES
(3, 'Invierno', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles_ventas`
--

CREATE TABLE `detalles_ventas` (
  `id_detalle_venta` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fk_venta` int(11) NOT NULL,
  `fk_variante_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `detalles_ventas`
--

INSERT INTO `detalles_ventas` (`id_detalle_venta`, `cantidad`, `fk_venta`, `fk_variante_producto`) VALUES
(1, 1, 1, 1),
(2, 2, 2, 3),
(3, 3, 2, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envios`
--

CREATE TABLE `envios` (
  `id_envio` int(11) NOT NULL,
  `numero_seguimiento` varchar(45) NOT NULL,
  `estado` enum('pendiente','despachado','entregado') NOT NULL,
  `fecha_despacho` date DEFAULT NULL,
  `fk_venta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodos_de_pagos`
--

CREATE TABLE `metodos_de_pagos` (
  `id_metodo_de_pago` int(11) NOT NULL,
  `tipo` enum('efectivo','transferencia','debito') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `metodos_de_pagos`
--

INSERT INTO `metodos_de_pagos` (`id_metodo_de_pago`, `tipo`) VALUES
(1, 'efectivo'),
(2, 'debito'),
(3, 'transferencia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `nombre_producto` varchar(45) NOT NULL,
  `descripcion_producto` varchar(45) NOT NULL,
  `fk_categoria` int(11) NOT NULL,
  `fk_proveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre_producto`, `descripcion_producto`, `fk_categoria`, `fk_proveedor`) VALUES
(2, 'Camiseta Afa', 'Camiseta de la selección', 1, 2),
(3, 'Adidas Runfalcon', 'Zapatillas deportivas Adidas', 1, 3),
(4, 'Adidas Grand Court', 'Zapatillas urbanas Adidas', 2, 3),
(5, 'Remera Adidas Originals', 'Remera urbana Adidas', 2, 3),
(6, 'Remera Adidas Performance', 'Remera deportiva Adidas', 1, 3),
(7, 'Pantalon Adidas Tiro', 'Pantalon deportivo Adidas', 1, 3),
(8, 'Buzo Adidas Essentials', 'Buzo urbano Adidas', 2, 3),
(9, 'Campera Adidas Track', 'Campera deportiva Adidas', 1, 3),
(10, 'Short Adidas Training', 'Short deportivo Adidas', 1, 3),
(11, 'Gorra Adidas', 'Gorra urbana Adidas', 2, 3),
(12, 'Mochila Adidas', 'Mochila deportiva Adidas', 2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `nombreEmpresa` varchar(45) NOT NULL,
  `nombreContacto` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id_proveedor`, `nombreEmpresa`, `nombreContacto`, `telefono`, `correo`) VALUES
(1, 'SportMax', 'Santiago Contreras', '1122334455', 'mayonesa@Deajo.com'),
(2, 'Alma', 'Almita', '1555221133', 'alma@marsolier.com'),
(3, 'Adidas', 'Representante Adidas', '1122334455', 'contacto@adidas.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stocks`
--

CREATE TABLE `stocks` (
  `id_stock` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fk_deposito` int(11) NOT NULL,
  `fk_variante_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `stocks`
--

INSERT INTO `stocks` (`id_stock`, `cantidad`, `fk_deposito`, `fk_variante_producto`) VALUES
(1, 9, 1, 1),
(2, 5, 1, 2),
(3, 8, 2, 2),
(4, 2, 1, 3),
(5, 7, 2, 3),
(6, 3, 1, 4),
(7, 6, 2, 4),
(8, 4, 1, 5),
(9, 6, 2, 5),
(10, 5, 1, 6),
(11, 7, 2, 6),
(12, 3, 1, 7),
(13, 5, 2, 7),
(14, 8, 1, 8),
(15, 12, 2, 8),
(16, 4, 1, 9),
(17, 10, 2, 9),
(18, 6, 1, 10),
(19, 9, 2, 10),
(20, 5, 1, 11),
(21, 8, 2, 11),
(22, 6, 1, 12),
(23, 9, 2, 12),
(24, 4, 1, 13),
(25, 7, 2, 13),
(26, 5, 1, 14),
(27, 8, 2, 14),
(28, 6, 1, 15),
(29, 10, 2, 15),
(30, 4, 1, 16),
(31, 7, 2, 16),
(32, 4, 1, 17),
(33, 7, 2, 17),
(34, 5, 1, 18),
(35, 8, 2, 18),
(36, 3, 1, 19),
(37, 6, 2, 19),
(38, 3, 1, 20),
(39, 5, 2, 20),
(40, 4, 1, 21),
(41, 6, 2, 21),
(42, 2, 1, 22),
(43, 4, 2, 22),
(44, 6, 1, 23),
(45, 10, 2, 23),
(46, 5, 1, 24),
(47, 9, 2, 24),
(48, 4, 1, 25),
(49, 8, 2, 25),
(50, 10, 1, 26),
(51, 15, 2, 26),
(52, 8, 1, 27),
(53, 12, 2, 27),
(54, 5, 1, 28),
(55, 9, 2, 28),
(56, 4, 1, 29),
(57, 7, 2, 29);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(45) NOT NULL,
  `apellido_usuario` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `contrasenia` varchar(200) NOT NULL,
  `rol` enum('admin','cajero','repositor') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre_usuario`, `apellido_usuario`, `correo`, `contrasenia`, `rol`) VALUES
(1, 'Beison', 'Torres', 'beison@torres.com', '$2a$10$6b3BW.PqK7wlClZnOddDFukNOTfMMoGUKiM.8snO5S2aDwjIv9CFS', 'admin'),
(2, 'Diego', 'Balcazar', 'diego@balcazar.com', '$2a$10$ZzS9GlSO2Vsm5q9.qRWx7.D1JA3WFFps8ewmCYJZ1W65OZ17aPZUm', 'cajero'),
(3, 'Ian', 'Japan', 'ian@japan.com', '$2a$10$Zi6lwrMPLygCI1fA5A4Xbuhx/cMMEPo9Mvffcep6H3dlxL6Kl2BQS', 'repositor'),
(5, 'Santiago', 'Contreras', 'santi@contreras.com', '$2a$10$txnRRGFoztAbxA/ksID3r.RsVGRFXeETpmv.hEEoA.RYG5tnakeWW', 'cajero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `variantes_productos`
--

CREATE TABLE `variantes_productos` (
  `id_variante_producto` int(11) NOT NULL,
  `talle` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `precio_venta` double NOT NULL,
  `fk_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `variantes_productos`
--

INSERT INTO `variantes_productos` (`id_variante_producto`, `talle`, `color`, `precio_venta`, `fk_producto`) VALUES
(1, 'L', 'Blanco', 15000, 2),
(2, '39', 'Negro', 85000, 3),
(3, '40', 'Negro', 85000, 3),
(4, '41', 'Blanco', 85000, 3),
(5, '39', 'Blanco', 95000, 4),
(6, '40', 'Blanco', 95000, 4),
(7, '41', 'Negro', 95000, 4),
(8, 'S', 'Negro', 32000, 5),
(9, 'M', 'Negro', 32000, 5),
(10, 'L', 'Blanco', 32000, 5),
(11, 'S', 'Azul', 35000, 6),
(12, 'M', 'Azul', 35000, 6),
(13, 'L', 'Rojo', 35000, 6),
(14, 'S', 'Negro', 52000, 7),
(15, 'M', 'Negro', 52000, 7),
(16, 'L', 'Gris', 52000, 7),
(17, 'S', 'Negro', 68000, 8),
(18, 'M', 'Gris', 68000, 8),
(19, 'L', 'Azul', 68000, 8),
(20, 'S', 'Negro', 89000, 9),
(21, 'M', 'Negro', 89000, 9),
(22, 'L', 'Blanco', 89000, 9),
(23, 'S', 'Negro', 38000, 10),
(24, 'M', 'Azul', 38000, 10),
(25, 'L', 'Gris', 38000, 10),
(26, 'Unico', 'Negro', 25000, 11),
(27, 'Unico', 'Blanco', 25000, 11),
(28, 'Unico', 'Negro', 62000, 12),
(29, 'Unico', 'Azul', 62000, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `total_neto` double NOT NULL,
  `total_bruto` double NOT NULL,
  `fk_usuario` int(11) NOT NULL,
  `fk_cliente` int(11) NOT NULL,
  `fk_metodo_de_pago` int(11) NOT NULL,
  `fk_descuento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `fecha`, `total_neto`, `total_bruto`, `fk_usuario`, `fk_cliente`, `fk_metodo_de_pago`, `fk_descuento`) VALUES
(1, '2026-06-01 15:30:00', 12000, 15000, 2, 1, 1, 3),
(2, '2026-06-24 13:51:55', 266000, 266000, 2, 6, 2, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `auditorias_stocks`
--
ALTER TABLE `auditorias_stocks`
  ADD PRIMARY KEY (`id_auditoria_stock`),
  ADD UNIQUE KEY `id_auditoria_stock_UNIQUE` (`id_auditoria_stock`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id_categoria`),
  ADD UNIQUE KEY `id_categoria_UNIQUE` (`id_categoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `id_cliente_UNIQUE` (`id_cliente`);

--
-- Indices de la tabla `depositos`
--
ALTER TABLE `depositos`
  ADD PRIMARY KEY (`id_deposito`),
  ADD UNIQUE KEY `id_deposito_UNIQUE` (`id_deposito`);

--
-- Indices de la tabla `descuentos`
--
ALTER TABLE `descuentos`
  ADD PRIMARY KEY (`id_descuento`),
  ADD UNIQUE KEY `id_descuento_UNIQUE` (`id_descuento`);

--
-- Indices de la tabla `detalles_ventas`
--
ALTER TABLE `detalles_ventas`
  ADD PRIMARY KEY (`id_detalle_venta`),
  ADD UNIQUE KEY `id_detalle_venta_UNIQUE` (`id_detalle_venta`);

--
-- Indices de la tabla `envios`
--
ALTER TABLE `envios`
  ADD PRIMARY KEY (`id_envio`),
  ADD UNIQUE KEY `id_envio_UNIQUE` (`id_envio`);

--
-- Indices de la tabla `metodos_de_pagos`
--
ALTER TABLE `metodos_de_pagos`
  ADD PRIMARY KEY (`id_metodo_de_pago`),
  ADD UNIQUE KEY `id_metodo_de_pago_UNIQUE` (`id_metodo_de_pago`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD UNIQUE KEY `id_productos_UNIQUE` (`id_producto`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id_proveedor`),
  ADD UNIQUE KEY `id_proveedor_UNIQUE` (`id_proveedor`);

--
-- Indices de la tabla `stocks`
--
ALTER TABLE `stocks`
  ADD PRIMARY KEY (`id_stock`),
  ADD UNIQUE KEY `id_stock_UNIQUE` (`id_stock`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `id_usuario_UNIQUE` (`id_usuario`);

--
-- Indices de la tabla `variantes_productos`
--
ALTER TABLE `variantes_productos`
  ADD PRIMARY KEY (`id_variante_producto`),
  ADD UNIQUE KEY `id_variante_producto_UNIQUE` (`id_variante_producto`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`),
  ADD UNIQUE KEY `id_venta_UNIQUE` (`id_venta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `auditorias_stocks`
--
ALTER TABLE `auditorias_stocks`
  MODIFY `id_auditoria_stock` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `depositos`
--
ALTER TABLE `depositos`
  MODIFY `id_deposito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `descuentos`
--
ALTER TABLE `descuentos`
  MODIFY `id_descuento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `detalles_ventas`
--
ALTER TABLE `detalles_ventas`
  MODIFY `id_detalle_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `envios`
--
ALTER TABLE `envios`
  MODIFY `id_envio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `metodos_de_pagos`
--
ALTER TABLE `metodos_de_pagos`
  MODIFY `id_metodo_de_pago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `stocks`
--
ALTER TABLE `stocks`
  MODIFY `id_stock` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `variantes_productos`
--
ALTER TABLE `variantes_productos`
  MODIFY `id_variante_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
