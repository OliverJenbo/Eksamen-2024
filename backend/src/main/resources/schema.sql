DROP TABLE IF EXISTS competition_athlete;
DROP TABLE IF EXISTS athlete;
DROP TABLE IF EXISTS competition;

CREATE TABLE IF NOT EXISTS competition
(
    id
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) NOT NULL,
    date DATE NOT NULL
    );

CREATE TABLE IF NOT EXISTS athlete
(
    id
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) NOT NULL,
    email VARCHAR
(
    255
) NOT NULL,
    invited BOOLEAN DEFAULT FALSE,
    accepted BOOLEAN DEFAULT FALSE,
    checked_in BOOLEAN DEFAULT FALSE
    );

CREATE TABLE IF NOT EXISTS competition_athlete
(
    competition_id
    INT
    NOT
    NULL,
    athlete_id
    INT
    NOT
    NULL,
    PRIMARY
    KEY
(
    competition_id,
    athlete_id
),
    FOREIGN KEY
(
    competition_id
) REFERENCES competition
(
    id
),
    FOREIGN KEY
(
    athlete_id
) REFERENCES athlete
(
    id
)
    );
