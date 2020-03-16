CREATE TABLE games (
    id INT(11) NOT NULL AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    publisher VARCHAR(150),
    genre VARCHAR(150),
    platform VARCHAR(50) NOT NULL,
    release_date DATE NOT NULL,
    franchise VARCHAR(150),
    CONSTRAINT game_pk PRIMARY KEY (id)
);
INSERT INTO games (
    title,
    publisher,
    genre,
    platform,
    release_date,
    franchise
)
VALUES ('Total War: Warhammer II', 'SEGA', 'Strategy', 'Windows', '2017-11-28', 'Total War');
INSERT INTO games (
    title,
    publisher,
    genre,
    platform,
    release_date,
    franchise
)
VALUES ('God of War', 'Sony', 'Action', 'PlayStation 4', '2018-04-20', 'God of War');
INSERT INTO games (
    title,
    genre,
    platform,
    release_date
)
VALUES ('Minecraft', 'Adventure', 'Windows', '2011-11-18');
INSERT INTO games (
    title,
    publisher,
    genre,
    platform,
    release_date,
    franchise
)
VALUES ('Fire Emblem: Three Houses', 'Nintendo', 'Strategy', 'Nintendo Switch', '2019-07-26', 'Fire Emblem');
INSERT INTO games (
    title,
    publisher,
    genre,
    platform,
    release_date
)
VALUES ('Tabletop Simulator', 'Berserk Games', 'Casual', 'Windows', '2015-06-05');