-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 21 août 2023 à 15:45
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `restaurant_kedjenou`
--

-- --------------------------------------------------------

--
-- Structure de la table `commandes`
--

DROP TABLE IF EXISTS `commandes`;
CREATE TABLE IF NOT EXISTS `commandes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `menu` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `qte` int(11) DEFAULT NULL,
  `prixU` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `Facture` varchar(255) DEFAULT NULL,
  `dateHeure` varchar(255) DEFAULT NULL,
  `table_` varchar(255) DEFAULT NULL,
  `serveur` varchar(255) DEFAULT NULL,
  `caissier` varchar(255) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `code_vente` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commandes`
--

INSERT INTO `commandes` (`id`, `type`, `menu`, `designation`, `qte`, `prixU`, `total`, `Facture`, `dateHeure`, `table_`, `serveur`, `caissier`, `statut`, `code_vente`) VALUES
(1, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 1, 1200, 1200, 'Facture : 2023_08_01_Fact006', '2023-08-14 02:17:51', 'Table 1', 'Smith Jane', 'Djamal', 'Impayé', 'Vente_Facture : 2023_08_01_Fact006'),
(2, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 1, 1200, 1200, 'Facture : 2023_08_01_Fact006', '2023-08-15 02:25:45', 'Table 3', 'Smith Jane', 'Djamal', 'Impayé', 'Vente_Facture : 2023_08_01_Fact006'),
(3, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 1, 1200, 1200, 'Facture : 2023_08_01_Fact006', '2023-08-18 02:48:59', 'Table 3', 'Smith Jane', 'Djamal', 'Impayé', 'Vente_Facture : 2023_08_01_Fact006'),
(4, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 1, 1200, 1200, 'Facture : 2023_08_01_Fact006', '2023-08-18 02:51:42', 'Table 1', 'Smith Jane', 'Djamal', 'Impayé', 'Vente_Facture : 2023_08_01_Fact006');

-- --------------------------------------------------------

--
-- Structure de la table `report`
--

DROP TABLE IF EXISTS `report`;
CREATE TABLE IF NOT EXISTS `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chemin` varchar(255) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `report`
--

INSERT INTO `report` (`id`, `chemin`, `type`) VALUES
(1, 'D:\\DJAMAL\\Logiciel_Java\\RestaurantKedjenou\\src\\Receipt\\solderApresAvoirManger', 'type1'),
(2, 'D:\\DJAMAL\\Logiciel_Java\\RestaurantKedjenou\\src\\Receipt\\solderEmporter', 'type2');

-- --------------------------------------------------------

--
-- Structure de la table `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `menu` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `qte` int(11) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `date_ajout` date DEFAULT NULL,
  `personneConnectee` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `stock`
--

INSERT INTO `stock` (`id`, `type`, `menu`, `designation`, `qte`, `prix`, `date_ajout`, `personneConnectee`, `image_path`) VALUES
(1, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 1500000, 1200, '2023-08-10', 'Djamal TOE', 'D:\\DJAMAL\\djamsDev\\pythonProject\\monRestau\\images\\Attieke_Poisson_Maquérot.png');

-- --------------------------------------------------------

--
-- Structure de la table `type_menu`
--

DROP TABLE IF EXISTS `type_menu`;
CREATE TABLE IF NOT EXISTS `type_menu` (
  `id` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `menu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_menu`
--

INSERT INTO `type_menu` (`id`, `type`, `menu`) VALUES
(3, 'Nourriture', 'Resistance'),
(4, 'Nourriture', 'Couscous'),
(5, 'Nourriture', 'Soupes'),
(6, 'Nourriture', 'Pâtes Alimentaires'),
(7, 'Nourriture', 'Entrées'),
(8, 'Nourriture', 'Grillades'),
(9, 'Nourriture', 'Desserts'),
(10, 'Boissons', 'Gazeuses'),
(11, 'Boissons', 'Jus'),
(12, 'Boissons', 'Vins'),
(13, 'Boissons', 'Champagnes'),
(14, 'Boissons', 'Café & Thé');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matricule` varchar(250) DEFAULT NULL,
  `nom` varchar(250) DEFAULT NULL,
  `prenom` varchar(250) DEFAULT NULL,
  `dateNaissance` date DEFAULT NULL,
  `utilisateur` varchar(250) DEFAULT NULL,
  `motDePasse` varchar(250) DEFAULT NULL,
  `numero` varchar(100) NOT NULL,
  `poste` varchar(250) DEFAULT NULL,
  `numeroSOS` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `matricule`, `nom`, `prenom`, `dateNaissance`, `utilisateur`, `motDePasse`, `numero`, `poste`, `numeroSOS`) VALUES
