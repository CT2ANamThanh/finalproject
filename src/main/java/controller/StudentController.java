package controller;

import entity.BatchEntity;
import entity.CenterEntity;
import entity.CourseEntity;
import entity.StudentEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.BatchRepository;
import repository.CenterRepository;
import repository.CourseRepository;
import repository.StudentRepository;

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
    
     @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLongin(Model model) {

        return "login";
    }
    
    @RequestMapping(value = "homePage", method = RequestMethod.GET)
    public String showPage(Model model) {

        return "homePage";
    }

    @RequestMapping(value = "/courseHomePage", method = RequestMethod.GET)
    public String showProduct(Model model) {
        List<CourseEntity> courseList = (List<CourseEntity>) courseRepo.findAll();

        model.addAttribute("courseList", courseList);

        return "courseHomePage";
    }

    @RequestMapping(value = "/centerHomePage", method = RequestMethod.GET)
    public String showCenter(Model model) {
        List<CenterEntity> centerList = (List<CenterEntity>) centerRepo.findAll();

        model.addAttribute("centerList", centerList);

        return "centerHomePage";
    }

    @RequestMapping(value = "/batchHomePage", method = RequestMethod.GET)
    public String showBatch(Model model) {
        List<BatchEntity> batchList = (List<BatchEntity>) batchRepo.findAll();

        model.addAttribute("batchList", batchList);

        return "batchHomePage";
    }
    @RequestMapping(value = "/infomation", method = RequestMethod.GET)
    public String showInfomation(Model model) {
        List<StudentEntity> studentList = (List<StudentEntity>) studentRepo.findAll();
       

        model.addAttribute("studentList", studentList);

        return "infomation";
    }

    /*@RequestMapping(value = "/infomation/{id}", method = RequestMethod.GET)
    public String showInfomation(@PathVariable(value = "id")int id,Model model) {
        List<StudentEntity> studentList = (List<StudentEntity>) studentRepo.findAll();
        StudentEntity student = studentRepo.finById(id);
        model.addAttribute("student", student);

        model.addAttribute("studentList", studentList);

        return "infomation";
    }*/
    
}
