package basic.booking;

import basic.booking.controller.RegistrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class Application {

    private static Date sqlDate;

    public static Date getSqlDate() {
        return sqlDate;
    }

    public static void setSqlDate(Date sqlDate) {
        Application.sqlDate = sqlDate;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
