-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.39 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Copiando estrutura para tabela locadora.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora.category: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela locadora.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora.customer: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela locadora.dvd
CREATE TABLE IF NOT EXISTS `dvd` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `classification` varchar(45) NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `dvd_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora.dvd: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela locadora.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  `hire_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora.employee: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela locadora.rental
CREATE TABLE IF NOT EXISTS `rental` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rental_date` datetime NOT NULL,
  `return_date` datetime DEFAULT NULL,
  `customer_id` int NOT NULL,
  `dvd_id` int NOT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `dvd_id` (`dvd_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `rental_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rental_ibfk_2` FOREIGN KEY (`dvd_id`) REFERENCES `dvd` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `rental_ibfk_3` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora.rental: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela locadora.tb_jutsu
CREATE TABLE IF NOT EXISTS `tb_jutsu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `dificuldade` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora.tb_jutsu: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela locadora.tb_missoes
CREATE TABLE IF NOT EXISTS `tb_missoes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `dificuldade` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora.tb_missoes: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela locadora.tb_ninja
CREATE TABLE IF NOT EXISTS `tb_ninja` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cla` varchar(255) DEFAULT NULL,
  `idade` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `missao_id` bigint DEFAULT NULL,
  `vila_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7eht8wm4n5ctjhm5uxdmqvxah` (`missao_id`),
  KEY `FKryuxylh402gdkiikbrtlgtaf8` (`vila_id`),
  CONSTRAINT `FK7eht8wm4n5ctjhm5uxdmqvxah` FOREIGN KEY (`missao_id`) REFERENCES `tb_missoes` (`id`),
  CONSTRAINT `FKryuxylh402gdkiikbrtlgtaf8` FOREIGN KEY (`vila_id`) REFERENCES `tb_vila` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora.tb_ninja: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela locadora.tb_ninja_jutsu
CREATE TABLE IF NOT EXISTS `tb_ninja_jutsu` (
  `ninja_id` bigint NOT NULL,
  `jutsu_id` bigint NOT NULL,
  KEY `FKcccyyebgyxwg5dpx42imqmbl2` (`jutsu_id`),
  KEY `FKi1lgla4r28c8nng2pxswhfib4` (`ninja_id`),
  CONSTRAINT `FKcccyyebgyxwg5dpx42imqmbl2` FOREIGN KEY (`jutsu_id`) REFERENCES `tb_jutsu` (`id`),
  CONSTRAINT `FKi1lgla4r28c8nng2pxswhfib4` FOREIGN KEY (`ninja_id`) REFERENCES `tb_ninja` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora.tb_ninja_jutsu: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela locadora.tb_vila
CREATE TABLE IF NOT EXISTS `tb_vila` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `numero_habitantes` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela locadora.tb_vila: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
