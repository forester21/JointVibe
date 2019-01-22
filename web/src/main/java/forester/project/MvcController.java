package forester.project;

import com.vk.api.sdk.callback.CallbackApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by FORESTER on 02.07.18.
 */
@Controller
@RequestMapping("/")
public class MvcController {

    @Autowired
    private CallbackApi callback;

    private static final String CONFIRMATION_CODE = "737fc5d9";

//    @GetMapping
//    public String getStartPage(){
//        System.out.println("income!");
//        return "index.html";
//    }

    @PostMapping
    @ResponseBody
    public String verify(@RequestBody String request) {
        System.out.println(request);
        callback.parse(request);
        if (CallbackApiHandler.isConfirmation()){
            CallbackApiHandler.setConfirmation(false);
            return CONFIRMATION_CODE;
        }
        return "ok";
    }
}
