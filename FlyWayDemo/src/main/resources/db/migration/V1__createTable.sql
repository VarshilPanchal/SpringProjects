CREATE TABLE flyway_product_table (
 
 	id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(64) not null,
    brand varchar(64) not null,
    madein varchar(64) not null,
    price varchar(64) not null,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
