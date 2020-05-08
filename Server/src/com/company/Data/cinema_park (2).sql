-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Май 07 2020 г., 23:44
-- Версия сервера: 10.3.13-MariaDB-log
-- Версия PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `cinema_park`
--

-- --------------------------------------------------------

--
-- Структура таблицы `hall`
--

CREATE TABLE `hall` (
  `idOfHall` int(9) NOT NULL,
  `occupied` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hall`
--

INSERT INTO `hall` (`idOfHall`, `occupied`) VALUES
(1, 0),
(2, 0);

-- --------------------------------------------------------

--
-- Структура таблицы `movies`
--

CREATE TABLE `movies` (
  `cinema_id` int(9) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sheduleOfMovies` varchar(50) NOT NULL,
  `cost` int(9) NOT NULL,
  `idOfHall` int(11) NOT NULL,
  `moviesIdOfUsers` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `movies`
--

INSERT INTO `movies` (`cinema_id`, `name`, `sheduleOfMovies`, `cost`, `idOfHall`, `moviesIdOfUsers`) VALUES
(1, 'Platform', '19:00-21:00', 1900, 1, 1),
(2, 'Avengers', '17:00-19:00', 1690, 1, 1),
(3, 'Rings of Lord', '10:00-12:00', 2000, 1, 1),
(4, 'DareDevil', '12:10-13:00', 500, 1, 1),
(11, 'Inception', '14:00-16:00', 1200, 2, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `person`
--

CREATE TABLE `person` (
  `id` int(9) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `position` varchar(50) NOT NULL,
  `cash` int(11) DEFAULT NULL,
  `movies_id` int(9) DEFAULT 1,
  `numberOfTickets` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `person`
--

INSERT INTO `person` (`id`, `password`, `name`, `surname`, `position`, `cash`, `movies_id`, `numberOfTickets`) VALUES
(1, 'qwerty', 'Mahabbat', 'Khamzina', 'cashier', 3390, 1, NULL),
(3, 'qwerty', 'Mukagali', 'Tokmurzin', 'admin', NULL, 1, NULL),
(4, 'qwerty', 'Almas', 'Almasovich', 'checker', NULL, 1, NULL),
(9, 'qwerty', 'Toma', 'Doma', 'cashier', 0, 1, NULL),
(10, 'qwerty', 'Ibra', 'Zaza', 'checker', NULL, 1, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `tickets`
--

CREATE TABLE `tickets` (
  `tickets_id` int(9) NOT NULL,
  `nameOfMovie` varchar(50) NOT NULL,
  `idOfHall` int(9) NOT NULL,
  `sheduleOfMovies` varchar(50) NOT NULL,
  `cost` int(9) NOT NULL,
  `ifChecked` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tickets`
--

INSERT INTO `tickets` (`tickets_id`, `nameOfMovie`, `idOfHall`, `sheduleOfMovies`, `cost`, `ifChecked`) VALUES
(1, 'Platform', 1, '19:00-21:00', 0, 1),
(2, 'Avengers', 1, '17:00-19:00', 0, 1),
(3, 'Rings of Lord', 1, '10:00-12:00', 2000, 0),
(4, 'Rings of Lord', 1, '10:00-12:00', 2000, 0),
(5, 'Avengers', 1, '17:00-19:00', 1690, 0),
(6, 'DareDevil', 1, '12:10-13:00', 500, 0),
(7, 'DareDevil', 1, '12:10-13:00', 500, 0),
(8, 'Inception', 2, '14:00-16:00', 1200, 1);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`cinema_id`);

--
-- Индексы таблицы `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`tickets_id`) USING BTREE;

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `movies`
--
ALTER TABLE `movies`
  MODIFY `cinema_id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT для таблицы `person`
--
ALTER TABLE `person`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT для таблицы `tickets`
--
ALTER TABLE `tickets`
  MODIFY `tickets_id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
