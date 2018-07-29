import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;

/**
 * Created by FORESTER on 23.07.18.
 */
public class Request {
    private static final String HTTPS_SCHEMA = "https";
    private static final String HOST = "vk.com";
    private static final String SEARCH_TRACK_PATH = "al_audio.php";
    private static final String START_KEY = "<!json>";

    public static JSONObject searchTrack(String trackName) throws Exception {

        URI uri = new URIBuilder()
                .setScheme(HTTPS_SCHEMA)
                .setHost(HOST)
                .setPath(SEARCH_TRACK_PATH)
                .setParameter("access_hash", "")
                .setParameter("act", "load_section")
                .setParameter("al", "1")
                .setParameter("claim", "0")
                .setParameter("offset", "30")
                .setParameter("owner_id", "58559317")
                .setParameter("playlist_id", "-1")
                .setParameter("type", "playlist")
                .build();

//        BasicCookieStore cookieStore = new BasicCookieStore();
//        BasicClientCookie cookie1 = new BasicClientCookie("remixsid", "760b26945e3645418d2fadbd6f2b1fb910fdaf0c65b22cb5d1dc3");
//        cookie1.setDomain("vk.com");
//        cookie1.setPath("/*");
//        BasicClientCookie cookie2 = new BasicClientCookie("remixgp", "7e43b2c36086b5d1ab574e97c7b73844");
//        cookie2.setDomain("vk.com");
//        cookie2.setPath("/*");
//        cookieStore.addCookie(cookie1);
//        cookieStore.addCookie(cookie2);

//        HttpClient client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(uri);
        request.setHeader("cookie","remixsid=760b26945e3645418d2fadbd6f2b1fb910fdaf0c65b22cb5d1dc3; remixgp=7e43b2c36086b5d1ab574e97c7b73844;");
        request.setHeader("user-agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        HttpResponse response = client.execute(request);
        String responseData = IOUtils.toString(response.getEntity().getContent(), "UTF-8");

//        JSONObject(responseData.indexOf())
        int startIndex = responseData.indexOf(START_KEY)+START_KEY.length();
        int endIndex = responseData.indexOf("<!>",startIndex);
        return new JSONObject(responseData.substring(startIndex,endIndex));
    }
}
