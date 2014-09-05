CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `roles` (
  `role_id` int(10) unsigned NOT NULL,
  `id` int(11) unsigned NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  KEY `FK_roles` (`id`),
  CONSTRAINT `FK_roles` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user_data` (
  `id` int(11) unsigned NOT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `full_name_p1` varchar(255) DEFAULT NULL,
  `full_name_p2` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
   KEY `FK_user_login` (`id`),
   CONSTRAINT `FK_user_login` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `discipline` (
  `discipline_id` int(11) unsigned NOT NULL,
  `id` int(11) unsigned NOT NULL,
  `discipline` varchar(45) NOT NULL,
  PRIMARY KEY (`discipline_id`),
  KEY `FK_discipline_user` (`id`),
  CONSTRAINT `FK_discipline_user` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `rating` (
  `rating_id` int(11) unsigned NOT NULL,
  `rating_date` datetime,
  `rating` int(11),
  `id` int(11)  unsigned NOT NULL,
  `discipline_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`rating_id`),
  KEY `FK_rating_user` (`id`),
  CONSTRAINT `FK_rating_user` FOREIGN KEY (`id`) REFERENCES `user` (`id`),
  KEY `FK_discipline_rating` (`discipline_id`),
  CONSTRAINT `FK_discipline_rating` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`discipline_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `notes` (
  `notes_id` int(11) unsigned NOT NULL,
  `notes_date` datetime,
  `homework` varchar(45),
  `notes` varchar(45),
  `id` int(11)  unsigned NOT NULL,
  `discipline_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`notes_id`),
  KEY `FK_notes_user` (`id`),
  CONSTRAINT `FK_notes_user` FOREIGN KEY (`id`) REFERENCES `user` (`id`),
  KEY `FK_discipline_notes` (`discipline_id`),
  CONSTRAINT `FK_discipline_notes` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`discipline_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



