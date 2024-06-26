-- V1__Initial_schema.sql

-- Table: cart

CREATE TABLE public.cart (
    cart_id integer NOT NULL,
    user_id integer,
    date_created timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE public.cart_cart_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY public.cart ALTER COLUMN cart_id SET DEFAULT nextval('public.cart_cart_id_seq'::regclass);
ALTER TABLE ONLY public.cart ADD CONSTRAINT cart_pkey PRIMARY KEY (cart_id);
ALTER TABLE ONLY public.cart ADD CONSTRAINT cart_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;
GRANT ALL ON TABLE public.cart TO spring_app_user;
GRANT ALL ON SEQUENCE public.cart_cart_id_seq TO spring_app_user;


-- Table: cart_item

CREATE TABLE public.cart_item (
    cart_item_id integer NOT NULL,
    cart_id integer,
    product_id integer,
    quantity integer NOT NULL,
    date_created timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE public.cart_item_cart_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY public.cart_item ALTER COLUMN cart_item_id SET DEFAULT nextval('public.cart_item_cart_item_id_seq'::regclass);
ALTER TABLE ONLY public.cart_item ADD CONSTRAINT cart_item_pkey PRIMARY KEY (cart_item_id);
ALTER TABLE ONLY public.cart_item ADD CONSTRAINT cart_item_cart_id_fkey FOREIGN KEY (cart_id) REFERENCES public.cart(cart_id) ON DELETE CASCADE;
ALTER TABLE ONLY public.cart_item ADD CONSTRAINT cart_item_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.product(product_id) ON DELETE CASCADE;
GRANT ALL ON TABLE public.cart_item TO spring_app_user;
GRANT ALL ON SEQUENCE public.cart_item_cart_item_id_seq TO spring_app_user;


-- Table: category

CREATE TABLE public.category (
    category_id integer NOT NULL,
    category_name character varying(30) NOT NULL
);
CREATE SEQUENCE public.category_category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY public.category ALTER COLUMN category_id SET DEFAULT nextval('public.category_category_id_seq'::regclass);
ALTER TABLE ONLY public.category ADD CONSTRAINT category_pkey PRIMARY KEY (category_id);
ALTER TABLE ONLY public.category ADD CONSTRAINT unique_category_name UNIQUE (category_name);
GRANT ALL ON TABLE public.category TO spring_app_user;
GRANT ALL ON SEQUENCE public.category_category_id_seq TO spring_app_user;


-- Table: order

CREATE TABLE public."order" (
    order_id integer NOT NULL,
    user_id integer,
    total_amount numeric(10,2) NOT NULL,
    order_status character varying(30) DEFAULT 'pending'::character varying,
    date_created timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE public.order_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY public."order" ALTER COLUMN order_id SET DEFAULT nextval('public.order_order_id_seq'::regclass);
ALTER TABLE ONLY public."order" ADD CONSTRAINT order_pkey PRIMARY KEY (order_id);
ALTER TABLE ONLY public."order" ADD CONSTRAINT order_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;
GRANT ALL ON TABLE public."order" TO spring_app_user;
GRANT ALL ON SEQUENCE public.order_order_id_seq TO spring_app_user;


-- Table: order_item

CREATE TABLE public.order_item (
    order_item_id integer NOT NULL,
    order_id integer,
    product_id integer,
    quantity integer NOT NULL,
    price numeric(10,2) NOT NULL
);
CREATE SEQUENCE public.order_item_order_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY public.order_item ALTER COLUMN order_item_id SET DEFAULT nextval('public.order_item_order_item_id_seq'::regclass);
ALTER TABLE ONLY public.order_item ADD CONSTRAINT order_item_pkey PRIMARY KEY (order_item_id);
ALTER TABLE ONLY public.order_item ADD CONSTRAINT order_item_order_id_fkey FOREIGN KEY (order_id) REFERENCES public."order"(order_id) ON DELETE CASCADE;
ALTER TABLE ONLY public.order_item ADD CONSTRAINT order_item_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.product(product_id) ON DELETE SET NULL;
GRANT ALL ON TABLE public.order_item TO spring_app_user;
GRANT ALL ON SEQUENCE public.order_item_order_item_id_seq TO spring_app_user;


-- Table: product

CREATE TABLE public.product (
    product_id integer NOT NULL,
    product_name character varying(50) NOT NULL,
    price numeric(10,2) NOT NULL,
    stock integer NOT NULL,
    description text,
    category_id integer
);
CREATE SEQUENCE public.product_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY public.product ALTER COLUMN product_id SET DEFAULT nextval('public.product_product_id_seq'::regclass);
ALTER TABLE ONLY public.product ADD CONSTRAINT product_pkey PRIMARY KEY (product_id);
ALTER TABLE ONLY public.product ADD CONSTRAINT product_category_id_fkey FOREIGN KEY (category_id) REFERENCES public.category(category_id) ON DELETE SET NULL;
GRANT ALL ON TABLE public.product TO spring_app_user;
GRANT ALL ON SEQUENCE public.product_product_id_seq TO spring_app_user;


-- Table: users

CREATE TABLE public.users (
    id integer NOT NULL,
    firstname character varying NOT NULL,
    lastname character varying NOT NULL,
    username character varying NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL,
    date_created timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    role character varying(30)
);
CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_user_id_seq'::regclass);
ALTER TABLE ONLY public.users ADD CONSTRAINT unique_email UNIQUE (email);
ALTER TABLE ONLY public.users ADD CONSTRAINT unique_username UNIQUE (username);
ALTER TABLE ONLY public.users ADD CONSTRAINT users_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.users ADD CONSTRAINT users_username_key UNIQUE (username);
GRANT ALL ON TABLE public.users TO spring_app_user;
GRANT ALL ON SEQUENCE public.users_user_id_seq TO spring_app_user;


GRANT ALL ON SCHEMA public TO spring_app_user;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public GRANT ALL ON TABLES TO spring_app_user;
