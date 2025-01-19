connect 'jdbc:derby://localhost:1527/bd_proyecto_pedidos;user=app;password=app';

-- Eliminar tablas en orden correcto
DROP TABLE ordered_product;
DROP TABLE customer_order;
DROP TABLE product;
DROP TABLE category;
DROP TABLE customer;

-- Tabla CUSTOMER
CREATE TABLE customer (
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
     CONSTRAINT CUSTOMER_PK PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  phone VARCHAR(45) NOT NULL,
  address VARCHAR(45) NOT NULL,
  city_region VARCHAR(2) NOT NULL,
  cc_number VARCHAR(19) NOT NULL
);

INSERT INTO customer (name, email, phone, address, city_region, cc_number) VALUES
('Ditirambo Farfulla', 'ditirambo.farfulla@mkt.bond', '56284000', 'Arroyo Bajo 10 int 10', 'AO', '123456'),
('Gandulfo Roncante', 'gandulfo.roncante@mkt.bond', '56284000', 'Arroyo Bajo 10 int 12', 'AO', '123456'),
('Vagonzo Durmiente', 'vagonzo.durminte@mkt.bond', '56284000', 'Arroyo Bajo 10 int 45', 'AO', '123456'),
('Hambrosio Comensal', 'hambrosio.comensal@mkt.bond', '56284000', 'Arroyo Bajo 10 int 58', 'AO', '123456');

-- Tabla CUSTOMER_ORDER
CREATE TABLE customer_order (
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
     CONSTRAINT CUSTOMER_ORDER_PK PRIMARY KEY,
  amount DECIMAL(6,2) NOT NULL,
  date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  confirmation_number INT NOT NULL,
  customer_id INT NOT NULL CONSTRAINT CUST_ORD_FK REFERENCES customer
);

-- Tabla CATEGORY
CREATE TABLE category (
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
     CONSTRAINT CATEGORY_PK PRIMARY KEY,
  name VARCHAR(45) NOT NULL
);

INSERT INTO category (name) VALUES 
('terror'),
('fantasia'),
('romance'),
('ciencia_ficcion');

-- Tabla PRODUCT
CREATE TABLE product (
  id BIGINT NOT NULL,
  name VARCHAR(45) NOT NULL,
  price DECIMAL(5,2) NOT NULL,
  description VARCHAR(50),
  last_update TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  category_id INT NOT NULL,
  existencia INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category (id)
);



-- Insertar productos
INSERT INTO product (id, name, price, description, last_update, category_id, existencia) 
VALUES 
(9781234567890, 'El Resplandor', 12.50, 'Un libro de terror psicologico', '2020-10-06 09:00:00', 1, 500),
(9781234567891, 'Harry Potter y la Piedra Filosofal', 15.99, 'Un libro de fantasia sobre un nino mago', '2020-10-06 09:00:00', 2, 1000),
(9781234567892, 'Orgullo y Prejuicio', 9.99, 'Un clasico romance de Jane Austen', '2020-10-06 09:00:00', 3, 750),
(9781234567893, 'Cien Anos de Soledad', 11.50, 'Una novela de realismo magico', '2020-10-06 09:00:00', 4, 300),
(9781234567894, 'El It', 13.30, 'Un libro de terror sobrenatural', '2020-10-06 09:00:00', 1, 400),
(9781234567895, 'La Historia Interminable', 10.99, 'Un libro de fantasia epica', '2020-10-06 09:00:00', 2, 600),
(9781234567896, 'La Casa de los Espiritus', 8.50, 'Novela de romance con tintes de misterio', '2020-10-06 09:00:00', 3, 800),
(9781234567897, 'Fahrenheit 451', 7.75, 'Un libro de ciencia ficcion distopica', '2020-10-06 09:00:00', 4, 200),
(9781234567898, 'La Sombra del Viento', 18.00, 'Un thriller de romance con elementos goticos', '2020-10-06 09:00:00', 3, 650),
(9781234567899, 'Dracula', 10.00, 'Un clasico de terror gotico', '2020-10-06 09:00:00', 1, 450),
(9781234567800, 'El Hobbit', 14.99, 'Una fantasia sobre una aventura en la Tierra Media', '2020-10-06 09:00:00', 2, 1200),
(9781234567801, 'Eclipse', 12.75, 'Una historia de romance y vampiros', '2020-10-06 09:00:00', 3, 500),
(9781234567802, '1984', 9.00, 'Una novela de ciencia ficcion distopica', '2020-10-06 09:00:00', 4, 350),
(9781234567803, 'El Exorcista', 13.00, 'Un thriller de terror sobrenatural', '2020-10-06 09:00:00', 1, 600),
(9781234567804, 'La Tierra de las Sombras', 16.50, 'Una fantasia oscura de aventuras', '2020-10-06 09:00:00', 2, 700);

-- Tabla ORDERED_PRODUCT
CREATE TABLE ordered_product (
  customer_order_id INT NOT NULL,
  product_id BIGINT NOT NULL,
  quantity SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (customer_order_id, product_id),
  CONSTRAINT fk_ordered_product_customer_order FOREIGN KEY (customer_order_id) REFERENCES customer_order (id),
  CONSTRAINT fk_ordered_product_product FOREIGN KEY (product_id) REFERENCES product (id)
);

disconnect;