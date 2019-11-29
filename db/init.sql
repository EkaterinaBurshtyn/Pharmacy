DROP SCHEMA IF EXISTS `pharmacy`;
CREATE DATABASE `pharmacy` DEFAULT CHARACTER SET utf8 ;
USE `pharmacy`;

CREATE TABLE `group` (
                         `id` int(11) NOT NULL,
                         `name` varchar(100) NOT NULL,
                         PRIMARY KEY (`id`)
);

CREATE TABLE `preparation` (
                               `id` int(11) NOT NULL,
                               `gr_id` int(11) NOT NULL,
                               `name` varchar(100) NOT NULL,
                               PRIMARY KEY (`id`),
                               KEY `gr_id` (`gr_id`),
                               CONSTRAINT `preparation_ibfk_1` FOREIGN KEY (`gr_id`) REFERENCES `group` (id)
);


CREATE TABLE `availabity` (
                              `id` int(11) NOT NULL,
                              `pr_id` int(11) NOT NULL,
                              `quantity` double(10,5) NOT NULL,
                              PRIMARY KEY (`id`),
                              KEY `pr_id` (`pr_id`),
                              CONSTRAINT `availabity_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (id)
);

CREATE TABLE `state` (
                         `id` int(11) NOT NULL,
                         `description` varchar(5000) DEFAULT NULL,
                         PRIMARY KEY (`id`)
);

CREATE TABLE `contrind_ind` (
                                `pr_id` int(11) NOT NULL,
                                `s_id` int(11) NOT NULL,
                                `Contraindications` tinyint(1) DEFAULT NULL,
                                `Indications` tinyint(1) DEFAULT NULL,
                                KEY `pr_id` (`pr_id`),
                                KEY `s_id` (`s_id`),
                                CONSTRAINT `contrind_ind_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (id),
                                CONSTRAINT `contrind_ind_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `state` (id)
);



CREATE TABLE `mode_of_application` (
                                       `id` int(11) NOT NULL,
                                       `description` varchar(5000) DEFAULT NULL,
                                       PRIMARY KEY (`id`)
);

CREATE TABLE `mode_of_application_preparation` (
                                                   `pr_id` int(11) NOT NULL,
                                                   `ma_id` int(11) NOT NULL,
                                                   KEY `pr_id` (`pr_id`),
                                                   KEY `ma_id` (`ma_id`),
                                                   CONSTRAINT `mode_of_application_preparation_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (id),
                                                   CONSTRAINT `mode_of_application_preparation_ibfk_2` FOREIGN KEY (`ma_id`) REFERENCES `mode_of_application` (id)
);



CREATE TABLE `sold` (
                        `id` int(11) NOT NULL,
                        `pr_id` int(11) NOT NULL,
                        `price` double(10,5) NOT NULL,
                        `date` datetime NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `pr_id` (`pr_id`),
                        CONSTRAINT `sold_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (id)
);


CREATE TABLE `structure` (
                             `id` int(11) NOT NULL,
                             `description` varchar(5000) DEFAULT NULL,
                             PRIMARY KEY (`id`)
);
