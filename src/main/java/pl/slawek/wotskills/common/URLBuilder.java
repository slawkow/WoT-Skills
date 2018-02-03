package pl.slawek.wotskills.common;

import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class URLBuilder {

    private static final String HOST = "api.worldoftanks.eu/wot";
    private static final String APPLICATIONID = "15d552629efc3fec1cd514a02762ca61";

    public static URL getURL(String path, HashMap<String, String> parameters) {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("https");
        builder.setHost(HOST);
        builder.setPath(path);
        builder.addParameter("application_id", APPLICATIONID);
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            builder.addParameter(entry.getKey(), entry.getValue());
        }

        try {
            return builder.build().toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException("URL was built with errors.");
        }
    }
}
