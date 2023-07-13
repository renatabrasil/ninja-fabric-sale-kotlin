CREATE TABLE IF NOT EXISTS employees (
  id                     VARCHAR(60)  DEFAULT RANDOM_UUID() PRIMARY KEY,
  name                   VARCHAR      NOT NULL,
  location              VARCHAR(128) NOT NULL,
  created_at             TIMESTAMP    NOT NULL,
  username               VARCHAR(60)  NOT NULL
);