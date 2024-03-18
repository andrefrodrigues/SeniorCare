CREATE TABLE IF NOT EXISTS "role" (
    id SERIAL PRIMARY KEY,
    name varchar(255) NOT NULL,
    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS "user_roles" (
    user_id INTEGER NOT NULL references "user" (id),
    role_id INTEGER NOT NULL REFERENCES role (id)
);