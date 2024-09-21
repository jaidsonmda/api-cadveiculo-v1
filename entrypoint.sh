#!/bin/bash
set -e

# Cria usuário, senha e banco de dados
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
-- CREATE ROLE teste;
--    CREATE USER teste WITH PASSWORD 'teste';
--   CREATE DATABASE teste;
    GRANT ALL PRIVILEGES ON DATABASE teste TO teste;
   -- GRANT teste TO teste;
EOSQL
