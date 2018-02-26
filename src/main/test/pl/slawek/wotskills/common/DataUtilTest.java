package pl.slawek.wotskills.common;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DataUtilTest {

    @Test
    public void correctTimestampShouldBeFormattedToDate() {
        String date = DataUtil.getDateFromTimestamp(1466788999);

        assertTrue(date.matches("\\d\\d.\\d\\d.\\d\\d\\d\\d \\d\\d:\\d\\d"));
    }
}
