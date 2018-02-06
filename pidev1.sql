-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 06 fév. 2018 à 17:47
-- Version du serveur :  10.1.30-MariaDB
-- Version de PHP :  5.6.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pidev1`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresses`
--

CREATE TABLE `adresses` (
  `id_addresses` int(11) NOT NULL,
  `titre` int(11) NOT NULL,
  `ville` int(11) NOT NULL,
  `rue` int(11) NOT NULL,
  `code_postal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `astuces`
--

CREATE TABLE `astuces` (
  `id_astuces` int(11) NOT NULL,
  `libelle` int(11) NOT NULL,
  `description_astuces` varchar(1000) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cabinet`
--

CREATE TABLE `cabinet` (
  `id_cabinet` int(11) NOT NULL,
  `adresse_cabinet` int(11) NOT NULL,
  `num_tel_cabinet` int(11) NOT NULL,
  `horaire_ouverture_cabinet` time NOT NULL,
  `horaire_fermeture_cabinet` time NOT NULL,
  `id_resp_cabinet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `carte_bancaire`
--

CREATE TABLE `carte_bancaire` (
  `id_carte` int(11) NOT NULL,
  `num_carte` int(11) NOT NULL,
  `proprietaire` int(11) NOT NULL,
  `date_expiration` date NOT NULL,
  `pass_carte` int(11) NOT NULL,
  `solde` float NOT NULL,
  `banque` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `centre_esthetique`
--

CREATE TABLE `centre_esthetique` (
  `id_centre_esth` int(11) NOT NULL,
  `nom_centre_esth` varchar(255) NOT NULL,
  `adresse_centre_esth` int(11) NOT NULL,
  `tel_centre_esth` int(11) NOT NULL,
  `horaire_ouverture_centre` time NOT NULL,
  `horaire_fermeture_centre` time NOT NULL,
  `id_resp_cente_esth` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `coach`
--

CREATE TABLE `coach` (
  `id_coach` int(11) NOT NULL,
  `nom_coach` varchar(255) NOT NULL,
  `prenom_coach` varchar(255) NOT NULL,
  `job_coach` varchar(255) NOT NULL,
  `id_coach_salle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id_commande` int(11) NOT NULL,
  `date_commande` date NOT NULL,
  `etat_commande` varchar(40) NOT NULL,
  `prix_commande` float NOT NULL,
  `quantite_commande` int(11) NOT NULL,
  `id_commande_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cours_sport`
--

CREATE TABLE `cours_sport` (
  `id_cours` int(11) NOT NULL,
  `nom_cours` varchar(255) NOT NULL,
  `prix_cours` float NOT NULL,
  `heure_cours` time NOT NULL,
  `id_coach_cours` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emploi`
--

CREATE TABLE `emploi` (
  `id_emploi` int(11) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `id_travail` int(11) NOT NULL,
  `description_travail` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `estheticienne`
--

CREATE TABLE `estheticienne` (
  `id_esth` int(11) NOT NULL,
  `nom_esth` varchar(255) NOT NULL,
  `prenom_esth` varchar(255) NOT NULL,
  `specialite_esth` varchar(255) NOT NULL,
  `id_centre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `even_form`
--

CREATE TABLE `even_form` (
  `id_event` int(11) NOT NULL,
  `nom_event` varchar(255) NOT NULL,
  `genre_event` varchar(255) NOT NULL,
  `date_event` datetime NOT NULL,
  `lieu_event` varchar(255) NOT NULL,
  `duree_event` int(11) NOT NULL,
  `type_event` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fiche_medicale`
--

CREATE TABLE `fiche_medicale` (
  `id_fiche` int(11) NOT NULL,
  `sexe` varchar(10) NOT NULL,
  `taille` int(11) NOT NULL,
  `poids` int(11) NOT NULL,
  `groupe_sanguin` varchar(4) NOT NULL,
  `pression_arterielle` int(11) NOT NULL,
  `tabac` varchar(3) NOT NULL,
  `alcool` varchar(3) NOT NULL,
  `date_naissance` date NOT NULL,
  `IMC` float NOT NULL,
  `battement_coeur` int(11) NOT NULL,
  `respiration` float NOT NULL,
  `temperature` int(11) NOT NULL,
  `allergie` varchar(30) NOT NULL,
  `id_fiche_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

CREATE TABLE `livraison` (
  `id_livraison` int(11) NOT NULL,
  `date_livraison` date NOT NULL,
  `adresse_livraison` int(11) NOT NULL,
  `id_livraison_commande` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `maladie`
--

CREATE TABLE `maladie` (
  `id_maladie` int(11) NOT NULL,
  `nom_maladie` int(11) NOT NULL,
  `description_maladie` varchar(255) NOT NULL,
  `traitement` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

CREATE TABLE `panier` (
  `id_panier` int(11) NOT NULL,
  `date_panier` date NOT NULL,
  `id_produit_panier` int(11) NOT NULL,
  `quantite_produit_panier` int(11) NOT NULL,
  `id_commande_panier` int(11) NOT NULL,
  `id_panier_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `paquet`
--

CREATE TABLE `paquet` (
  `id_packet` int(11) NOT NULL,
  `nom_packet` varchar(255) NOT NULL,
  `prix_packet` float NOT NULL,
  `contenu_packet` varchar(255) NOT NULL,
  `id_packet_centre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `parapharmacie`
--

CREATE TABLE `parapharmacie` (
  `id_para` int(11) NOT NULL,
  `nom_para` varchar(255) NOT NULL,
  `adresse_para` int(11) NOT NULL,
  `num_tel_para` int(11) NOT NULL,
  `email_para` varchar(255) NOT NULL,
  `horaire_ouverture_para` time NOT NULL,
  `horaire_fermeture_para` time NOT NULL,
  `id_resp_para` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pharmacie`
--

CREATE TABLE `pharmacie` (
  `id_pharma` int(11) NOT NULL,
  `nom_pharma` varchar(255) NOT NULL,
  `adresse_pharma` int(11) NOT NULL,
  `num_tel_pharma` int(11) NOT NULL,
  `email_pharma` int(11) NOT NULL,
  `horaire_ouverture_pharma` time NOT NULL,
  `horaire_fermeture_pharma` time NOT NULL,
  `id_resp_pharma` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `prestataire_service`
--

CREATE TABLE `prestataire_service` (
  `id_prest` int(11) NOT NULL,
  `nom_prest` varchar(255) NOT NULL,
  `prenom_prest` varchar(255) NOT NULL,
  `age_prest` int(11) NOT NULL,
  `num_tel_prest` bigint(20) NOT NULL,
  `adresse_prest` int(11) NOT NULL,
  `email_prest` varchar(255) NOT NULL,
  `login_prest` varchar(255) NOT NULL,
  `mdp_prest` varchar(255) NOT NULL,
  `enligne_prest` varchar(255) NOT NULL,
  `etat_prest` varchar(255) NOT NULL,
  `fonction` varchar(255) NOT NULL,
  `specialite` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_produit` int(11) NOT NULL,
  `prix_produit` float NOT NULL,
  `quantite_produit` int(11) NOT NULL,
  `description_produit` varchar(30) NOT NULL,
  `categorie_produit` varchar(30) NOT NULL,
  `id_produit_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

CREATE TABLE `rdv` (
  `id_rdv` int(11) NOT NULL,
  `date_rdv` datetime NOT NULL,
  `id_lieu` int(11) NOT NULL,
  `etat_rdv` varchar(255) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle_de_sport`
--

CREATE TABLE `salle_de_sport` (
  `id_salle` int(11) NOT NULL,
  `adresse_salle` int(11) NOT NULL,
  `nom_salle` varchar(255) NOT NULL,
  `num_tel_salle` int(11) NOT NULL,
  `email_salle` varchar(255) NOT NULL,
  `horaire_ouverture_salle` time NOT NULL,
  `horaire_fermeture_salle` time NOT NULL,
  `id_resp_salle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `soins`
--

CREATE TABLE `soins` (
  `id_soins` int(11) NOT NULL,
  `nom_soins` varchar(255) NOT NULL,
  `prix_soins` float NOT NULL,
  `hammam` varchar(255) NOT NULL,
  `maquillage` varchar(255) NOT NULL,
  `manicure` varchar(255) NOT NULL,
  `coiffure` varchar(255) NOT NULL,
  `id_esth_soins` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `travail`
--

CREATE TABLE `travail` (
  `id_trav` int(11) NOT NULL,
  `id_salle_trav` int(11) NOT NULL,
  `id_centre_trav` int(11) NOT NULL,
  `id_cab_trav` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id_u` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `adresse_u` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `num_tel` bigint(20) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enligne` varchar(255) NOT NULL,
  `etat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adresses`
--
ALTER TABLE `adresses`
  ADD PRIMARY KEY (`id_addresses`),
  ADD UNIQUE KEY `id_addresses` (`id_addresses`);

--
-- Index pour la table `astuces`
--
ALTER TABLE `astuces`
  ADD PRIMARY KEY (`id_astuces`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `cabinet`
--
ALTER TABLE `cabinet`
  ADD PRIMARY KEY (`id_cabinet`),
  ADD KEY `id_resp_cabinet` (`id_resp_cabinet`),
  ADD KEY `adresse_cabinet` (`adresse_cabinet`);

--
-- Index pour la table `carte_bancaire`
--
ALTER TABLE `carte_bancaire`
  ADD PRIMARY KEY (`id_carte`),
  ADD KEY `proprietaire` (`proprietaire`);

--
-- Index pour la table `centre_esthetique`
--
ALTER TABLE `centre_esthetique`
  ADD PRIMARY KEY (`id_centre_esth`),
  ADD KEY `id_cente_esth_resp` (`id_resp_cente_esth`),
  ADD KEY `adresse_centre_esth` (`adresse_centre_esth`);

--
-- Index pour la table `coach`
--
ALTER TABLE `coach`
  ADD PRIMARY KEY (`id_coach`),
  ADD KEY `id_coach_salle` (`id_coach_salle`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id_commande`),
  ADD KEY `id_commande_user` (`id_commande_user`);

--
-- Index pour la table `cours_sport`
--
ALTER TABLE `cours_sport`
  ADD PRIMARY KEY (`id_cours`),
  ADD KEY `id_coach_cours` (`id_coach_cours`);

--
-- Index pour la table `emploi`
--
ALTER TABLE `emploi`
  ADD PRIMARY KEY (`id_emploi`),
  ADD KEY `description_travail` (`description_travail`),
  ADD KEY `id_travail` (`id_travail`);

--
-- Index pour la table `estheticienne`
--
ALTER TABLE `estheticienne`
  ADD PRIMARY KEY (`id_esth`),
  ADD KEY `id_centre` (`id_centre`);

--
-- Index pour la table `even_form`
--
ALTER TABLE `even_form`
  ADD PRIMARY KEY (`id_event`);

--
-- Index pour la table `fiche_medicale`
--
ALTER TABLE `fiche_medicale`
  ADD PRIMARY KEY (`id_fiche`),
  ADD KEY `id_fiche_user` (`id_fiche_user`);

--
-- Index pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD KEY `id_livraison_commande` (`id_livraison_commande`),
  ADD KEY `adresse_livraison` (`adresse_livraison`);

--
-- Index pour la table `maladie`
--
ALTER TABLE `maladie`
  ADD PRIMARY KEY (`id_maladie`);

--
-- Index pour la table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`id_panier`),
  ADD KEY `id_produit_panier` (`id_produit_panier`),
  ADD KEY `id_panier_user` (`id_panier_user`),
  ADD KEY `id_commande_panier` (`id_commande_panier`);

--
-- Index pour la table `paquet`
--
ALTER TABLE `paquet`
  ADD PRIMARY KEY (`id_packet`),
  ADD KEY `id_packet_centre` (`id_packet_centre`);

--
-- Index pour la table `parapharmacie`
--
ALTER TABLE `parapharmacie`
  ADD PRIMARY KEY (`id_para`),
  ADD KEY `id_resp_para` (`id_resp_para`),
  ADD KEY `adresse_para` (`adresse_para`);

--
-- Index pour la table `pharmacie`
--
ALTER TABLE `pharmacie`
  ADD PRIMARY KEY (`id_pharma`),
  ADD KEY `id_resp_pharma` (`id_resp_pharma`),
  ADD KEY `adresse_pharma` (`adresse_pharma`);

--
-- Index pour la table `prestataire_service`
--
ALTER TABLE `prestataire_service`
  ADD PRIMARY KEY (`id_prest`),
  ADD UNIQUE KEY `id_prest` (`id_prest`),
  ADD KEY `adresse_prest` (`adresse_prest`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`),
  ADD KEY `id_produit_user` (`id_produit_user`);

--
-- Index pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD PRIMARY KEY (`id_rdv`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `salle_de_sport`
--
ALTER TABLE `salle_de_sport`
  ADD PRIMARY KEY (`id_salle`),
  ADD KEY `adresse_salle` (`adresse_salle`),
  ADD KEY `id_salle_resp` (`id_resp_salle`);

--
-- Index pour la table `soins`
--
ALTER TABLE `soins`
  ADD PRIMARY KEY (`id_soins`),
  ADD KEY `id_esth_soins` (`id_esth_soins`);

--
-- Index pour la table `travail`
--
ALTER TABLE `travail`
  ADD PRIMARY KEY (`id_trav`),
  ADD KEY `id_salle_trav` (`id_salle_trav`),
  ADD KEY `id_centre_trav` (`id_centre_trav`),
  ADD KEY `id_cab_trav` (`id_cab_trav`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id_u`),
  ADD UNIQUE KEY `id_u` (`id_u`),
  ADD KEY `adresse_u` (`adresse_u`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adresses`
--
ALTER TABLE `adresses`
  MODIFY `id_addresses` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `astuces`
--
ALTER TABLE `astuces`
  MODIFY `id_astuces` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `cabinet`
--
ALTER TABLE `cabinet`
  MODIFY `id_cabinet` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `carte_bancaire`
--
ALTER TABLE `carte_bancaire`
  MODIFY `id_carte` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `centre_esthetique`
--
ALTER TABLE `centre_esthetique`
  MODIFY `id_centre_esth` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `coach`
--
ALTER TABLE `coach`
  MODIFY `id_coach` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id_commande` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `cours_sport`
--
ALTER TABLE `cours_sport`
  MODIFY `id_cours` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `emploi`
--
ALTER TABLE `emploi`
  MODIFY `id_emploi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `estheticienne`
--
ALTER TABLE `estheticienne`
  MODIFY `id_esth` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `even_form`
--
ALTER TABLE `even_form`
  MODIFY `id_event` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `fiche_medicale`
--
ALTER TABLE `fiche_medicale`
  MODIFY `id_fiche` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `maladie`
--
ALTER TABLE `maladie`
  MODIFY `id_maladie` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `panier`
--
ALTER TABLE `panier`
  MODIFY `id_panier` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `paquet`
--
ALTER TABLE `paquet`
  MODIFY `id_packet` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `parapharmacie`
--
ALTER TABLE `parapharmacie`
  MODIFY `id_para` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pharmacie`
--
ALTER TABLE `pharmacie`
  MODIFY `id_pharma` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `prestataire_service`
--
ALTER TABLE `prestataire_service`
  MODIFY `id_prest` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `rdv`
--
ALTER TABLE `rdv`
  MODIFY `id_rdv` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `salle_de_sport`
--
ALTER TABLE `salle_de_sport`
  MODIFY `id_salle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `soins`
--
ALTER TABLE `soins`
  MODIFY `id_soins` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `travail`
--
ALTER TABLE `travail`
  MODIFY `id_trav` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id_u` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `astuces`
--
ALTER TABLE `astuces`
  ADD CONSTRAINT `astuces_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id_u`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `cabinet`
--
ALTER TABLE `cabinet`
  ADD CONSTRAINT `cabinet_ibfk_1` FOREIGN KEY (`adresse_cabinet`) REFERENCES `adresses` (`id_addresses`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cabinet_ibfk_2` FOREIGN KEY (`id_resp_cabinet`) REFERENCES `prestataire_service` (`id_prest`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `carte_bancaire`
--
ALTER TABLE `carte_bancaire`
  ADD CONSTRAINT `carte_bancaire_ibfk_1` FOREIGN KEY (`proprietaire`) REFERENCES `utilisateur` (`id_u`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `centre_esthetique`
--
ALTER TABLE `centre_esthetique`
  ADD CONSTRAINT `centre_esthetique_ibfk_1` FOREIGN KEY (`id_resp_cente_esth`) REFERENCES `prestataire_service` (`id_prest`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `centre_esthetique_ibfk_2` FOREIGN KEY (`adresse_centre_esth`) REFERENCES `adresses` (`id_addresses`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `coach`
--
ALTER TABLE `coach`
  ADD CONSTRAINT `coach_ibfk_1` FOREIGN KEY (`id_coach_salle`) REFERENCES `salle_de_sport` (`id_salle`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`id_commande_user`) REFERENCES `utilisateur` (`id_u`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `cours_sport`
--
ALTER TABLE `cours_sport`
  ADD CONSTRAINT `cours_sport_ibfk_1` FOREIGN KEY (`id_coach_cours`) REFERENCES `coach` (`id_coach`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `emploi`
--
ALTER TABLE `emploi`
  ADD CONSTRAINT `emploi_ibfk_1` FOREIGN KEY (`id_travail`) REFERENCES `travail` (`id_trav`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `estheticienne`
--
ALTER TABLE `estheticienne`
  ADD CONSTRAINT `estheticienne_ibfk_1` FOREIGN KEY (`id_centre`) REFERENCES `centre_esthetique` (`id_centre_esth`);

--
-- Contraintes pour la table `fiche_medicale`
--
ALTER TABLE `fiche_medicale`
  ADD CONSTRAINT `fiche_medicale_ibfk_1` FOREIGN KEY (`id_fiche_user`) REFERENCES `utilisateur` (`id_u`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD CONSTRAINT `livraison_ibfk_1` FOREIGN KEY (`id_livraison_commande`) REFERENCES `commande` (`id_commande`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `livraison_ibfk_2` FOREIGN KEY (`adresse_livraison`) REFERENCES `adresses` (`id_addresses`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `panier_ibfk_1` FOREIGN KEY (`id_commande_panier`) REFERENCES `commande` (`id_commande`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `panier_ibfk_2` FOREIGN KEY (`id_produit_panier`) REFERENCES `produit` (`id_produit`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `panier_ibfk_3` FOREIGN KEY (`id_panier_user`) REFERENCES `utilisateur` (`id_u`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `paquet`
--
ALTER TABLE `paquet`
  ADD CONSTRAINT `paquet_ibfk_1` FOREIGN KEY (`id_packet`) REFERENCES `centre_esthetique` (`id_centre_esth`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `parapharmacie`
--
ALTER TABLE `parapharmacie`
  ADD CONSTRAINT `parapharmacie_ibfk_1` FOREIGN KEY (`adresse_para`) REFERENCES `adresses` (`id_addresses`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `parapharmacie_ibfk_2` FOREIGN KEY (`id_resp_para`) REFERENCES `prestataire_service` (`id_prest`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `pharmacie`
--
ALTER TABLE `pharmacie`
  ADD CONSTRAINT `pharmacie_ibfk_1` FOREIGN KEY (`adresse_pharma`) REFERENCES `adresses` (`id_addresses`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pharmacie_ibfk_2` FOREIGN KEY (`id_resp_pharma`) REFERENCES `prestataire_service` (`id_prest`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `prestataire_service`
--
ALTER TABLE `prestataire_service`
  ADD CONSTRAINT `prestataire_service_ibfk_1` FOREIGN KEY (`adresse_prest`) REFERENCES `adresses` (`id_addresses`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`id_produit_user`) REFERENCES `utilisateur` (`id_u`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `rdv_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id_u`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `salle_de_sport`
--
ALTER TABLE `salle_de_sport`
  ADD CONSTRAINT `salle_de_sport_ibfk_1` FOREIGN KEY (`adresse_salle`) REFERENCES `adresses` (`id_addresses`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `salle_de_sport_ibfk_2` FOREIGN KEY (`id_resp_salle`) REFERENCES `prestataire_service` (`id_prest`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `soins`
--
ALTER TABLE `soins`
  ADD CONSTRAINT `soins_ibfk_1` FOREIGN KEY (`id_esth_soins`) REFERENCES `estheticienne` (`id_esth`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`adresse_u`) REFERENCES `adresses` (`id_addresses`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
