package forester.project;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private static final String ACCESS_TOKEN = "edb98c32352b2107e25c435397669dcf65c0689b412260d3ef579022fd20e03aa97567ca884195bdd575b";
    private static final String KEYBOARD_PARAM = "keyboard";
    public static final int GROUP_ID = 177035521;


    private VkApiClient vk;
    private GroupActor groupActor;

    public MessageSender() {
        TransportClient transportClient = HttpTransportClient.getInstance();
        vk = new VkApiClient(transportClient);
        groupActor = new GroupActor(GROUP_ID, ACCESS_TOKEN);
    }

    public void enableKeyboard() {
        try {
            vk.messages()
                    .send(groupActor)
                    .userId(58559317)
                    .message("Welcome!")
                    .unsafeParam(KEYBOARD_PARAM, getKeyboardJSON())
                    .execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getKeyboardJSON() {
        try {
            return IOUtils.toString(getClass().getResourceAsStream("/keyboard.json"), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
