package controller;

import entity.BatchEntity;
import entity.CenterEntity;
import entity.CourseEntity;
import entity.StudentEntity;
import entity.UserEntity;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.BatchRepository;
import repository.CenterRepository;
import repository.CourseRepository;
import repository.StudentRepository;
import repository.UserRepository;

@Controller
@RequestMapping(value = "/")
public class StudentController {

    @Autowired
    CourseRepository courseRepo;
    @Autowired
    CenterRepository centerRepo;
    @Autowired
    BatchRepository batchRepo;
    @Autowired
    StudentRepository studentRepo;
    @Autowired
    UserRepository userRepo;
    
     @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLogin(Model model) {

        return "login";
    }
   @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin2(Model model) {

        return "login";
    }
    
    @RequestMapping(value = "user/homePage", method = RequestMethod.GET)
    public String showPage(Model model) {

        return "user/homePage";
    }
     @RequestMapping(value = "managerment/managerment", method = RequestMethod.GET)
    public String showManagement(Model model) {

        return "managerment/managerment";
    }
     @RequestMapping(value = "counselor/counselor", method = RequestMethod.GET)
    public String showCounselor(Model model) {

        return "counselor/counselor";
    }

    @RequestMapping(value = "user/courseHomePage", method = RequestMethod.GET)
    public String showProduct(Model model) {
        List<CourseEntity> courseList = (List<CourseEntity>) courseRepo.findAll();

        model.addAttribute("courseList", courseList);

        return "user/courseHomePage";
    }

    @RequestMapping(value = "user/centerHomePage", method = RequestMethod.GET)
    public String showCenter(Model model) {
        List<CenterEntity> centerList = (List<CenterEntity>) centerRepo.findAll();

        model.addAttribute("centerList", centerList);

        return "user/centerHomePage";
    }

    @RequestMapping(value = "user/batchHomePage", method = RequestMethod.GET)
    public String showBatch(Model model) {
        List<BatchEntity> batchList = (List<BatchEntity>) batchRepo.findAll();

        model.addAttribute("batchList", batchList);

        return "user/batchHomePage";
    }
    @RequestMapping(value = "user/infomation", method = RequestMethod.GET)
    public String showInfomation(Model model) {
        List<StudentEntity> studentList = (List<StudentEntity>) studentRepo.findAll();
       

        model.addAttribute("studentList", studentList);

        return "user/infomation";
    }
    
   
}
