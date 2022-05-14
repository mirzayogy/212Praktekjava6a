CREATE TABLE `db_212praktek6a`.`pengguna` ( `id` INT NOT NULL AUTO_INCREMENT , `username` VARCHAR(255) NOT NULL , `password` VARCHAR(255) NOT NULL , `namaLengkap` VARCHAR(255) NOT NULL , `level` VARCHAR(255) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

INSERT INTO `pengguna` (`id`, `username`, `password`, `namaLengkap`, `level`) VALUES
(NULL, 'admin', MD5('admin123'), 'Saya Admin', 'admin'),
(NULL, 'user1', MD5('user1'), 'Saya User 1', 'user');

 https://dev.mysql.com/downloads/connector/j/