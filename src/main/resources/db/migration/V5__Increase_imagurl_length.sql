-- src/main/resources/db/migration/V2__Increase_imageurl_length.sql

ALTER TABLE menus ALTER COLUMN imageurl TYPE VARCHAR(1024);
