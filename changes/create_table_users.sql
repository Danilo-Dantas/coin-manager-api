CREATE TABLE IF NOT EXISTS users (
    id            INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL,
    password      VARCHAR(255) NOT NULL,

    creation_date TIMESTAMPTZ,
    created_by    VARCHAR(255),

    updated_date  TIMESTAMPTZ,
    updated_by    VARCHAR(255)
    );