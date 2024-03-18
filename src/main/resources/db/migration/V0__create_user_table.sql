CREATE TABLE IF NOT EXISTS "user" (
    id SERIAL PRIMARY KEY,
    created_at timestamptz not null default now(),
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password TEXT NOT NULL,
    admin BOOLEAN NOT NULL DEFAULT false
)