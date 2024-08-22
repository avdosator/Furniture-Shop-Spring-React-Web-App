-- V2__Create_refresh_token_table.sql

-- Table: refresh_token

CREATE TABLE public.refresh_token (
    id SERIAL PRIMARY KEY,
    token_hash CHAR(128) NOT NULL,  -- SHA-512 produces a 128-character hex string
    user_id INTEGER NOT NULL,
    expiry_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT refresh_token_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE
);

CREATE INDEX idx_refresh_token_user_id ON public.refresh_token(user_id);
CREATE UNIQUE INDEX idx_refresh_token_token_hash ON public.refresh_token(token_hash);

GRANT ALL ON TABLE public.refresh_token TO spring_app_user;
GRANT ALL ON SEQUENCE public.refresh_token_id_seq TO spring_app_user;