-- Création de la Base de Données
CREATE DATABASE IF NOT EXISTS PlantesDB;
USE PlantesDB;

-- Création de la Table Utilisateurs
CREATE TABLE Utilisateurs (
                              Id INT PRIMARY KEY AUTO_INCREMENT,
                              Nom VARCHAR(100),
                              Email VARCHAR(100) UNIQUE,
                              MotDePasse VARCHAR(255),
                              Type ENUM('Utilisateur', 'Botaniste')
);

-- Création de la Table Botanistes
CREATE TABLE Botanistes (
                            IdUtilisateur INT,
                            Specialisation VARCHAR(100),
                            AnneesExperience INT,
                            FOREIGN KEY (IdUtilisateur) REFERENCES Utilisateurs(Id)
);

-- Création de la Table Plantes
CREATE TABLE Plantes (
                         IdPlante INT PRIMARY KEY AUTO_INCREMENT,
                         Nom VARCHAR(100),
                         Type VARCHAR(100),
                         InstructionsSoin TEXT,
                         IdUtilisateur INT,
                         FOREIGN KEY (IdUtilisateur) REFERENCES Utilisateurs(Id)
);

-- Création de la Table Conseils
CREATE TABLE Conseils (
                          IdConseil INT PRIMARY KEY AUTO_INCREMENT,
                          Contenu TEXT,
                          IdBotaniste INT,
                          IdPlante INT,
                          FOREIGN KEY (IdBotaniste) REFERENCES Botanistes(IdUtilisateur),
                          FOREIGN KEY (IdPlante) REFERENCES Plantes(IdPlante)
);

-- Création de la Table Sessions de Garde
CREATE TABLE SessionsGarde (
                               IdSession INT PRIMARY KEY AUTO_INCREMENT,
                               IdPlante INT,
                               IdGardien INT,
                               DateDebut DATE,
                               DateFin DATE,
                               Commentaires TEXT,
                               FOREIGN KEY (IdPlante) REFERENCES Plantes(IdPlante),
                               FOREIGN KEY (IdGardien) REFERENCES Utilisateurs(Id)
);


-- Insertion dans la Table Utilisateurs
INSERT INTO Utilisateurs (Nom, Email, MotDePasse, Type) VALUES
                                                            ('Alice Dupont', 'alice@example.com', 'password123', 'Utilisateur'),
                                                            ('Bob Martin', 'bob@example.com', 'password123', 'Botaniste');

-- Insertion dans la Table Botanistes
INSERT INTO Botanistes (IdUtilisateur, Specialisation, AnneesExperience) VALUES
    (2, 'Botanique tropicale', 5);

-- Insertion dans la Table Plantes
INSERT INTO Plantes (Nom, Type, InstructionsSoin, IdUtilisateur) VALUES
                                                                     ('Ficus', 'Plante d’intérieur', 'Arroser une fois par semaine', 1),
                                                                     ('Orchidée', 'Fleur', 'Exposer à la lumière indirecte', 1);

-- Insertion dans la Table Conseils
INSERT INTO Conseils (Contenu, IdBotaniste, IdPlante) VALUES
    ('Utilisez un terreau pour orchidées pour un meilleur drainage', 2, 2);

-- Insertion dans la Table Sessions de Garde
INSERT INTO SessionsGarde (IdPlante, IdGardien, DateDebut, DateFin, Commentaires) VALUES
    (1, 2, '2024-01-01', '2024-01-07', 'Plante bien entretenue');
