-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-01-2017 a las 23:44:09
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `liga`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `id_equipo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `web` varchar(250) DEFAULT 'sin web oficial',
  `puntos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`id_equipo`, `nombre`, `ciudad`, `web`, `puntos`) VALUES
(1, 'Regal Barcelona', 'Barcelona', 'http://www.fcbarcelona.com/web/index_idiomes.html', 10),
(2, 'Real Madrid', 'Madrid', 'http://www.realmadrid.com/cs/Satellite/es/1193040472450/SubhomeEquipo/Baloncesto.htm', 9),
(3, 'P.E. Valencia', 'Valencia', 'http://www.valenciabasket.com/', 11),
(4, 'Caja Laboral', 'Vitoria', 'http://www.baskonia.com/prehomes/prehomes.asp?id_prehome=69', 22),
(5, 'Gran Canaria', 'Las Palmas', 'http://www.acb.com/club.php?id=CLA', 14),
(6, 'CAI Zaragoza', 'Zaragoza', 'http://basketzaragoza.net/', 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `id_jugador` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `puesto` varchar(45) NOT NULL,
  `id_capitan` int(11) DEFAULT NULL,
  `fecha_alta` datetime DEFAULT NULL,
  `salario` int(11) DEFAULT NULL,
  `equipo` int(11) DEFAULT NULL,
  `altura` decimal(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`id_jugador`, `nombre`, `apellido`, `puesto`, `id_capitan`, `fecha_alta`, `salario`, `equipo`, `altura`) VALUES
(1, 'Juan Carlos', 'Navarro', 'Escolta', 1, '2010-01-10 00:00:00', 130000, 1, '1.96'),
(2, 'Felipe', 'Reyes', 'Pivot', 2, '2009-02-20 00:00:00', 132000, 2, '2.04'),
(3, 'Victor', 'Claver', 'Alero', 4, '2009-03-08 00:00:00', 99000, 3, '2.08'),
(4, 'Rafa ', 'Martinez', 'Ala-pivot', 4, '2010-11-11 00:00:00', 51000, 3, '1.91'),
(5, 'Fernando', 'San Emeterio', 'Alero', 6, '2008-09-22 00:00:00', 60000, 4, '1.99'),
(6, 'Mirza', 'Teletovic', 'Pivot', 6, '2010-05-13 00:00:00', 77000, 4, '2.06'),
(7, 'Sergio ', 'Llull', 'Escolta', 2, '2011-10-29 00:00:00', 100000, 2, '1.90'),
(8, 'Victor ', 'Sada', 'Base', 1, '2012-01-01 00:00:00', 80000, 1, '1.92'),
(9, 'Carlos', 'Suarez', 'Alero', 2, '2011-02-19 00:00:00', 66000, 2, '2.03'),
(10, 'Xavi ', 'Rey', 'Pivot', 14, '2008-10-12 00:00:00', 104500, 5, '2.09'),
(11, 'Carlos ', 'Cabezas', 'Base', 13, '2012-01-21 00:00:00', 105000, 6, '1.86'),
(12, 'Pablo ', 'Aguilar', 'Alero', 13, '2011-06-14 00:00:00', 51700, 6, '2.03'),
(13, 'Rafa', 'Hettsheimeir', 'Pivot', 13, '2008-04-15 00:00:00', 58300, 6, '2.08'),
(14, 'Sitapha', 'Savané', 'Pivot', 14, '2011-07-27 00:00:00', 66000, 5, '2.01'),
(15, 'Willy', 'Hernangomez', 'Ala-pivot', 2, '2012-01-01 00:00:00', 4000, 2, '2.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidos`
--

CREATE TABLE `partidos` (
  `id_partido` int(11) NOT NULL,
  `elocal` int(11) NOT NULL,
  `evisitante` int(11) NOT NULL,
  `resultado` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `arbitro` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `partidos`
--

INSERT INTO `partidos` (`id_partido`, `elocal`, `evisitante`, `resultado`, `fecha`, `arbitro`) VALUES
(1, 1, 2, '101-100', '2011-10-10', '4\r'),
(2, 2, 3, '90-91', '2011-11-17', '5\r'),
(3, 3, 4, '88-77', '2011-11-23', '6\r'),
(4, 1, 6, '80-78', '2011-11-30', '6\r'),
(5, 2, 4, '90-90', '2012-01-12', '7\r'),
(6, 4, 1, '79-83', '2012-01-19', '3\r'),
(7, 3, 6, '91-88', '2012-02-22', '6'),
(8, 5, 4, '90-66', '2012-04-27', '2\r'),
(9, 6, 5, '110-70', '2012-05-30', '1'),
(10, 3, 5, '88-77', '2011-09-01', '6');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`id_equipo`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`);

--
-- Indices de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`id_jugador`),
  ADD KEY `fequipo` (`equipo`);

--
-- Indices de la tabla `partidos`
--
ALTER TABLE `partidos`
  ADD PRIMARY KEY (`id_partido`),
  ADD KEY `flocal` (`elocal`),
  ADD KEY `fvisitante` (`evisitante`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `partidos`
--
ALTER TABLE `partidos`
  MODIFY `id_partido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD CONSTRAINT `fequipo` FOREIGN KEY (`equipo`) REFERENCES `equipos` (`id_equipo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `partidos`
--
ALTER TABLE `partidos`
  ADD CONSTRAINT `flocal` FOREIGN KEY (`elocal`) REFERENCES `equipos` (`id_equipo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fvisitante` FOREIGN KEY (`evisitante`) REFERENCES `equipos` (`id_equipo`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
