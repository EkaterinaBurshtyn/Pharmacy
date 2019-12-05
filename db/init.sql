DROP SCHEMA IF EXISTS `pharmacy`;
CREATE DATABASE `pharmacy` DEFAULT CHARACTER SET utf8;
USE `pharmacy`;

CREATE TABLE `group`
(
    `id`   int(11)      NOT NULL,
    `name` varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `package_type`
(
    `id`   int(11)      NOT NULL,
    `name` varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `preparation`
(
    `id`           int(11)      NOT NULL,
    `gr_id`        int(11)      NOT NULL,
    `name`         varchar(100) NOT NULL,
    `pack_type_id` int(11)      NOT NULL,
    PRIMARY KEY (`id`),
    KEY `gr_id` (`gr_id`),
    CONSTRAINT `preparation_ibfk_1` FOREIGN KEY (`gr_id`) REFERENCES `group` (id),
    KEY `pack_type_id` (`pack_type_id`),
    CONSTRAINT `preparation_ibfk_2` FOREIGN KEY (`pack_type_id`) REFERENCES `package_type` (id)
);


CREATE TABLE `availability`
(
    `id`       int(11)       NOT NULL,
    `pr_id`    int(11)       NOT NULL,
    `quantity` double(10, 5) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `pr_id` (`pr_id`),
    CONSTRAINT `availabity_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (id)
);

CREATE TABLE `state`
(
    `id`          int(11) NOT NULL,
    `description` varchar(5000) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `contraindication`
(
    `pr_id` int(11) NOT NULL,
    `st_id` int(11) NOT NULL,
    PRIMARY KEY (`pr_id`, `st_id`),
    KEY `pr_id` (`pr_id`),
    CONSTRAINT `contraindication_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (id),
    KEY `st_id` (`st_id`),
    CONSTRAINT `contraindication_ibfk_2` FOREIGN KEY (`st_id`) REFERENCES `state` (id)
);

CREATE TABLE `indication`
(
    `pr_id` int(11) NOT NULL,
    `st_id` int(11) NOT NULL,
    PRIMARY KEY (`pr_id`, `st_id`),
    KEY `pr_id` (`pr_id`),
    CONSTRAINT `indication_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (id),
    KEY `st_id` (`st_id`),
    CONSTRAINT `indication_ibfk_2` FOREIGN KEY (`st_id`) REFERENCES `state` (id)
);



CREATE TABLE `mode_of_application`
(
    `id`          int(11) NOT NULL,
    `description` varchar(5000) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `mode_of_application_preparation`
(
    `pr_id` int(11) NOT NULL,
    `ma_id` int(11) NOT NULL,
    PRIMARY KEY (`pr_id`, `ma_id`),
    KEY `pr_id` (`pr_id`),
    KEY `ma_id` (`ma_id`),
    CONSTRAINT `mode_of_application_preparation_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (id),
    CONSTRAINT `mode_of_application_preparation_ibfk_2` FOREIGN KEY (`ma_id`) REFERENCES `mode_of_application` (id)
);

CREATE TABLE `receipt`
(
    `id`        int(11) NOT NULL,
    `date_time` datetime DEFAULT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE `sold`
(
    `id`             int(11)       NOT NULL,
    `pr_id`          int(11)       NOT NULL,
    `receipt_id`     int(11)       NOT NULL,
    `quantity`       double(10, 5) NOT NULL,
    `price_per_pack` double(10, 5) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `pr_id` (`pr_id`),
    CONSTRAINT `sold_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (id),
    KEY `receipt_id` (`receipt_id`),
    CONSTRAINT `sold_ibfk_2` FOREIGN KEY (`receipt_id`) REFERENCES `receipt` (id)
);

CREATE TABLE `structure_substance`
(
    `id`   int(11) NOT NULL,
    `name` varchar(5000) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `structure_substance_preparation`
(
    `pr_id` int(11) NOT NULL,
    `ss_id` int(11) NOT NULL,
    PRIMARY KEY (`pr_id`, `ss_id`),
    KEY `pr_id` (`pr_id`),
    KEY `ss_id` (`ss_id`),
    CONSTRAINT `structure_substance_preparation_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (id),
    CONSTRAINT `structure_substance_preparation_ibfk_2` FOREIGN KEY (`ss_id`) REFERENCES `structure_substance` (id)
);
