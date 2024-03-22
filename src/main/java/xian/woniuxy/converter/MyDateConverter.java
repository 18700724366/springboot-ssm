package xian.woniuxy.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyDateConverter implements Converter<String, Date> {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date convert(String source) {
        try {
            Date date = sdf.parse(source);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
