CREATE TABLE "home" (
    id SERIAL PRIMARY KEY,
    created_at timestamptz not null default now(),
    name VARCHAR(255) UNIQUE NOT NULL
);

ALTER TABLE "user" ADD UNIQUE (id),
    ADD COLUMN home_id INTEGER REFERENCES "home" (id);
