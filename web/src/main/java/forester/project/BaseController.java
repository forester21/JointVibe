package forester.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by FORESTER on 02.07.18.
 */
@Controller
@RequestMapping("/")
public class BaseController {
    @GetMapping
    public String getStartPage(){
        return "index.html";
    }
}
