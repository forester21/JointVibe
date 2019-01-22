package forester.project;

import com.vk.api.sdk.callback.CallbackApi;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static forester.project.MessageSender.GROUP_ID;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;

@Component
public class CallbackApiHandler extends CallbackApi {

    @Autowired
    private MessageSender sender;

    @Autowired QueueService queueService;

    private static final String BEGIN_KEYWORD = "Начать";
    private static boolean isConfirmation;

    @Override
    public void messageNew(Integer groupId, Message message) {
        if (BEGIN_KEYWORD.equals(message.getBody())){
            sender.enableKeyboard();
        }
        if (!isEmpty(message.getAttachments())){
            queueService.addTracks(message.getUserId(), message.getAttachments());
        }
    }

    @Override
    public void confirmation(Integer groupId) {
        if (GROUP_ID == groupId){
            setConfirmation(true);
        }
    }

    public static boolean isConfirmation() {
        return isConfirmation;
    }

    public static void setConfirmation(boolean isConfirmation) {
        CallbackApiHandler.isConfirmation = isConfirmation;
    }
}
