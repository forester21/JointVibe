package forester.jointvibe.deezer;

import com.sun.jna.Native;
import forester.jointvibe.deezer.api.DeezerSDK;

/**
 * Created by FORESTER on 25.04.18.
 */
public class Tester {
    private static final String AUTH_ENDPOINT = "https://accounts.spotify.com/authorize";
    private static final String ClientID = "5a83be8de34e44b288b30f164efb943b";

//    public static void authorize() throws Exception{
//        URI uri = new URIBuilder()
//                .setHost("accounts.spotify.com")
//                .setPath("authorize")
//                .setParameter("client_id",ClientID)
//                .setParameter("response_type","code")
//                .setParameter("redirect_uri","null")
//                .build();
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpGet request = new HttpGet(uri);
//
//    }

//    public static native void my_test_func();
//
//    static {
//        Native.register("Nano");
//    }

//    public static void main(String[] args) {
//        my_test_func();
////        System.out.println("sin(0)=" + sin(0));
//    }
//
    public static void main1(String[] args) throws Exception {
        DeezerSDK deezer = Native.loadLibrary("Nano",DeezerSDK.class);
        new Thread(() -> deezer.init()).start();
        Thread.sleep(5000L);
        deezer.app_playback_start_or_stop();
        System.out.println("YOPTODYEVERYBODY");
        Thread.sleep(5000L);
//        deezer.app_playback_start_or_stop();
        deezer.app_change_content("dzmedia:///track/10287076");
        deezer.app_load_content();
        deezer.app_playback_next();
        Thread.sleep(5000L);
    }

    public static void main(String[] args) throws Exception{
        Controller controller = new Controller();
        controller.play("нет монет");
    }
}
