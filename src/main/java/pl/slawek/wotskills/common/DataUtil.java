package pl.slawek.wotskills.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DataUtil {
    public static String getDataFromTimestamp(long time) {
        Timestamp stamp = new Timestamp(time);
        Date date = Date.from(Instant.ofEpochSecond(stamp.getTime()));
        String simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(date);

        return simpleDateFormat;
    }
}
