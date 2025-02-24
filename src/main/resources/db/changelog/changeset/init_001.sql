CREATE TABLE IF NOT EXISTS products
(
    id           SERIAL primary key,
    name         varchar(255)     not null,
    price        double precision not null,
    created_date timestamp default now()

    );

CREATE TABLE IF NOT EXISTS customers
(
    id           SERIAL primary key,
    name         varchar(255) not null,
    created_date timestamp default now()
    );

CREATE TABLE IF NOT EXISTS orders
(
    id           SERIAL primary key,
    customer_id  BIGINT not null,
    status       boolean   default true,
    created_date timestamp default now()
    );

CREATE TABLE IF NOT EXISTS order_details
(
    id           SERIAL primary key,
    customer_id  BIGINT not null,
    product_id   BIGINT not null,
    order_id     bigint not null,
    created_date timestamp default now()
    )