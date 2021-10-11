INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Juan','Gomez','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');
INSERT INTO clientes (nombre, apellido , email, fecha , foto) VALUES('Maxi','De Lisio','maxidelisio@hotmail','2017-08-28','');

INSERT INTO productos (fecha, descripcion , precio) VALUES('2021-10-08','Panasonic Pantalla LCD',25000);
INSERT INTO productos (fecha, descripcion , precio) VALUES('2021-10-08','Sony camara digital DWS-894',38250);
INSERT INTO productos (fecha, descripcion , precio) VALUES('2021-10-08','Apple Ipod shuffle',550);
INSERT INTO productos (fecha, descripcion , precio) VALUES('2021-10-08','Sony notebook H-Intel',21040);
INSERT INTO productos (fecha, descripcion , precio) VALUES('2021-10-08','Notebook Hp Nerenon',29400);
INSERT INTO productos (fecha, descripcion , precio) VALUES('2021-10-08','Colchon sommier center',7320);


INSERT INTO facturas (descripcion, fecha, observacion,cliente_id) VALUES('Factura equipos tecnológicos',NOW(),null,1);
INSERT INTO items_factura (cantidad, factura_id, producto_id) VALUES(1,1,1);
INSERT INTO items_factura (cantidad, factura_id, producto_id) VALUES(2,1,2);
INSERT INTO items_factura (cantidad, factura_id, producto_id) VALUES(1,1,4);
INSERT INTO items_factura (cantidad, factura_id, producto_id) VALUES(1,1,5);

INSERT INTO facturas (descripcion, fecha, observacion,cliente_id) VALUES('Factura sommier center',NOW(),null,1);
INSERT INTO items_factura (cantidad, factura_id, producto_id) VALUES(3,2,6);

