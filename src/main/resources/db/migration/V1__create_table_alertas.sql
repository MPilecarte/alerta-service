CREATE TABLE tbl_alertas(
    id INT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    nivel_risco VARCHAR(50),
    sensor_id INT
);