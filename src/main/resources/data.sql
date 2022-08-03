
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery`
VALUES (1, 1185145724, 'READY', 7, 6);
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;





/*!40000 ALTER TABLE `delivery_item` DISABLE KEYS */;
INSERT INTO `delivery_item`
VALUES (1, 1.00, 1, 1),
       (2, 1.00, 2, 1),
       (3, 2.00, 3, 2),
       (4, 3.00, 4, 3),
       (5, 4.00, 5, 4),
       (6, 5.00, 6, 5),
       (7, 6.00, 7, 6);
/*!40000 ALTER TABLE `delivery_item` ENABLE KEYS */;





/*!40000 ALTER TABLE `delivery_order` DISABLE KEYS */;
INSERT INTO `delivery_order`
VALUES (1, 'Jigawa', 'ORD-00001'),
       (2, 'Lagos', 'ORD-00002'),
       (3, 'Aabuja', 'ORD-00003'),
       (4, 'Yaba', 'ORD-00004'),
       (5, 'Ikoyi', 'ORD-00005'),
       (6, 'Surulere', 'ORD-00006'),
       (7, 'Ikeja', 'ORD-00007');
/*!40000 ALTER TABLE `delivery_order` ENABLE KEYS */;






/*!40000 ALTER TABLE `drone` DISABLE KEYS */;
INSERT INTO `drone`
VALUES (1, 100.00, 'LIGHTWEIGHT', 'DILVERYDRONE-1', 'LOADING'
       , 500.00),
       (2, 100.00, 'LIGHTWEIGHT', 'DILVERYDRONE-2', 'LOADING'
       , 500.00),
       (3, 100.00, 'HEAVYWEIGHT', 'POWERDRONE-3', 'LOADING'
       , 500.00),
       (4, 100.00, 'MIDDLEWEIGHT', 'FLEXIDRONE-4', 'LOADING'
       , 500.00),
       (5, 100.00, 'CRUISERWEIGHT', 'BETADRONE-5', 'LOADING'
       , 500.00),
       (6, 100.00, 'HEAVYWEIGHT', 'POWERDRONE-6', 'IDLE'
       , 500.00),
       (7, 100.00, 'LIGHTWEIGHT', 'DELIVERYDRONE-7', 'IDLE'
       , 500.00),
       (8, 100.00, 'LIGHTWEIGHT', 'DELIVERYDRONE-8', 'IDLE'
       , 500.00),
       (9, 100.00, 'MIDDLEWEIGHT', 'FLEXIDRONE-9', 'IDLE'
       , 500.00),
       (10, 100.00, 'CRUISERWEIGHT', 'BETADRONE-10', 'IDLE'
       , 500.00);
/*!40000 ALTER TABLE `drone` ENABLE KEYS */;



/*!40000 ALTER TABLE `medication` DISABLE KEYS */;
INSERT INTO `medication`
VALUES (1, 'MED_0001', 'xxxxxx', 'Levothyroxine', 50.00),
       (2, 'MED_0002', 'xxxxxx', 'Lisinopril', 20.00),
       (3, 'MED_0003', 'xxxxxx', 'Metformin', 5.00),
       (4, 'MED_0004', 'xxxxxx', 'Hydrochlorothiazide', 5.00),
       (5, 'MED_0004', 'xxxxxx', 'Amoxicillin', 9.00),
       (6, 'MED_0005', 'xxxxxx', 'Ibuprofen', 5.00),
       (7, 'MED_0007', 'xxxxxx', 'Pregnacare', 1.00),
       (8, 'MED_0008', 'xxxxxx', 'Paracetamol', 1.00),
       (9, 'MED_0009', 'xxxxxx', 'Sensodyn', 9.00),
       (10, 'MED_0010', 'xxxxxx', 'Benilyn', 15.00),
       (11, 'MED_0011', 'xxxxxx', 'Augumentin', 20.00),
       (12, 'MED_0012', 'xxxxxx', 'Cocodamol', 90.00),
       (13, 'MED_0013', 'xxxxxx', 'Actifed', 500.00),
       (14, 'MED_0014', 'xxxxxx', 'Tylenol', 200.00),
       (15, 'MED_0015', 'xxxxxx', 'Buscopan', 70.00),
       (16, 'MED_0016', 'xxxxxx', 'Panadol', 150.00),
       (17, 'MED_0017', 'xxxxxx', 'Flugun', 110.00),
       (18, 'MED_0019', 'xxxxxx', 'Cocaine', 600.00);
/*!40000 ALTER TABLE `medication` ENABLE KEYS */;

