USE DSS_Project;

INSERT INTO Campeonato VALUES 
    (1, `Mundial na Europa`, `Corridas1`, 26431587 ),
    (2, `Volta a Portugal`, `Corridas2`, 87243561),
    (3, `Europeu`, `Corridas3`, 74183256);
    
INSERT INTO Carro VALUES 
    (1, 1, 30, 102, 24, `toyota`, `corolla`),
    (2, 1, 40, 140, 34, `peugeot`, `clio`),
    (3, 0, 24, 239, 70, `opel`, `corsa`),
    (4, 1, 84, 350, 89, `seat`, `ibiza`),
    (5, 0, 55, 310, 88, `golf`, `gti`),
    (6, 1, 72, 324, 90, `bwm`, `serie1`),
    (7, 0, 61, 193, 45, `toyota`, `auris`),
    (8, 0, 29, 129, 56, `mini`, `cooper`);

INSERT INTO Piloto VALUES 
    (1, `Antonio`, 3.24, 2.52),
    (2, `Pedro`, 2.91, 3.12),
    (3, `José`, 1.24, 2.43),

INSERT INTO Circuito VALUES 
    (1, 4, 24, 4, 5, 7);
    (2, 6, 31, 6, 9, 10);
    (3, 5, 28, 5, 7, 8);
    (4, 3, 20, 3, 4, 7);
    (5, 5, 43, 6, 8, 9);
    (6, 5, 34, 5, 6, 9);

INSERT INTO Utilizador VALUES 
    (1, `Joao`, 1234, 1)
    (2, `Jose`, 1234, 0),
    (3, `Alex`, 1234, 1);
    (4, `Pedro`, 1234, 1);
    (5, `Maria`, 1234, 0);
    (6, `Teresa`, 1234, 1);
    (7, `Marco`, 1234, 0);
    (8, `Andre`, 1234, 1);