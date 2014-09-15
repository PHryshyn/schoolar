INSERT INTO `marius`.`discipline` (`discipline_id`, `discipline`) VALUES ('1', 'math');

INSERT INTO `marius`.`shedule` (`shedule_id`, `discipline_discipline_id`) VALUES ('1', '1');

INSERT INTO `marius`.`user` (`id`, `username`, `password`, `enabled`, `role`, `first_name`, `last_name`, `shedule_shedule_id`) VALUES ('1', 'admin', 'admin', '1', 'ROLE_ADMIN', 'admin', 'admin', '1');
