
drop table if exists wallet;
CREATE TABLE wallet (
  id int primary key AUTO_INCREMENT,
  mnemonics varchar(1024),
  create_time datetime NOT NULL DEFAULT current_timestamp(),
  constraint unq_mnemonics unique (mnemonics)
);

