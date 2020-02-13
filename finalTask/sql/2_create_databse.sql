CREATE DATABASE `account_db` DEFAULT CHARACTER SET utf8;
CREATE USER `application` on "some_password"

GRANT SELECT,INSERT,UPDATE,DELETE
ON `account_db`.*
TO account_user@localhost

GRANT SELECT,INSERT,UPDATE,DELETE
ON `account_db`.*
TO account_user@'%'