package br.gov.inpi.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    private DateFormatter() {

    }

    public static final Date format(String data) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            return format.parse(data);
        } catch (ParseException e) {
            return new Date();
        }

    }
}
