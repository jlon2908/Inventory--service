-- Esquema inventario para migración Flyway/AWS RDS

CREATE TABLE IF NOT EXISTS customer_order (
    id uuid NOT NULL,
    order_code character varying(50) NOT NULL,
    user_id uuid NOT NULL,
    warehouse_pickup_code character varying(20) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    status character varying(30) DEFAULT 'CREATED'::character varying NOT NULL,
    CONSTRAINT customer_order_order_code_key UNIQUE (order_code),
    CONSTRAINT customer_order_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS customer_order_item (
    id uuid NOT NULL,
    customer_order_id uuid NOT NULL,
    sku character varying(100) NOT NULL,
    quantity integer NOT NULL,
    CONSTRAINT customer_order_item_quantity_check CHECK ((quantity > 0)),
    CONSTRAINT customer_order_item_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS inventory (
    id uuid NOT NULL,
    sku character varying(100) NOT NULL,
    warehouse_id uuid NOT NULL,
    quantity integer NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT inventory_pkey PRIMARY KEY (id),
    CONSTRAINT uk_inventory_sku_warehouse UNIQUE (sku, warehouse_id)
);

CREATE TABLE IF NOT EXISTS inventory_transaction (
    id uuid NOT NULL,
    sku character varying(100) NOT NULL,
    warehouse_id uuid NOT NULL,
    quantity_change integer NOT NULL,
    type character varying(20) NOT NULL,
    occurred_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT inventory_transaction_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS order_distribution (
    id uuid NOT NULL,
    customer_order_item_id uuid NOT NULL,
    source_warehouse_id uuid NOT NULL,
    destination_warehouse_code character varying(20) NOT NULL,
    assigned_quantity integer NOT NULL,
    status character varying(30) NOT NULL,
    assigned_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    sku character varying(255) NOT NULL,
    CONSTRAINT order_distribution_assigned_quantity_check CHECK ((assigned_quantity > 0)),
    CONSTRAINT order_distribution_status_check CHECK ((status IN ('PENDING','IN_TRANSIT','RECEIVED','READY_FOR_PICKUP'))),
    CONSTRAINT order_distribution_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS reserved_inventory (
    id uuid NOT NULL,
    warehouse_code character varying(20) NOT NULL,
    order_code character varying(50) NOT NULL,
    sku character varying(100) NOT NULL,
    reserved_quantity integer NOT NULL,
    status character varying(30) NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT reserved_inventory_reserved_quantity_check CHECK ((reserved_quantity > 0)),
    CONSTRAINT reserved_inventory_status_check CHECK ((status IN ('WAITING_PICKUP','DELIVERED'))),
    CONSTRAINT reserved_inventory_pkey PRIMARY KEY (id),
    CONSTRAINT unique_reserved_inventory_triplet UNIQUE (warehouse_code, order_code, sku)
);

CREATE TABLE IF NOT EXISTS warehouse (
    id uuid NOT NULL,
    name character varying(100) NOT NULL,
    city character varying(50) NOT NULL,
    address text,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    code character varying(20) NOT NULL,
    country text,
    state text,
    latitude double precision,
    longitude double precision,
    CONSTRAINT unique_code UNIQUE (code),
    CONSTRAINT warehouse_code_key UNIQUE (code),
    CONSTRAINT warehouse_pkey PRIMARY KEY (id)
);

-- Foreign Keys
ALTER TABLE customer_order_item
    ADD CONSTRAINT fk_customer_order FOREIGN KEY (customer_order_id) REFERENCES customer_order(id);

ALTER TABLE order_distribution
    ADD CONSTRAINT fk_destination_code FOREIGN KEY (destination_warehouse_code) REFERENCES warehouse(code);

ALTER TABLE inventory
    ADD CONSTRAINT fk_inventory_warehouse FOREIGN KEY (warehouse_id) REFERENCES warehouse(id);

ALTER TABLE order_distribution
    ADD CONSTRAINT fk_order_item FOREIGN KEY (customer_order_item_id) REFERENCES customer_order_item(id);

ALTER TABLE customer_order
    ADD CONSTRAINT fk_pickup_warehouse_code FOREIGN KEY (warehouse_pickup_code) REFERENCES warehouse(code);

ALTER TABLE reserved_inventory
    ADD CONSTRAINT fk_reserved_warehouse_code FOREIGN KEY (warehouse_code) REFERENCES warehouse(code);

ALTER TABLE order_distribution
    ADD CONSTRAINT fk_source_warehouse FOREIGN KEY (source_warehouse_id) REFERENCES warehouse(id);

ALTER TABLE inventory_transaction
    ADD CONSTRAINT fk_transaction_warehouse FOREIGN KEY (warehouse_id) REFERENCES warehouse(id);
