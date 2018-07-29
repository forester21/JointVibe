package forester.jointvibe.deezer;

import forester.jointvibe.deezer.api.DeezerPlayer;
import forester.jointvibe.deezer.http.RequestHelper;

import java.util.Map;

/**
 * Created by FORESTER on 16.07.18.
 */
public class Controller {

    private static final String LINK_KEY = "link";

    public void play(String trackName) throws Exception{
        String link = RequestHelper.searchTrack(trackName).getJSONObject(0).getString(LINK_KEY);
        DeezerPlayer deezerPlayer = new DeezerPlayer();
        deezerPlayer.next(link);
    }
}
