-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 25 fév. 2019 à 08:40
-- Version du serveur :  10.1.36-MariaDB
-- Version de PHP :  7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `magasin`
--

-- --------------------------------------------------------

--
-- Structure de la table `chaussure`
--

CREATE TABLE `chaussure` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  `prixunitaire` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `fournisseur` varchar(50) DEFAULT NULL,
  `couleur` varchar(50) DEFAULT NULL,
  `marque` varchar(50) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `pointure` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `chaussure`
--

INSERT INTO `chaussure` (`id`, `libelle`, `prixunitaire`, `quantite`, `fournisseur`, `couleur`, `marque`, `genre`, `pointure`, `type`) VALUES
(1, 'Airmax', 265.2, 130, 'Mehrez fripe', 'Gris', 'Nike', 'Homme', 42, NULL),
(2, 'Adidas 3 bondes', 90, 120, 'Mehrez fripe', 'rose', 'Adidas', 'Femme', 38, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `datecmd` date DEFAULT NULL,
  `statutcmd` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `datecmd`, `statutcmd`) VALUES
(1, '2019-02-05', 'confirmed'),
(2, '2019-02-12', 'not confirmed'),
(3, '2019-02-14', 'away'),
(5, '2019-02-18', 'en cours');

-- --------------------------------------------------------

--
-- Structure de la table `frigo`
--

CREATE TABLE `frigo` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  `prixunitaire` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `fournisseur` varchar(50) DEFAULT NULL,
  `ratingconsommation` int(11) DEFAULT NULL,
  `capacite` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `frigo`
--

INSERT INTO `frigo` (`id`, `libelle`, `prixunitaire`, `quantite`, `fournisseur`, `ratingconsommation`, `capacite`) VALUES
(1, 'Samsung', 1080.5, 50, 'Moncef bey', 3, 13);

-- --------------------------------------------------------

--
-- Structure de la table `fruit`
--

CREATE TABLE `fruit` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  `prixunitaire` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `fournisseur` varchar(50) DEFAULT NULL,
  `saison` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fruit`
--

INSERT INTO `fruit` (`id`, `libelle`, `prixunitaire`, `quantite`, `fournisseur`, `saison`) VALUES
(1, 'Fraise', 3200, 700, 'Marché centrale', 'été'),
(2, 'Pomme Vert', 2100, 300, 'Marché centrale', 'hiver');

-- --------------------------------------------------------

--
-- Structure de la table `laitier`
--

CREATE TABLE `laitier` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  `prixunitaire` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `fournisseur` varchar(50) DEFAULT NULL,
  `datefab` date DEFAULT NULL,
  `dateexp` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `laitier`
--

INSERT INTO `laitier` (`id`, `libelle`, `prixunitaire`, `quantite`, `fournisseur`, `datefab`, `dateexp`) VALUES
(1, 'yaourt', 222, 5, 'delice', '2019-02-06', '2019-02-13');

-- --------------------------------------------------------

--
-- Structure de la table `lignecommande`
--

CREATE TABLE `lignecommande` (
  `idarticle` int(11) NOT NULL,
  `idcmd` int(11) NOT NULL,
  `typearticle` varchar(50) NOT NULL,
  `quantite` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lignecommande`
--

INSERT INTO `lignecommande` (`idarticle`, `idcmd`, `typearticle`, `quantite`) VALUES
(1, 5, 'fruit', 5),
(2, 5, 'fruit', 3);

-- --------------------------------------------------------

--
-- Structure de la table `pull`
--

CREATE TABLE `pull` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  `prixunitaire` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `fournisseur` varchar(50) DEFAULT NULL,
  `couleur` varchar(50) DEFAULT NULL,
  `marque` varchar(50) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `taille` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pull`
--

INSERT INTO `pull` (`id`, `libelle`, `prixunitaire`, `quantite`, `fournisseur`, `couleur`, `marque`, `genre`, `taille`, `type`) VALUES
(1, 'cobra t-shirt', 45, 200, 'Mehrez frip', 'noir', 'lacost', 'femme', '36', 'TOP'),
(2, 'dragon t-shirt', 60, 250, 'Mehrez frip', 'bleu', 'lacost', 'homme', '36', 'TOP'),
(3, 'test', 0, 55, 'salah fripe', 'dark', 'lenovo', 'doublepus', 'M', 'typetest'),
(4, 'test', 0, 55, 'salah fripe', 'dark', 'lenovo', 'doublepus', 'M', 'typetest'),
(5, 'test', 0, 55, 'salah fripe', 'dark', 'lenovo', 'doublepus', 'M', 'typetest'),
(6, 'test', 0, 55, 'salah fripe', 'dark', 'lenovo', 'doublepus', 'M', 'typetest'),
(7, 'test', 0, 55, 'salah fripe', 'dark', 'lenovo', 'doublepus', 'M', 'typetest');

-- --------------------------------------------------------

--
-- Structure de la table `tv`
--

CREATE TABLE `tv` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  `prixunitaire` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `fournisseur` varchar(50) DEFAULT NULL,
  `ratingconsommation` int(11) DEFAULT NULL,
  `resolution` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tv`
--

INSERT INTO `tv` (`id`, `libelle`, `prixunitaire`, `quantite`, `fournisseur`, `ratingconsommation`, `resolution`) VALUES
(1, 'TVoNE', 850, 300, 'Samsung', 4, 30),
(3, 'TVThree', 2500, 100, 'LG', 6, 80);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `chaussure`
--
ALTER TABLE `chaussure`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `frigo`
--
ALTER TABLE `frigo`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `fruit`
--
ALTER TABLE `fruit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `laitier`
--
ALTER TABLE `laitier`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD PRIMARY KEY (`idarticle`,`idcmd`,`typearticle`),
  ADD KEY `fk_ligne_cmd` (`idcmd`);

--
-- Index pour la table `pull`
--
ALTER TABLE `pull`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `tv`
--
ALTER TABLE `tv`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `chaussure`
--
ALTER TABLE `chaussure`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `frigo`
--
ALTER TABLE `frigo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `fruit`
--
ALTER TABLE `fruit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `laitier`
--
ALTER TABLE `laitier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `pull`
--
ALTER TABLE `pull`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `tv`
--
ALTER TABLE `tv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD CONSTRAINT `fk_ligne_cmd` FOREIGN KEY (`idcmd`) REFERENCES `commande` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
