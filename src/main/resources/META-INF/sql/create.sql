CREATE TABLE IF NOT EXISTS productos
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    nombre         VARCHAR(100) NOT NULL,
    precio         INTEGER      NOT NULL,
    sku            VARCHAR(10)  NOT NULL,
    fecha_registro DATE DEFAULT CURRENT_DATE
);

INSERT INTO productos (nombre, precio, sku, fecha_registro)
VALUES ('Cafetera Express', 12999, 'CAFEXP1001', '2024-02-03'),
       ('Batidora Manual', 4500, 'BATMAN2022', '2024-02-03'),
       ('Licuadora Oster', 7600, 'LICOST7890', '2024-02-03'),
       ('Aspiradora Dyson', 22999, 'ASPDI34567', '2024-02-03'),
       ('Microondas LG', 13200, 'MICLG09876', '2024-02-03');
