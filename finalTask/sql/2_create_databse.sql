CREATE DATABASE account_db;
create user application@localhost identified by 'application_password';

GRANT SELECT,INSERT,UPDATE,DELETE
ON account_db.*
TO application@localhost;

create user account_user@localhost identified by 'user_password';

GRANT SELECT,INSERT,UPDATE,DELETE
ON account_db.*
TO account_user@localhost;