(1, '123456', 'Doe', 'John', '1990-01-01', 'john.doe', 'password123', '', 'caissier', ''),
(2, '789012', 'Smith', 'Jane', '1985-05-10', 'jane.smith', 'adminpass', '', 'serveur', ''),
(4, 'E03566120201', 'TOE', 'Djamal', '2023-05-11', 'djamaltoe012@gmail.com', 'admin', '65 80 54 72', 'admin', '48 42 97 72'),
(10, 'AAAAAAAA1', 'SUPERUSER', 'Super User', '2023-05-25', 'admin', 'admin', '65 80 54 72', 'admin', '69 66 33 20'),
(8, 'AAAAAAAA', 'SUPERUSER', 'Super User', '2023-05-25', 'admin', 'admin', '65 80 54 72', 'admin', '69 66 33 20'),
(9, 'BBBBBBBBB', 'EMP01', 'Emp 01', '2023-05-25', 'emp001', 'emp001', '66 55 22 00', 'serveur', '66 55 22 00');

-- --------------------------------------------------------

--
-- Structure de la table `ventes`
--

DROP TABLE IF EXISTS `ventes`;
CREATE TABLE IF NOT EXISTS `ventes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `menu` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `qte` int(11) DEFAULT NULL,
  `prixUnitaire` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `facture` varchar(255) DEFAULT NULL,
  `montantRemis` double DEFAULT NULL,
  `monnaie` double DEFAULT NULL,
  `modeDePaiement` varchar(255) DEFAULT NULL,
  `caissier` varchar(255) DEFAULT NULL,
  `serveur` varchar(255) DEFAULT NULL,
  `date_vente` date DEFAULT NULL,
  `heure` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ventes`
--

INSERT INTO `ventes` (`id`, `type`, `menu`, `designation`, `qte`, `prixUnitaire`, `total`, `facture`, `montantRemis`, `monnaie`, `modeDePaiement`, `caissier`, `serveur`, `date_vente`, `heure`) VALUES
(1, 'Nourriture', 'Dîner', 'Steak Grillé', 1, 20, 20, 'F004', 25, 5, 'Carte', 'Alice', 'John', '2023-08-20', '19:30'),
(2, 'Boissons', 'Boissons non alcoolisées', 'Eau Minérale', 4, 1, 4, 'F004', 10, 6, 'Espèces', 'Bob', 'Jane', '2023-08-20', '20:00'),
(3, 'Nourriture', 'Petit-déjeuner', 'Omelette', 1, 8, 8, 'F005', 10, 2, 'Carte', 'Alice', 'John', '2023-08-21', '09:15'),
(4, 'Nourriture', 'Déjeuner', 'Pâtes Carbonara', 2, 12, 24, 'F005', 30, 6, 'Espèces', 'Bob', 'Jane', '2023-08-21', '12:45'),
(5, 'Boissons', 'Boissons alcoolisées', 'Bières', 3, 3.5, 10.5, 'F005', 15, 4.5, 'Espèces', 'Alice', 'John', '2023-08-21', '19:00'),
(6, 'Nourriture', 'Dîner', 'Poisson Grillé', 1, 18, 18, 'F006', 50000, 2, 'Carte', 'Alice', 'John', '2023-08-22', '20:15'),
(7, 'Boissons', 'Boissons non alcoolisées', 'Thé', 2, 1.5, 3, 'F006', 500000, 2, 'Espèces', 'Bob', 'Jane', '2023-08-22', '21:30'),
(8, 'Nourriture', 'Petit-déjeuner', 'Pancakes', 3, 6, 18, 'F007', 20, 2, 'Carte', 'Alice', 'John', '2023-08-23', '08:45'),
(9, 'Nourriture', 'Déjeuner', 'Burger', 1, 10, 10, 'F007', 15, 5, 'Espèces', 'Bob', 'Jane', '2023-08-23', '13:00'),
(10, 'Boissons', 'Boissons alcoolisées', 'Cocktails', 2, 7, 14, 'F007', 20, 6, 'Carte', 'Alice', 'John', '2023-08-23', '19:45'),
(11, 'Nourriture', 'Dîner', 'Lasagnes', 1, 14, 14, 'F010', 15, 1, 'Carte', 'Alice', 'John', '2023-08-25', '19:00'),
(12, 'Boissons', 'Boissons non alcoolisées', 'Café', 2, 2, 4, 'F010', 5, 1, 'Espèces', 'Bob', 'Jane', '2023-08-25', '20:30'),
(13, 'Nourriture', 'Petit-déjeuner', 'Toast', 1, 1.5, 1.5, 'F011', 5, 3.5, 'Carte', 'Alice', 'John', '2023-08-26', '08:15'),
(14, 'Nourriture', 'Déjeuner', 'Salade Grecque', 2, 9, 18, 'F011', 20, 2, 'Carte', 'Alice', 'John', '2023-08-26', '12:45'),
(15, 'Boissons', 'Boissons alcoolisées', 'Vin Blanc', 1, 10, 10, 'F011', 15, 5, 'Espèces', 'Bob', 'Jane', '2023-08-26', '19:30');

