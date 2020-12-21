package controller;

import entity.EnquiryEntity;
import entity.FollowEntity;
import entity.MethodEntity;
import entity.StudentEntity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.EnquiryRepository;
import repository.FollowRepository;
import repository.MethodRepository;
import repository.StudentRepository;

@Controller
@RequestMapping(value = "/")
public class CounselorsController {

    @Autowired
    EnquiryRepository enquiryRepo;

    @Autowired
    FollowRepository followRepo;

    @Autowired
    MethodRepository methodRepo;


    @Autowired
    StudentRepository studentRepo;


    
    

    @RequestMapping(value = "counselors/counselors", method = RequestMethod.GET)
    public String showPage(Model model) {
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        return "counselors/counselors";
    }



    //Manage Student Counselors
     @RequestMapping(value = "counselors/student2/{page_id}", method = RequestMethod.GET)
    public String showManagerStudent(Model model,@PathVariable("page_id") int page_id) {
        //pagination
       
        int limit = 5;
        int offset= (page_id -1)*limit;
        

        List<StudentEntity> studentList = studentRepo.getEmployeesByPage(limit, offset);
        model.addAttribute("studentList", studentList);
        
        //List
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        //List<StudentEntity> studentList = (List<StudentEntity>) studentRepo.findAll();
        //model.addAttribute("studentList", studentList);
        return "counselors/student2";
    }
    @RequestMapping(value = "counselors/student2/delete2/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable(name = "id") int id) {
        studentRepo.deleteById(id);
        return "redirect:/counselors/student2/1";
    }
    @RequestMapping(value = "counselors/edit2/{id}", method = RequestMethod.GET)
    public String showEditStudent(@PathVariable(value = "id") int id, Model model) {

        StudentEntity student = studentRepo.findById(id);
        model.addAttribute("student", student);

        return "counselors/editStudent2";
    }

    @RequestMapping(value = "/update6", method = RequestMethod.POST)
    public String updateProduct(StudentEntity student) {
        StudentEntity newStudent = studentRepo.save(student);
        return "redirect:/counselors/student2/1";
    }
    @RequestMapping(value = "/search6", method = RequestMethod.GET)
    public String searchStudent(@RequestParam(name = "searchText") String searchText, Model model) {

        String searchText1 = "%" + searchText + "%";
        List<StudentEntity> studentList = studentRepo.findByFirstNameLikeOrLastNameLike(searchText, searchText1);
        model.addAttribute("studentList", studentList);
        model.addAttribute("searchText", searchText);
        return "counselors/student2";
    }
    

    //ENQUIRY
    @RequestMapping(value = "counselors/enquiry/{page_id}", method = RequestMethod.GET)
    public String showManagerEnquiry(Model model,@PathVariable("page_id") int page_id) {
        //pagination
       
        int limit = 5;
        int offset= (page_id -1)*limit;
        

        List<EnquiryEntity> enquiryList = enquiryRepo.getEmployeesByPage4(limit, offset);
        model.addAttribute("enquiryList", enquiryList);
        
        //List
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        //List<EnquiryEntity> enquiryList = (List<EnquiryEntity>) enquiryRepo.findAll();
        //model.addAttribute("enquiryList", enquiryList);
        return "counselors/enquiry";
    }

    @RequestMapping(value = "counselors/addNewEnquiry", method = RequestMethod.GET)
    public String showAddNewEnquiry(Model model) {
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);

        model.addAttribute("enquiry", new EnquiryEntity());

