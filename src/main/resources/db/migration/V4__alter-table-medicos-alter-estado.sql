ALTER TABLE medicos modify column estado tinyint;
UPDATE medicos set estado = 1;