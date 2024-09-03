
START TRANSACTION;
SET time_zone = "+00:00";




CREATE TABLE Client(
   idclient VARCHAR(50),
   Nomclient VARCHAR(50) NOT NULL,
   Adressemail VARCHAR(50),
   numeroTel INT,
   motdepasse VARCHAR(50),
   PRIMARY KEY(idclient),
   UNIQUE(Adressemail),
   UNIQUE(numeroTel),
   UNIQUE(motdepasse)
);

CREATE TABLE Operations(
   idoperations VARCHAR(50),
   montant DOUBLE NOT NULL,
   statutop VARCHAR(50) NOT NULL,
   typeoperation VARCHAR(50) NOT NULL,
   comptedest VARCHAR(50),
   compterecep VARCHAR(50),
   dateop DATETIME NOT NULL,
   PRIMARY KEY(idoperations),
   UNIQUE(comptedest),
   UNIQUE(compterecep)
);

CREATE TABLE Compte(
   idcompte VARCHAR(50),
   typecompte VARCHAR(50) NOT NULL,
   soldecompte DOUBLE,
   dateouverture DATETIME NOT NULL,
   idoperations VARCHAR(50) NOT NULL,
   idclient VARCHAR(50) NOT NULL,
   PRIMARY KEY(idcompte),
   FOREIGN KEY(idoperations) REFERENCES Operations(idoperations),
   FOREIGN KEY(idclient) REFERENCES Client(idclient)
);

CREATE TABLE Banquier(
   idbanquier VARCHAR(50),
   nombanquier VARCHAR(50),
   motdepasse VARCHAR(50),
   idoperations VARCHAR(50) NOT NULL,
   PRIMARY KEY(idbanquier),
   UNIQUE(motdepasse),
   FOREIGN KEY(idoperations) REFERENCES Operations(idoperations)
);