        return "counselors/addNewEnquiry";
    }

    @RequestMapping(value = "counselors/addNewEnquiry", method = RequestMethod.POST)
    public String saveNewEnquiry(EnquiryEntity enquiry, Model model) {

        enquiryRepo.save(enquiry);
        return "redirect:/counselors/enquiry/1";
    }

    @RequestMapping(value = "counselors/enquiry/delete/{id}", method = RequestMethod.GET)
    public String deleteEnquiry(@PathVariable(name = "id") int id) {

        enquiryRepo.deleteById(id);
        return "redirect:/counselors/enquiry/1";
    }

    @RequestMapping(value = "counselors/edit/{id}", method = RequestMethod.GET)
    public String showEditEnquiry(@PathVariable(value = "id") int id, Model model) {
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        EnquiryEntity enquiry = enquiryRepo.findById(id);
        model.addAttribute("enquiry", enquiry);

        return "counselors/editEnquiry";
    }

    @RequestMapping(value = "/update4", method = RequestMethod.POST)
    public String updateEnquiry(EnquiryEntity enquiry) {
        EnquiryEntity newEnquiry = enquiryRepo.save(enquiry);
        return "redirect:/counselors/enquiry/1";
    }

    @RequestMapping(value = "/search4", method = RequestMethod.GET)
    public String searchEnquiry(@RequestParam(name = "searchText") String searchText, Model model) {

        String searchText1 = "%" + searchText + "%";
        List<EnquiryEntity> enquiryList = enquiryRepo.findByNameLikeOrEnquiryStatusLike(searchText, searchText1);
        model.addAttribute("enquiryList", enquiryList);
        model.addAttribute("searchText", searchText);
        return "counselors/enquiry";
    }

    //FOLLOW UP
    @RequestMapping(value = "counselors/follow/{page_id}", method = RequestMethod.GET)
    public String showFollowUp(Model model,@PathVariable("page_id") int page_id) {
        //pagination
       
        int limit = 5;
        int offset= (page_id -1)*limit;
        

        List<FollowEntity> followList = followRepo.getEmployeesByPage5(limit, offset);
        model.addAttribute("followList", followList);
        
        //List
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        //List<FollowEntity> followList = (List<FollowEntity>) followRepo.findAll();
        //model.addAttribute("followList", followList);
        return "counselors/follow";
    }

    @RequestMapping(value = "counselors/addNewFollow", method = RequestMethod.GET)
    public String showAddNewFollow(Model model) {
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        List<EnquiryEntity> enquiryList = (List<EnquiryEntity>) enquiryRepo.findAll();
        List<MethodEntity> methodList = (List<MethodEntity>) methodRepo.findAll();
        model.addAttribute("follow", new FollowEntity());

        setEnquiryDropDownList(model);
        setMethodDropDownList(model);
        return "counselors/addNewFollow";
    }

    @RequestMapping(value = "counselors/addNewFollow", method = RequestMethod.POST)
    public String saveNewFollow(FollowEntity follow, Model model) {

        followRepo.save(follow);
        return "redirect:/counselors/follow/1";
    }

    @RequestMapping(value = "counselors/follow/delete1/{id}", method = RequestMethod.GET)
    public String deleteFollow(@PathVariable(name = "id") int id) {
        followRepo.deleteById(id);
        return "redirect:/counselors/follow/1";
    }

    @RequestMapping(value = "counselors/edit1/{id}", method = RequestMethod.GET)
    public String showEditFollow(@PathVariable(value = "id") int id, Model model) {
        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        StudentEntity student = studentRepo.getStudentByUserName(userName);
        lastName = student.getLastName();

        model.addAttribute("lastName", lastName);
        
        List<EnquiryEntity> enquiryList = (List<EnquiryEntity>) enquiryRepo.findAll();
        List<FollowEntity> followList = (List<FollowEntity>) followRepo.findAll();
        FollowEntity follow = followRepo.findById(id);
        model.addAttribute("follow", follow);
        model.addAttribute("enquiryList", enquiryList);
        model.addAttribute("followList", followList);
        setEnquiryDropDownList(model);
        setMethodDropDownList(model);
        return "counselors/editFollow";
    }

    @RequestMapping(value = "/update5", method = RequestMethod.POST)
    public String updateFollow(FollowEntity follow) {
        FollowEntity newFollow = followRepo.save(follow);
        return "redirect:/counselors/follow/1";
    }

    @RequestMapping(value = "/search5", method = RequestMethod.GET)
    public String searchFollow(@RequestParam(name = "searchText") String searchText, Model model) {

        String searchText1 = "%" + searchText + "%";
        List<FollowEntity> followList = followRepo.findByResultLike(searchText);
        model.addAttribute("followList", followList);
        model.addAttribute("searchText", searchText);
        return "counselors/follow";
    }

    private void setEnquiryDropDownList(Model model) {
        List<EnquiryEntity> enquiryList = (List<EnquiryEntity>) enquiryRepo.findAll();
        if (!enquiryList.isEmpty()) {
            Map<Integer, String> enquiryMap = new LinkedHashMap<>();
            for (EnquiryEntity enquiryEntity : enquiryList) {
                enquiryMap.put(enquiryEntity.getId(), enquiryEntity.getName());
            }
            model.addAttribute("enquiryList", enquiryMap);
        }
    }

    private void setMethodDropDownList(Model model) {
        List<MethodEntity> methodList = (List<MethodEntity>) methodRepo.findAll();
        if (!methodList.isEmpty()) {
            Map<Integer, String> methodMap = new LinkedHashMap<>();
            for (MethodEntity methodEntity : methodList) {
                methodMap.put(methodEntity.getId(), methodEntity.getMethodName());
            }
            model.addAttribute("methodList", methodMap);
        }
    }
}
