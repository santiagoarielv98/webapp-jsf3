INSERT INTO categorias (nombre)
VALUES ('Electrodomésticos de Cocina'),
       ('Electrodomésticos de Limpieza'),
       ('Electrónica');

INSERT INTO productos (nombre, precio, sku, fecha_registro, categoria_id)
VALUES ('Cafetera Express', 12999, 'CAFEXP1001', '2024-02-03', 1),
       ('Batidora Manual', 4500, 'BATMAN2022', '2024-02-03', 1),
       ('Licuadora Oster', 7600, 'LICOST7890', '2024-02-03', 1),
       ('Aspiradora Dyson', 22999, 'ASPDI34567', '2024-02-03', 2),
       ('Microondas LG', 13200, 'MICLG09876', '2024-02-03', 3);