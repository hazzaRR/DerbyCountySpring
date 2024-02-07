CREATE TABLE IF NOT EXISTS upcoming_fixtures (
                                   id SERIAL PRIMARY KEY,
                                   home_team VARCHAR(255),
                                   away_team VARCHAR(255),
                                   kickoff TIMESTAMP,
                                   competition VARCHAR(255),
                                   stadium VARCHAR(255),
                                   sky_sports_url VARCHAR(255),
                                   CONSTRAINT UniqueFixture UNIQUE (home_team, away_team, kickoff, competition)
);

CREATE TABLE IF NOT EXISTS match_results (
                               id SERIAL PRIMARY KEY,
                               home_team VARCHAR(255),
                               away_team VARCHAR(255),
                               kickoff TIMESTAMP,
                               competition VARCHAR(255),
                               stadium VARCHAR(255),
                               home_score INTEGER,
                               away_score INTEGER,
                               result VARCHAR(255),
                               season VARCHAR(255),
                               penalties_score VARCHAR(255),
                               CONSTRAINT UniqueMatchResult UNIQUE (home_team, away_team, kickoff, competition)
);