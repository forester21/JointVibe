package forester.jointvibe.deezer.api;

import com.sun.jna.Native;

import static forester.jointvibe.deezer.api.DeezerSDK.LIB_NAME;

/**
 * Created by FORESTER on 16.07.18.
 */
public class DeezerPlayer {

    private final DeezerSDK deezer;

    public DeezerPlayer() throws Exception{
        deezer = Native.loadLibrary(LIB_NAME,DeezerSDK.class);
        //TODO use ThreadPool
        new Thread(deezer::init).start();
        //wait for initialization
        Thread.sleep(3000L);
//        deezer.app_playback_start_or_stop();
//        deezer.app_playback_pause_or_resume();
    }

    public void start(){
        deezer.app_playback_start_or_stop();
    }

    public void resumeOrPause(){
        deezer.app_playback_pause_or_resume();
    }

    public void next(String nextTrack) throws Exception{
        deezer.app_change_content(convertLinkToDeezerKey(nextTrack));
        deezer.app_load_content();
        deezer.app_playback_next();
    }

    private String convertLinkToDeezerKey(String trackLink){
        return trackLink.replace("https://www.deezer.com/","dzmedia:///");
    }
}
