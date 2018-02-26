package pl.slawek.wotskills.common;

import org.junit.Test;

import java.net.URL;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class URLBuilderTest {

    @Test(expected = IllegalArgumentException.class)
    public void urlWithEmptyPathShouldThrowAnException() {
        HashMap parameters = new HashMap<String, String>() {{
            put("account_id", "12345");
        }};


        URLBuilder.getURL("", parameters);
    }

    @Test
    public void urlShouldContainGivenPathAndParameters() {
        HashMap parameters = new HashMap<String, String>() {{
            put("account_id", "12345");
            put("test", "abcd");
        }};

        String path = "path/to/test";

        URL url = URLBuilder.getURL(path, parameters);

        assertTrue(url.getPath().contains(path));
    }
}