-- --------------------------------------------------------

--
-- Structure de la table `ventes_tempon`
--

DROP TABLE IF EXISTS `ventes_tempon`;
CREATE TABLE IF NOT EXISTS `ventes_tempon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `menu` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `qte` int(11) DEFAULT NULL,
  `prixUnitaire` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `facture` varchar(255) DEFAULT NULL,
  `montantRemis` double DEFAULT NULL,
  `monnaie` double DEFAULT NULL,
  `modeDePaiement` varchar(255) DEFAULT NULL,
  `caissier` varchar(255) DEFAULT NULL,
  `serveur` varchar(255) DEFAULT NULL,
  `date_vente` date DEFAULT NULL,
  `heure` varchar(255) DEFAULT NULL,
  `code_vente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ventes_tempon`
--

INSERT INTO `ventes_tempon` (`id`, `type`, `menu`, `designation`, `qte`, `prixUnitaire`, `total`, `facture`, `montantRemis`, `monnaie`, `modeDePaiement`, `caissier`, `serveur`, `date_vente`, `heure`, `code_vente`) VALUES
(10, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 1, 1200, 1200, 'Facture : 2023_08_01_Fact006', 0, 0, 'NONE', 'Djamal', 'Smith Jane', '2023-08-18', '02:48:59', 'Vente_Facture : 2023_08_01_Fact006'),
(4, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 5, 1200, 6000, 'Facture : 2023_08_01_Fact006', 0, 0, 'NONE', 'Djamal', 'Smith Jane', '2023-08-13', '08:48:01', 'Vente_Facture : 2023_08_01_Fact006'),
(5, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 3, 1200, 3600, 'Facture : 2023_08_01_Fact006', 0, 0, 'NONE', 'Djamal', 'Smith Jane', '2023-08-13', '08:50:01', 'Vente_Facture : 2023_08_01_Fact006'),
(6, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 7, 1200, 8400, 'Facture : 2023_08_01_Fact006', 0, 0, 'NONE', 'Djamal', 'Smith Jane', '2023-08-13', '09:05:24', 'Vente_Facture : 2023_08_01_Fact006'),
(7, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 1, 1200, 1200, 'Facture : 2023_08_01_Fact006', 0, 0, 'NONE', 'Djamal', 'Smith Jane', '2023-08-14', '02:15:31', 'Vente_Facture : 2023_08_01_Fact006'),
(8, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 1, 1200, 1200, 'Facture : 2023_08_01_Fact006', 0, 0, 'NONE', 'Djamal', 'Smith Jane', '2023-08-14', '02:17:51', 'Vente_Facture : 2023_08_01_Fact006'),
(9, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 1, 1200, 1200, 'Facture : 2023_08_01_Fact006', 0, 0, 'NONE', 'Djamal', 'Smith Jane', '2023-08-15', '02:25:45', 'Vente_Facture : 2023_08_01_Fact006'),
(11, 'Nourriture', 'Resistance', 'Attiéké Poisson Frit', 1, 1200, 1200, 'Facture : 2023_08_01_Fact006', 0, 0, 'NONE', 'Djamal', 'Smith Jane', '2023-08-18', '02:51:42', 'Vente_Facture : 2023_08_01_Fact006');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
