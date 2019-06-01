package by.it.ikasabutskaya.at20;



import java.sql.*;
        import java.time.LocalDateTime;

public class TaskCreateDatabase {

    static {
        try { //mysql-connector 8.0.15
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Not found Driver");
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(Timestamp.valueOf(LocalDateTime.now()));
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/ikasabutskaya?" +
                                "useUnicode=true&" +
                                "useJDBCCompliantTimezoneShift=true&" +
                                "useLegacyDatetimeCode=false&" +
                                "serverTimezone=UTC",
                        "root", "");
                Statement statement = connection.createStatement()
        ) {
            statement.executeQuery("SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;");
            statement.executeQuery("SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;");
            statement.executeQuery("SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';");

            statement.executeUpdate("DROP SCHEMA IF EXISTS `ikasabutskaya`;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `ikasabutskaya` DEFAULT CHARACTER SET utf8;");

            statement.executeQuery("USE `ikasabutskaya`;");

            statement.executeUpdate("DROP TABLE IF EXISTS `ikasabutskaya`.`user`;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `ikasabutskaya`.`user` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `username` VARCHAR(16) NOT NULL,\n" +
                    "  `email` VARCHAR(255) NULL,\n" +
                    "  `password` VARCHAR(32) NOT NULL,\n" +
                    "  `create_time` TIMESTAMP NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("DROP TABLE IF EXISTS `ikasabutskaya`.`category`;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `ikasabutskaya`.`category` (\n" +
                    "  `id` INT NOT NULL,\n" +
                    "  `name` VARCHAR(255) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("DROP TABLE IF EXISTS `ikasabutskaya`.`variable`;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `ikasabutskaya`.`variable` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `text` VARCHAR(45) NULL,\n" +
                    "  `user_id` INT NOT NULL,\n" +
                    "  `category_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_variable_user_idx` (`user_id` ASC) VISIBLE,\n" +
                    "  INDEX `fk_variable_category1_idx` (`category_id` ASC) VISIBLE,\n" +
                    "  CONSTRAINT `fk_variable_user`\n" +
                    "    FOREIGN KEY (`user_id`)\n" +
                    "    REFERENCES `ikasabutskaya`.`user` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_variable_category1`\n" +
                    "    FOREIGN KEY (`category_id`)\n" +
                    "    REFERENCES `ikasabutskaya`.`category` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");

            statement.executeQuery("SET SQL_MODE=@OLD_SQL_MODE;");
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;");
            statement.executeQuery("SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;");

            statement.executeQuery("USE `ikasabutskaya`;");

            statement.executeUpdate("INSERT INTO `ikasabutskaya`.`user` (`id`, `username`, `email`, `password`, `create_time`) \n" +
                    "VALUES (1, 'default', 'default@mail.com', 'qwerty', '2019-04-25'),\n" +
                    "(2, 'user', 'user@gmail.com', 'asdfgh', '2019-04-25'),\n" +
                    "(3, 'admin', 'admin@domain.com', 'zxcvbn', '2019-04-25');");
            statement.executeUpdate("INSERT INTO `ikasabutskaya`.`category` (`id`, `name`) VALUES (1, 'SCALAR'), (2, 'VECTOR'), (3, 'MATRIX');");
            statement.executeUpdate("INSERT INTO `ikasabutskaya`.`variable` (`id`, `name`, `text`, `user_id`, `category_id`) VALUES (1, 'A', '111', 1, 1);");

            statement.executeUpdate("INSERT INTO `ikasabutskaya`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (4, 'ikasabutskaya', 'ikas@butska.ya', '123456', '2019-05-31');");

            statement.executeUpdate("INSERT INTO `ikasabutskaya`.`variable` (`id`, `name`, `text`, `user_id`, `category_id`) VALUES (2, 'B', '222', 2, 2);");



        }
    }
}