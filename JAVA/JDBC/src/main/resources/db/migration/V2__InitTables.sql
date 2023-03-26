CREATE TABLE actor (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    movie bigint REFERENCES movie (id),
    unique (name, movie)
);
