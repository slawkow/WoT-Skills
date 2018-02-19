package pl.slawek.wotskills.common;

import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

public class URLBuilder {

    private static final String HOST = "api.worldoftanks.eu/wot";
    private static final String APPLICATIONID = "15d552629efc3fec1cd514a02762ca61";
    private static final String SCHEME = "https";

    public static URL getURL(final String path, final HashMap<String, String> parameters) {
        URIBuilder builder = new URIBuilder();
        builder.setScheme(SCHEME);
        builder.setHost(HOST);
        builder.setPath(path);
        builder.addParameter("application_id", APPLICATIONID);
        if (parameters != null) {
            parameters.forEach(builder::addParameter);
        }

        try {
            return builder.build().toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException("URL was built with errors.");
        }
    }

    public static URL getURL(final String path) {
        return getURL(path, null);
    }
}
