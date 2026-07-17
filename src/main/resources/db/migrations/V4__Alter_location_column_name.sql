BEGIN;

ALTER TABLE missao
RENAME COLUMN location TO localizacao;

COMMIT;