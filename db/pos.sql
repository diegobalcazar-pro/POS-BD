-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-06-2026 a las 17:20:52
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

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
(1, 'Remeras'),
(2, 'Pantalones'),
(3, 'Buzos');

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
(1, 'Santiago', 'Contreras', 'santiago@gmail.com', '12345678', 'Venezuela', 'minorista');

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
(1, 'Descuento de talles', 25),
(2, 'Descuento mayorista', 10);

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

--
-- Volcado de datos para la tabla `envios`
--

INSERT INTO `envios` (`id_envio`, `numero_seguimiento`, `estado`, `fecha_despacho`, `fk_venta`) VALUES
(1, '123456789', 'pendiente', '2026-05-31', 1);

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
(2, 'transferencia'),
(3, 'debito');

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
(1, 'DaVinci 2026', 'Remera de DaVinci 2026', 1, 1);

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
(1, 'Adibas', 'Gamaliel', '12345678', 'gamaliel@adibas.com');

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
(1, 100, 1, 1),
(2, 100, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(45) NOT NULL,
  `apellido_usuario` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `contrasenia` varchar(255) NOT NULL,
  `rol` enum('admin','cajero','repositor') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre_usuario`, `apellido_usuario`, `correo`, `contrasenia`, `rol`) VALUES
(1, 'Matias', 'Castro', 'matias@tienda.com', '$2a$10$VG1d8BxlN1O5jBEM5krjoeOWpBADv6LkKAJIz.MdK6HgcAuOI1bRy', 'repositor'),
(2, 'Pepe', 'Sech', 'pepe@tienda.com', '$2a$10$kOuVTlm/Qmmyt3ZCkMmo8OQfU0TYo4xsnLgYMMgSUIA2Q.yhK9sIq', 'cajero');

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
(1, 'XL', 'Negro', 10000, 1),
(2, 'XL', 'Blanco', 10000, 1);

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
(1, '2026-05-29 00:00:00', 10000, 9000, 2, 1, 1, 1);

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
  MODIFY `id_auditoria_stock` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `depositos`
--
ALTER TABLE `depositos`
  MODIFY `id_deposito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `descuentos`
--
ALTER TABLE `descuentos`
  MODIFY `id_descuento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detalles_ventas`
--
ALTER TABLE `detalles_ventas`
  MODIFY `id_detalle_venta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `envios`
--
ALTER TABLE `envios`
  MODIFY `id_envio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `metodos_de_pagos`
--
ALTER TABLE `metodos_de_pagos`
  MODIFY `id_metodo_de_pago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `stocks`
--
ALTER TABLE `stocks`
  MODIFY `id_stock` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `variantes_productos`
--
ALTER TABLE `variantes_productos`
  MODIFY `id_variante_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
