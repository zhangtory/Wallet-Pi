
drop table if exists mnemonic;
CREATE TABLE mnemonic (
  id int primary key AUTO_INCREMENT,
  mnemonics varchar(1024),
  create_time datetime NOT NULL DEFAULT current_timestamp(),
  constraint unq_mnemonics unique (mnemonics)
);

