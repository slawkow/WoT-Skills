package pl.slawek.wotskills.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DataUtil {
    public static String getDateFromTimestamp(final long time) {
        Timestamp stamp = new Timestamp(time);
        Date date = Date.from(Instant.ofEpochSecond(stamp.getTime()));

        return new SimpleDateFormat("dd.MM.yyyy HH:mm").format(date);
    }
}
