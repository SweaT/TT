INSERT INTO teams (id, name, country)
VALUES ('11111111-1e06-4403-b240-fc3879a31c6a',
        'Дудочки',
        'Беларусь');
INSERT INTO teams (id, name, country)
VALUES ('22222222-1e06-4403-b240-fc3879a31c6a',
        'Белоручка',
        'Молдова');
INSERT INTO teams (id, name, country)
VALUES ('33333333-1e06-4403-b240-fc3879a31c6a',
        'Зенит',
        'Россия');



INSERT INTO players (id, name, country, team)
VALUES ('31111111-1e06-4403-b240-fc3879a31c6b',
        'Саня',
        'Россия',
        '33333333-1e06-4403-b240-fc3879a31c6a');
INSERT INTO players (id, name, country, team)
VALUES ('32111111-1e06-4403-b240-fc3879a31c6a',
        'Илюха',
        'Россия',
        '33333333-1e06-4403-b240-fc3879a31c6a');
INSERT INTO players (id, name, country, team)
VALUES ('33111111-1e06-4403-b240-fc3879a31c6a',
        'Антон Александрович уважаемый чебурек',
        'Россия',
        '33333333-1e06-4403-b240-fc3879a31c6a');

INSERT INTO players (id, name, country, team)
VALUES ('21111111-1e06-4403-b240-fc3879a31c6a',
        'Калыван',
        'Молдова',
        '22222222-1e06-4403-b240-fc3879a31c6a');
INSERT INTO players (id, name, country, team)
VALUES ('22111111-1e06-4403-b240-fc3879a31c6a',
        'Марджанджа',
        'Молдова',
        '22222222-1e06-4403-b240-fc3879a31c6a');
INSERT INTO players (id, name, country, team)
VALUES ('23111111-1e06-4403-b240-fc3879a31c6a',
        'Простой Иван',
        'Молдова',
        '22222222-1e06-4403-b240-fc3879a31c6a');

INSERT INTO players (id, name, country, team)
VALUES ('11111110-1e06-4403-b240-fc3879a31c6a',
        'Бацька',
        'Беларусь',
        '11111111-1e06-4403-b240-fc3879a31c6a');
INSERT INTO players (id, name, country, team)
VALUES ('12111111-1e06-4403-b240-fc3879a31c6a',
        'Алесандр Гхрыгхорыч',
        'Беларусь',
        '11111111-1e06-4403-b240-fc3879a31c6a');
INSERT INTO players (id, name, country, team)
VALUES ('13111111-1e06-4403-b240-fc3879a31c6a',
        'Potato',
        'Беларусь',
        '11111111-1e06-4403-b240-fc3879a31c6a');



INSERT INTO seasons (id, name, season_starts, season_ends)
VALUES (1,
        'Кубок картошки',
        '2025-06-01',
        '2025-07-01');
INSERT INTO seasons (id, name, season_starts, season_ends)
VALUES (2,
        'Дачный сезон',
        '2025-07-01',
        '2025-09-01');


INSERT INTO matches (id, season, first_team, second_team, date, score, first_team_won)
VALUES ('11111111-1e06-4403-b240-fc3879a31222',
        1,
        '11111111-1e06-4403-b240-fc3879a31c6a',
        '22222222-1e06-4403-b240-fc3879a31c6a',
        '2025-06-01',
        '2:1',
        true);
INSERT INTO matches (id, season, first_team, second_team, date, score, first_team_won)
VALUES ('21111111-1e06-4403-b240-fc3879a31222',
        1,
        '11111111-1e06-4403-b240-fc3879a31c6a',
        '33333333-1e06-4403-b240-fc3879a31c6a',
        '2025-06-02',
        '1:144',
        false);
INSERT INTO matches (id, season, first_team, second_team, date, score, first_team_won)
VALUES ('31111111-1e06-4403-b240-fc3879a31222',
        1,
        '11111111-1e06-4403-b240-fc3879a31c6a',
        '33333333-1e06-4403-b240-fc3879a31c6a',
        '2025-06-05',
        '1:1',
        null);

INSERT INTO matches (id, season, first_team, second_team, date, score, first_team_won)
VALUES ('41111111-1e06-4403-b240-fc3879a31222',
        2,
        '33333333-1e06-4403-b240-fc3879a31c6a',
        '11111111-1e06-4403-b240-fc3879a31c6a',
        '2025-08-05',
        null,
        null);
INSERT INTO matches (id, season, first_team, second_team, date, score, first_team_won)
VALUES ('51111111-1e06-4403-b240-fc3879a31222',
        2,
        '33333333-1e06-4403-b240-fc3879a31c6a',
        '22222222-1e06-4403-b240-fc3879a31c6a',
        '2025-08-15',
        null,
        null);


