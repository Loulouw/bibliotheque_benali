-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 25 oct. 2018 à 02:56
-- Version du serveur :  10.1.32-MariaDB
-- Version de PHP :  7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bibliotheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

CREATE TABLE `auteur` (
  `id` int(11) NOT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `nom` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `auteur`
--

INSERT INTO `auteur` (`id`, `prenom`, `nom`) VALUES
(1, 'Victor', 'Hugo'),
(2, 'Charles', 'Baudelaire'),
(3, 'Albert', 'Camus'),
(4, 'Guy', 'De Maupassant');

-- --------------------------------------------------------

--
-- Structure de la table `auteur_has_oeuvre`
--

CREATE TABLE `auteur_has_oeuvre` (
  `auteur_id` int(11) NOT NULL,
  `oeuvre_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `auteur_has_oeuvre`
--

INSERT INTO `auteur_has_oeuvre` (`auteur_id`, `oeuvre_id`) VALUES
(1, 2),
(2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

CREATE TABLE `emprunt` (
  `id` int(11) NOT NULL,
  `date_emprunt` datetime NOT NULL,
  `date_retour` datetime NOT NULL,
  `date_rendu` datetime DEFAULT NULL,
  `emprunt_rendu` int(11) NOT NULL DEFAULT '0',
  `id_usager` int(11) NOT NULL,
  `id_exemplaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `emprunt`
--

INSERT INTO `emprunt` (`id`, `date_emprunt`, `date_retour`, `date_rendu`, `emprunt_rendu`, `id_usager`, `id_exemplaire`) VALUES
(3, '2018-10-25 02:46:01', '2018-11-25 02:46:01', NULL, 0, 1, 11),
(4, '2018-10-25 02:46:52', '2018-11-25 02:46:52', '2018-10-25 02:55:01', 1, 1, 12),
(5, '2018-10-25 02:55:19', '2018-11-25 02:55:19', NULL, 0, 1, 12);

-- --------------------------------------------------------

--
-- Structure de la table `etat`
--

CREATE TABLE `etat` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etat`
--

INSERT INTO `etat` (`id`, `libelle`) VALUES
(2, 'Abimé'),
(3, 'Détruit'),
(1, 'Neuf');

-- --------------------------------------------------------

--
-- Structure de la table `exemplaire`
--

CREATE TABLE `exemplaire` (
  `id` int(11) NOT NULL,
  `id_oeuvre` int(11) NOT NULL,
  `id_etat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `exemplaire`
--

INSERT INTO `exemplaire` (`id`, `id_oeuvre`, `id_etat`) VALUES
(11, 1, 1),
(12, 1, 1),
(13, 1, 1),
(14, 1, 1),
(15, 1, 1),
(16, 1, 1),
(17, 1, 1),
(18, 1, 1),
(19, 1, 1),
(20, 1, 1),
(21, 1, 1),
(22, 1, 1),
(23, 1, 1),
(24, 1, 1),
(25, 1, 1),
(26, 1, 1),
(27, 1, 1),
(28, 1, 1),
(29, 1, 1),
(30, 2, 1),
(31, 2, 1),
(32, 2, 1),
(33, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre`
--

CREATE TABLE `oeuvre` (
  `id` int(11) NOT NULL,
  `titre` varchar(100) NOT NULL,
  `ISBN` varchar(100) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `nb_resa` int(11) NOT NULL DEFAULT '0',
  `id_type_oeuvre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `oeuvre`
--

INSERT INTO `oeuvre` (`id`, `titre`, `ISBN`, `date_creation`, `nb_resa`, `id_type_oeuvre`) VALUES
(1, 'albatros', '651615619', '1841-01-25 00:50:39', 0, 2),
(2, 'Les contemplations', '744547777', '1856-10-25 00:50:39', 0, 2);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `date_reservation` datetime NOT NULL,
  `reservation_annule` int(11) NOT NULL DEFAULT '0',
  `id_usager` int(11) NOT NULL,
  `id_oeuvre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `type_oeuvre`
--

CREATE TABLE `type_oeuvre` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_oeuvre`
--

INSERT INTO `type_oeuvre` (`id`, `libelle`) VALUES
(2, 'Livre'),
(1, 'Magazine');

-- --------------------------------------------------------

--
-- Structure de la table `usager`
--

CREATE TABLE `usager` (
  `id` int(11) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `commune` varchar(250) NOT NULL,
  `date_naissance` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `usager`
--

INSERT INTO `usager` (`id`, `prenom`, `nom`, `commune`, `date_naissance`) VALUES
(1, 'Louis', 'Zwawiak', 'Nancy', '1996-12-15 00:00:00'),
(2, 'Maxime', 'Kubasiak', 'Nancy', '1997-10-15 00:00:00'),
(3, 'Laura', 'Ledieu', 'Nancy', '1998-10-24 00:00:00'),
(4, 'Peter', 'Boursier', 'Nancy', '1996-11-04 00:00:00'),
(7, 'Bryan', 'Grant', 'ludres', '2018-10-25 00:00:00');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `auteur`
--
ALTER TABLE `auteur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Index pour la table `auteur_has_oeuvre`
--
ALTER TABLE `auteur_has_oeuvre`
  ADD PRIMARY KEY (`auteur_id`,`oeuvre_id`),
  ADD KEY `fk_auteur_has_oeuvre_oeuvre1_idx` (`oeuvre_id`),
  ADD KEY `fk_auteur_has_oeuvre_auteur1_idx` (`auteur_id`);

--
-- Index pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_emprunt_usager1_idx` (`id_usager`),
  ADD KEY `fk_emprunt_exemplaire1_idx` (`id_exemplaire`);

--
-- Index pour la table `etat`
--
ALTER TABLE `etat`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD UNIQUE KEY `libelle_UNIQUE` (`libelle`),
  ADD UNIQUE KEY `UK_45vn30743cvcgisl96slwganc` (`libelle`);

--
-- Index pour la table `exemplaire`
--
ALTER TABLE `exemplaire`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_exemplaire_oeuvre1_idx` (`id_oeuvre`),
  ADD KEY `fk_exemplaire_etat1_idx` (`id_etat`);

--
-- Index pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_oeuvre_type_oeuvre1_idx` (`id_type_oeuvre`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_reservation_usager1_idx` (`id_usager`),
  ADD KEY `fk_reservation_oeuvre1_idx` (`id_oeuvre`);

--
-- Index pour la table `type_oeuvre`
--
ALTER TABLE `type_oeuvre`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD UNIQUE KEY `libelle_UNIQUE` (`libelle`),
  ADD UNIQUE KEY `UK_4evxbdilk5f2d6621ib0r3axe` (`libelle`);

--
-- Index pour la table `usager`
--
ALTER TABLE `usager`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `auteur`
--
ALTER TABLE `auteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `emprunt`
--
ALTER TABLE `emprunt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `etat`
--
ALTER TABLE `etat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `exemplaire`
--
ALTER TABLE `exemplaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `type_oeuvre`
--
ALTER TABLE `type_oeuvre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `usager`
--
ALTER TABLE `usager`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `auteur_has_oeuvre`
--
ALTER TABLE `auteur_has_oeuvre`
  ADD CONSTRAINT `fk_auteur_has_oeuvre_auteur1` FOREIGN KEY (`auteur_id`) REFERENCES `auteur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_auteur_has_oeuvre_oeuvre1` FOREIGN KEY (`oeuvre_id`) REFERENCES `oeuvre` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `fk_emprunt_exemplaire1` FOREIGN KEY (`id_exemplaire`) REFERENCES `exemplaire` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_emprunt_usager1` FOREIGN KEY (`id_usager`) REFERENCES `usager` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `exemplaire`
--
ALTER TABLE `exemplaire`
  ADD CONSTRAINT `fk_exemplaire_etat1` FOREIGN KEY (`id_etat`) REFERENCES `etat` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_exemplaire_oeuvre1` FOREIGN KEY (`id_oeuvre`) REFERENCES `oeuvre` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD CONSTRAINT `fk_oeuvre_type_oeuvre1` FOREIGN KEY (`id_type_oeuvre`) REFERENCES `type_oeuvre` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fk_reservation_oeuvre1` FOREIGN KEY (`id_oeuvre`) REFERENCES `oeuvre` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reservation_usager1` FOREIGN KEY (`id_usager`) REFERENCES `usager` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
