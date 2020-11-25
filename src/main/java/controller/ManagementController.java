
package controller;

import entity.BatchEntity;
import entity.CenterEntity;
import entity.CourseEntity;
import entity.FeePlanEntity;
import entity.StudentEntity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.BatchRepository;
import repository.CenterRepository;
import repository.CourseRepository;
import repository.FeePlanRepository;
import repository.StudentRepository;

@Controller
@RequestMapping(value = "/")
public class ManagementController {
    
    @Autowired
    StudentRepository studentRepo;
    
    @Autowired
    FeePlanRepository feePlanRepo;
    
    @Autowired
    BatchRepository batchRepo;
    
    @Autowired
    CenterRepository centerRepo;
    
    @Autowired
    CourseRepository courseRepo;
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showManagementPage(Model model) {
        
        return "management";
    }
    
    //STUDENT MANAGE
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String showManagerStudent(Model model) {
        List<StudentEntity> studentList = (List<StudentEntity>) studentRepo.findAll();
        model.addAttribute("studentList", studentList);
        return "student";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable(name = "id") int id) {
        studentRepo.deleteById(id);
        return "redirect:/student";
    }
    
   @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditStudent(@PathVariable(value = "id") int id, Model model) {
        
        StudentEntity student = studentRepo.findById(id);
        model.addAttribute("student", student);

             
        return "editStudent";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProduct(StudentEntity student) {
        StudentEntity newStudent = studentRepo.save(student);
        return "redirect:/student";
    }
    
    @RequestMapping(value = "/addNewStudent", method = RequestMethod.GET)
    public String showAddNewStudent(Model model) {
              
        model.addAttribute("student", new StudentEntity());
        
          
        return "addNewStudent";
    }

    @RequestMapping(value = "/addNewStudent", method = RequestMethod.POST)
    public String saveNewStudent(StudentEntity student, Model model) {
        
        studentRepo.save(student);
        return "redirect:/student";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchStudent(@RequestParam(name = "searchText") String searchText, Model model) {

        String searchText1 = "%" + searchText + "%";
        List<StudentEntity> studentList = studentRepo.f
        model.addAttribute("studentList", studentList);
        model.addAttribute("searchText", searchText);
        return "student";
    }
    
  //BATCH MANAGE
    @RequestMapping(value = "/batch", method = RequestMethod.GET)
    public String showManagerBatch(Model model) {
        List<BatchEntity> batchList = (List<BatchEntity>) batchRepo.findAll();
        model.addAttribute("batchList", batchList);
        return "batch";
    }
    
    @RequestMapping(value = "/addNewBatch", method = RequestMethod.GET)
    public String showAddNewBatch(Model model) {
        List<CenterEntity> centerList = (List<CenterEntity>) centerRepo.findAll();
        //model.addAttribute("batch", new BatchEntity());
        model.addAttribute("centerList", centerList);
        CenterEntity center = new CenterEntity();
          BatchEntity batch = new BatchEntity();
          batch.setCenter(center);
          model.addAttribute("batch", batch);
          setCenterDropDownList(model);
        return "addNewBatch";
    }

    @RequestMapping(value = "/addNewBatch", method = RequestMethod.POST)
    public String saveNewBatch(BatchEntity batch, Model model) {
        
        batchRepo.save(batch);
        return "redirect:/batch";
    }
    @RequestMapping(value = "/delete1/{id}", method = RequestMethod.GET)
    public String deleteBatch(@PathVariable(name = "id") int id) {
        batchRepo.deleteById(id);
        return "redirect:/batch";
    }
    
    @RequestMapping(value = "/edit1/{id}", method = RequestMethod.GET)
    public String showEditBatch(@PathVariable(value = "id") int id, Model model) {
        List<CenterEntity> centerList = (List<CenterEntity>) centerRepo.findAll();
        
        BatchEntity batch = batchRepo.findById(id);
        model.addAttribute("batch", batch);
        model.addAttribute("centerList", centerList);
        setCenterDropDownList(model);
        return "editBatch";
    }

    @RequestMapping(value = "/update1", method = RequestMethod.POST)
    public String updateBatch(BatchEntity batch) {
        BatchEntity newBatch = batchRepo.save(batch);
        return "redirect:/batch";
    }
    @RequestMapping(value = "/search1", method = RequestMethod.GET)
    public String searchBatch(@RequestParam(name = "searchText") String searchText, Model model) {

        String searchText1 = "%" + searchText + "%";
        List<BatchEntity> batchList = batchRepo.f
        model.addAttribute("batchList", batchList);
        model.addAttribute("searchText", searchText);
        return "batch";
    }
    
    //COURSE MANAGE
    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String showManagerCourse(Model model) {
        List<CourseEntity> courseList = (List<CourseEntity>) courseRepo.findAll();
        model.addAttribute("courseList", courseList);
        return "course";
    }
    @RequestMapping(value = "/addNewCourse", method = RequestMethod.GET)
    public String showAddNewCourse(Model model) {
        List<CenterEntity> centerList = (List<CenterEntity>) centerRepo.findAll();
        List<FeePlanEntity> feeplanList = (List<FeePlanEntity>) feePlanRepo.findAll();      
        model.addAttribute("course", new CourseEntity());
        
        setCenterDropDownList(model);
        setFeePlanDropDownList(model);
        return "addNewCourse";
    }

    @RequestMapping(value = "/addNewCourse", method = RequestMethod.POST)
    public String saveNewCourse(CourseEntity course, Model model) {
        
        courseRepo.save(course);
        return "redirect:/course";
    }
    
    @RequestMapping(value = "/edit2/{id}", method = RequestMethod.GET)
    public String showEditCourse(@PathVariable(value = "id") int id, Model model) {
        List<CenterEntity> centerList = (List<CenterEntity>) centerRepo.findAll();
        List<FeePlanEntity> feeplanList = (List<FeePlanEntity>) feePlanRepo.findAll();
        CourseEntity course = courseRepo.findById(id);
        model.addAttribute("course", course);
        model.addAttribute("centerList", centerList);
        model.addAttribute("feeplanList", feeplanList);
        setCenterDropDownList(model);
        setFeePlanDropDownList(model);
        return "editCourse";
    }

    @RequestMapping(value = "/update2", method = RequestMethod.POST)
    public String updateCourse(CourseEntity course) {
        CourseEntity newCourse = courseRepo.save(course);
        return "redirect:/course";
    }
    
    @RequestMapping(value = "/delete2/{id}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable(name = "id") int id) {
        courseRepo.deleteById(id);
        return "redirect:/course";
    }
    
    @RequestMapping(value = "/search2", method = RequestMethod.GET)
    public String searchCourse(@RequestParam(name = "searchText") String searchText, Model model) {

        String searchText1 = "%" + searchText + "%";
        List<CourseEntity> courseList = courseRepo
        model.addAttribute("courseList", courseList);
        model.addAttribute("searchText", searchText);
        return "course";
    }
    
    
    
    
    private void setCenterDropDownList(Model model) {
        List<CenterEntity> centerList = (List<CenterEntity>) centerRepo.findAll();
        if (!centerList.isEmpty()) {
            Map<Integer, String> centerMap = new LinkedHashMap<>();
            for (CenterEntity centerEntity : centerList) {
                centerMap.put(centerEntity.getId(), centerEntity.getName());
            }
            model.addAttribute("centerList", centerMap);
        }
    }
     private void setFeePlanDropDownList(Model model) {
        List<FeePlanEntity> feeplanList = (List<FeePlanEntity>) feePlanRepo.findAll();
        if (!feeplanList.isEmpty()) {
            Map<Integer, String> feeplanMap = new LinkedHashMap<>();
            for (FeePlanEntity feePlanEntity : feeplanList) {
                feeplanMap.put(feePlanEntity.getId(), feePlanEntity.getFeePlanType());
            }
            model.addAttribute("feeplanList",feeplanMap);
        }
    }
}
