package forester.jointvibe.deezer.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;

/**
 * Created by FORESTER on 25.04.18.
 */
public class RequestHelper {

    private static final String HTTPS_SCHEMA = "https";
    private static final String DEEZER_HOST = "api.deezer.com";
    private static final String SEARCH_TRACK_PATH = "search/track";
    private static final String SEARCH_PARAM = "q";
    private static final String JSON_MAIN_KEY = "data";

    public static JSONArray searchTrack(String trackName) throws Exception {

        URI uri = new URIBuilder()
                .setScheme(HTTPS_SCHEMA)
                .setHost(DEEZER_HOST)
                .setPath(SEARCH_TRACK_PATH)
                .setParameter(SEARCH_PARAM, trackName)
                .build();
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(uri);
        HttpResponse response = client.execute(request);
        String responseData = IOUtils.toString(response.getEntity().getContent(), "UTF-8");

        return new JSONObject(responseData).getJSONArray(JSON_MAIN_KEY);
    }
}
