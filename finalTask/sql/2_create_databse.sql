CREATE DATABASE account_db;
CREATE USER 'application' IDENTIFIED BY "some_password";

GRANT SELECT,INSERT,UPDATE,DELETE
ON account_db.*
TO account_user@localhost;

GRANT SELECT,INSERT,UPDATE,DELETE
ON account_db.*
TO account_user@'%'