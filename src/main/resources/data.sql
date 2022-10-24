-- Insert de marcas

INSERT INTO MARCA (nome_marca) VALUES('FIAT');
INSERT INTO MARCA  (nome_marca) VALUES('CHEVROLET');
INSERT INTO MARCA (nome_marca)  VALUES('TOYOTA');
INSERT INTO MARCA (nome_marca)  VALUES('HYUNDAI');
INSERT INTO MARCA (nome_marca)  VALUES('VOLKSWAGEM');
INSERT INTO MARCA  (nome_marca) VALUES('JEEP');
INSERT INTO MARCA  (nome_marca) VALUES('RENAULT');
INSERT INTO MARCA  (nome_marca) VALUES('HONDA');
INSERT INTO MARCA (nome_marca) VALUES('NISSAN');
INSERT INTO MARCA  (nome_marca) VALUES('PEUGEOT');
INSERT INTO MARCA (nome_marca)  VALUES('FORD');
INSERT INTO MARCA (nome_marca)  VALUES('CITROEN');



-- Insert de modelos

INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('FASTBACK',50000.00,1);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('ARGO',30000.00,1);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('ONIX',35000.00,2);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('CELTA',15000.00,2);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('COROLLA',25000.00,3);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('YARIS',25000.00,3);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('TUCSON',55000.00,4);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('CRETA',75000.00,4);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('NIVUS',25000.00,5);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('T-CROS',45000.00,5);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('COMPASS',25000.00,6);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('GRAND CHEROKEE',45000.00,6);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('LOGAN',22000.00,7);
INSERT INTO MODELO (nome,valor_fipe,marca_id) VALUES('SANDERO',18000.00,7);


-- Insert de carros

INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2022,'Gasolina','Vermelho',4,'2022-10-24',1);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2021,'Alcool','Branca',4,'2022-10-24',2);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2020,'Alcool','Prata',2,'2021-11-11',3);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2015,'Flex','Prata',2,'2021-12-10',4);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2019,'Gasolina','Prata',4,'2021-11-11',5);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2022,'Etanol','Azul',4,'2020-11-11',6);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2018,'Gasolina','Prata',4,'2021-11-11',7);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2022,'Diesel','Azul',4,'2022-01-06',8);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2018,'Alcool','Prata',4,'2022-01-07',9);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2020,'Flex','Amarelo',4,'2022-01-15',10);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2019,'Gasolina','Vermelho',4,'2022-01-15',11);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2018,'Diesel','Branca',4,'2021-11-11',12);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2017,'Flex','Amarelo',4,'2021-11-11',13);
INSERT INTO CARRO (ano,combustivel,cor,num_portas,timestamp_cadastro,modelo_id) VALUES(2017,'Flex','Prata',4,'2021-11-11',14);
