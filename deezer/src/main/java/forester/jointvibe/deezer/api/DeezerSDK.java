package forester.jointvibe.deezer.api;

import com.sun.jna.Library;

/**
 * Created by FORESTER on 01.07.18.
 */
public interface DeezerSDK extends Library {

    String LIB_NAME = "Nano";

    int init();
    void app_playback_start_or_stop();
    void app_change_content(String str);
    void app_load_content();
    void app_playback_pause_or_resume();
    void app_playback_next();
//    void app_playback_previous();
}
