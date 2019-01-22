package forester.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;


@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/hello")
    @SendTo("/topic/qwe")
    public String send(Principal principal, String message){
        System.out.println(message);
        return "bb";
//        System.out.println(msg);
//        simpMessagingTemplate.convertAndSendToUser(, "/topic", "bb");
    }

    @SubscribeMapping("/topic/qwe")
    public String init() {
        System.out.println("subsr");
        return "sub!";
    }
}
