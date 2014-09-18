INSERT INTO `marius`.`user` (`id`, `username`, `password`, `role`, `first_name`, `last_name`) VALUES ('1', 'admin', 'admin', 'ROLE_ADMIN', 'admin', 'admin');

INSERT INTO `marius`.`discipline` (`discipline_id`, `discipline`) VALUES ('1', 'math');

INSERT INTO `marius`.`homework` (`homework_id`, `homework`, `homework_date`, `discipline_discipline_id`) VALUES ('1', 'example', '25.09.2014', '1');

INSERT INTO `marius`.`rating` (`rating_id`, `rating_date`, `rating`, `user_id`, `discipline_discipline_id`) VALUES ('1', '21.09.2014', '5', '1', '1');

INSERT INTO `marius`.`shedule` (`shedule_id`, `discipline_discipline_id`) VALUES ('1', '1');
