CREATE TABLE IF NOT EXISTS product (
    product_id         SERIAL PRIMARY KEY,
    product_name       VARCHAR(128)  NOT NULL,
    category           VARCHAR(32)   NOT NULL,
    image_url          VARCHAR(256)  NOT NULL,
    price              INTEGER       NOT NULL,
    stock              INTEGER       NOT NULL,
    description        VARCHAR(1024),
    created_date       TIMESTAMP     NOT NULL,
    last_modified_date TIMESTAMP     NOT NULL
);

CREATE TABLE IF NOT EXISTS "user" (
    user_id            SERIAL PRIMARY KEY,
    email              VARCHAR(256)  NOT NULL UNIQUE,
    password           VARCHAR(256)  NOT NULL,
    created_date       TIMESTAMP     NOT NULL,
    last_modified_date TIMESTAMP     NOT NULL
);

CREATE TABLE IF NOT EXISTS "order" (
    order_id           SERIAL PRIMARY KEY,
    user_id            INTEGER       NOT NULL,
    total_amount       INTEGER       NOT NULL,
    created_date       TIMESTAMP     NOT NULL,
    last_modified_date TIMESTAMP     NOT NULL
);

CREATE TABLE IF NOT EXISTS order_item (
    order_item_id      SERIAL PRIMARY KEY,
    order_id           INTEGER       NOT NULL,
    product_id         INTEGER       NOT NULL,
    quantity           INTEGER       NOT NULL,
    amount             INTEGER       NOT NULL
);