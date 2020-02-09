package basic.booking.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class SetDate {

    public java.sql.Date setCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());
        return sqlCurrentDate;
    }
}
