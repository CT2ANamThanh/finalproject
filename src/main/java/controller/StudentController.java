package controller;

import entity.BatchEntity;
import entity.CenterEntity;
import entity.CourseEntity;
import entity.StudentEntity;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    JavaMailSender javaMail;

    //login
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLogin(Model model) {

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin2(Model model) {

        return "login";
    }

    //logout
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.removeAttribute("management");

        return "redirect:/";
    }
    //homepage

    @RequestMapping(value = "user/homePage", method = RequestMethod.GET)
    public String showPage(Model model) {
        //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        return "user/homePage";
    }

    @RequestMapping(value = "user/courseHomePage", method = RequestMethod.GET)
    public String sendEmail(Model model) {

        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        List<CourseEntity> courseList = (List<CourseEntity>) courseRepo.findAll();

        model.addAttribute("courseList", courseList);
//send mail

        return "user/courseHomePage";
    }

    @RequestMapping(value = "/registerCourse", method = RequestMethod.GET)
    public String showRegisterCourse(Model model) {
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(student.getEmail());
        msg.setSubject("Register Course");
        msg.setText("You have successfully registered for the course");

        javaMail.send(msg);
        return "user/registerCourse";
    }

    @RequestMapping(value = "user/centerHomePage", method = RequestMethod.GET)
    public String showCenter(Model model) {
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        List<CenterEntity> centerList = (List<CenterEntity>) centerRepo.findAll();

        model.addAttribute("centerList", centerList);

        return "user/centerHomePage";
    }

    @RequestMapping(value = "user/batchHomePage", method = RequestMethod.GET)
    public String showBatch(Model model) {
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        List<BatchEntity> batchList = (List<BatchEntity>) batchRepo.findAll();

        model.addAttribute("batchList", batchList);

        return "user/batchHomePage";
    }

    @RequestMapping(value = "/user/infomation", method = RequestMethod.GET)
    public String showInfomation(Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        StudentEntity student = studentRepo.getStudentByUserName(userName);
        model.addAttribute("student", student);

        return "user/infomation";
    }

    @RequestMapping(value = "/search7", method = RequestMethod.GET)
    public String searchCourse(@RequestParam(name = "searchText") String searchText, Model model) {
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        String searchText1 = "%" + searchText + "%";
        List<CourseEntity> courseList = courseRepo.findByNameLike(searchText);
        model.addAttribute("courseList", courseList);
        model.addAttribute("searchText", searchText);
        return "user/courseHomePage";
    }

    /*@RequestMapping(value = "user/edit", method = RequestMethod.GET)
    public String showEditInformation(Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
         StudentEntity student = studentRepo.getStudentByUserName(userName);
        model.addAttribute("student", student);

        return "user/editInformation";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProduct(StudentEntity student) {
        StudentEntity newStudent = studentRepo.save(student);
        return "redirect:/user/editInformation";
    }*/
}
