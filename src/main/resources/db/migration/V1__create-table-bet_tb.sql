CREATE TABLE bet_tb(
    id bigint(20) NOT NULL AUTO_INCREMENT UNIQUE,
    jogo varchar(200) NOT NULL,
    bet varchar(500) NOT NULL,
    PRIMARY KEY (id)
);