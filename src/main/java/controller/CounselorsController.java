
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class CounselorsController {
    
    
    @RequestMapping(value = "/counselors", method = RequestMethod.GET)
    public String showPage(Model model) {
        
        return "counselors";
    }
   
}
