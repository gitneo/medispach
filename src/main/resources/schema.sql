DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery` (
                            `del_code` bigint NOT NULL AUTO_INCREMENT,
                            `del_serial` int NOT NULL,
                            `del_status` varchar(255) NOT NULL,
                            `del_do_id` bigint DEFAULT NULL,
                            `del_dr_code` bigint DEFAULT NULL
);




DROP TABLE IF EXISTS `delivery_item`;
CREATE TABLE `delivery_item` (
                                 `item_id` bigint NOT NULL AUTO_INCREMENT,
                                 `item_quantity` decimal(19, 2) NOT NULL,
                                 `item_do_id` bigint DEFAULT NULL,
                                 `item_med_id` bigint DEFAULT NULL
);






DROP TABLE IF EXISTS `delivery_order`;
CREATE TABLE `delivery_order` (
                                  `do_id` bigint NOT NULL AUTO_INCREMENT,
                                  `do_location` varchar(255) NOT NULL,
                                  `do_serial` varchar(255) NOT NULL
);






DROP TABLE IF EXISTS `drone`;
CREATE TABLE `drone` (
                         `drn_code` bigint NOT NULL AUTO_INCREMENT,
                         `drn_batt_capcity` decimal(19, 2) NOT NULL,
                         `drn_model` varchar(255) NOT NULL,
                         `drn_serial` varchar(255) NOT NULL,
                         `drn_state` varchar(255) NOT NULL,
                         `drn_weight_limit` decimal(19, 2) NOT NULL
);





DROP TABLE IF EXISTS `medication`;
CREATE TABLE `medication` (
                              `med_id` bigint NOT NULL AUTO_INCREMENT,
                              `med_code` varchar(255) NOT NULL,
                              `med_image` varchar(255) DEFAULT NULL,
                              `med_name` varchar(255) NOT NULL,
                              `med_weight` decimal(19, 2) NOT NULL
);

