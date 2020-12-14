package controller;

import entity.BatchEntity;
import entity.CenterEntity;
import entity.CourseEntity;
import entity.FeePlanEntity;
import entity.StudentEntity;
import entity.UserEntity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import repository.BatchRepository;
import repository.CenterRepository;
import repository.CourseRepository;
import repository.FeePlanRepository;
import repository.StudentRepository;
import repository.UserRepository;
import utils.ReportStudentToExcelView;

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

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "management/management", method = RequestMethod.GET)
    public String showManagementPage(Model model) {

        return "management/management";
    }

    //STUDENT MANAGE
    @RequestMapping(value = "management/student", method = RequestMethod.GET)
    public String showManagerStudent(Model model) {
        List<StudentEntity> studentList = (List<StudentEntity>) studentRepo.findAll();
        model.addAttribute("studentList", studentList);
        return "management/student";
    }

    @RequestMapping(value = "management/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable(name = "id") int id) {
        studentRepo.deleteById(id);
        return "redirect:/management/student";
    }

    @RequestMapping(value = "management/edit/{id}", method = RequestMethod.GET)
    public String showEditStudent(@PathVariable(value = "id") int id, Model model) {

        StudentEntity student = studentRepo.findById(id);
        model.addAttribute("student", student);

        return "management/editStudent";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProduct(StudentEntity student) {
        StudentEntity newStudent = studentRepo.save(student);
        return "redirect:/management/student";
    }

    @RequestMapping(value = "management/addNewStudent", method = RequestMethod.GET)
    public String showAddNewStudent(Model model) {
        UserEntity user = new UserEntity();
        StudentEntity student = new StudentEntity();
        student.setUser(user);
        model.addAttribute("student", student);

        return "management/addNewStudent";
    }

    @RequestMapping(value = "management/addNewStudent", method = RequestMethod.POST)
    public String saveNewStudent(StudentEntity student, Model model) {
        UserEntity user = student.getUser();
        user.setRoleName("ROLE_USER");
        user.setEnabled(true);
        userRepo.save(user);
        student.setUser(user);
        studentRepo.save(student);
        return "redirect:/management/student";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchStudent(@RequestParam(name = "searchText") String searchText, Model model) {

        String searchText1 = "%" + searchText + "%";
        List<StudentEntity> studentList = studentRepo.findByFirstNameLikeOrLastNameLike(searchText, searchText1);
        model.addAttribute("studentList", studentList);
        model.addAttribute("searchText", searchText);
        return "management/student";
    }

    //BATCH MANAGE
    @RequestMapping(value = "management/batch", method = RequestMethod.GET)
    public String showManagerBatch(Model model) {
        List<BatchEntity> batchList = (List<BatchEntity>) batchRepo.findAll();
        model.addAttribute("batchList", batchList);
        return "management/batch";
    }

    @RequestMapping(value = "management/addNewBatch", method = RequestMethod.GET)
    public String showAddNewBatch(Model model) {
        List<CenterEntity> centerList = (List<CenterEntity>) centerRepo.findAll();
        //model.addAttribute("batch", new BatchEntity());
        model.addAttribute("centerList", centerList);
        CenterEntity center = new CenterEntity();
        BatchEntity batch = new BatchEntity();
        batch.setCenter(center);
        model.addAttribute("batch", batch);
        setCenterDropDownList(model);
        return "management/addNewBatch";
    }

    @RequestMapping(value = "management/addNewBatch", method = RequestMethod.POST)
    public String saveNewBatch(BatchEntity batch, Model model) {

        batchRepo.save(batch);
        return "redirect:/management/batch";
    }

    @RequestMapping(value = "management/delete1/{id}", method = RequestMethod.GET)
    public String deleteBatch(@PathVariable(name = "id") int id) {
        batchRepo.deleteById(id);
        return "redirect:/management/batch";
    }

    @RequestMapping(value = "management/edit1/{id}", method = RequestMethod.GET)
    public String showEditBatch(@PathVariable(value = "id") int id, Model model) {
        List<CenterEntity> centerList = (List<CenterEntity>) centerRepo.findAll();

        BatchEntity batch = batchRepo.findById(id);
        model.addAttribute("batch", batch);
        model.addAttribute("centerList", centerList);
        setCenterDropDownList(model);
        return "management/editBatch";
    }

    @RequestMapping(value = "/update1", method = RequestMethod.POST)
    public String updateBatch(BatchEntity batch) {
        BatchEntity newBatch = batchRepo.save(batch);
        return "redirect:/management/batch";
    }

    @RequestMapping(value = "/search1", method = RequestMethod.GET)
    public String searchBatch(@RequestParam(name = "searchText") String searchText, Model model) {

        String searchText1 = "%" + searchText + "%";
        List<BatchEntity> batchList = batchRepo.findByBatchStatusLikeOrClassNameLike(searchText, searchText1);
        model.addAttribute("batchList", batchList);
        model.addAttribute("searchText", searchText);
        return "management/batch";
    }

    //COURSE MANAGE
    @RequestMapping(value = "management/course", method = RequestMethod.GET)
    public String showManagerCourse(Model model) {
        List<CourseEntity> courseList = (List<CourseEntity>) courseRepo.findAll();
        model.addAttribute("courseList", courseList);
        return "management/course";
    }

    @RequestMapping(value = "management/addNewCourse", method = RequestMethod.GET)
    public String showAddNewCourse(Model model) {
        List<CenterEntity> centerList = (List<CenterEntity>) centerRepo.findAll();
        List<FeePlanEntity> feeplanList = (List<FeePlanEntity>) feePlanRepo.findAll();
        model.addAttribute("course", new CourseEntity());

        setCenterDropDownList(model);
        setFeePlanDropDownList(model);
        return "management/addNewCourse";
    }

    @RequestMapping(value = "management/addNewCourse", method = RequestMethod.POST)
    public String saveNewCourse(CourseEntity course, Model model) {

        courseRepo.save(course);
        return "redirect:/management/course";
    }

    @RequestMapping(value = "management/edit2/{id}", method = RequestMethod.GET)
    public String showEditCourse(@PathVariable(value = "id") int id, Model model) {
        List<CenterEntity> centerList = (List<CenterEntity>) centerRepo.findAll();
        List<FeePlanEntity> feeplanList = (List<FeePlanEntity>) feePlanRepo.findAll();
        CourseEntity course = courseRepo.findById(id);
        model.addAttribute("course", course);
        model.addAttribute("centerList", centerList);
        model.addAttribute("feeplanList", feeplanList);
        setCenterDropDownList(model);
        setFeePlanDropDownList(model);
        return "management/editCourse";
    }

    @RequestMapping(value = "/update2", method = RequestMethod.POST)
    public String updateCourse(CourseEntity course) {
        CourseEntity newCourse = courseRepo.save(course);
        return "redirect:management/course";
    }

    @RequestMapping(value = "management/delete2/{id}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable(name = "id") int id) {
        courseRepo.deleteById(id);
        return "redirect:/management/course";
    }

    @RequestMapping(value = "/search2", method = RequestMethod.GET)
    public String searchCourse(@RequestParam(name = "searchText") String searchText, Model model) {

        String searchText1 = "%" + searchText + "%";
        List<CourseEntity> courseList = courseRepo.findByNameContaining(searchText);
        model.addAttribute("courseList", courseList);
        model.addAttribute("searchText", searchText);
        return "management/course";
    }

    //REPORT
    @RequestMapping(value = "management/report", method = RequestMethod.GET)
    public String showManagerReport(Model model) {

        return "management/report";
    }

    @RequestMapping(value = "/search3", method = RequestMethod.GET)
    public String searchReport(@RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, Model model) {

        LocalDate startLocalDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(startDate));
        LocalDate endLocalDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(endDate));
        List<StudentEntity> studentList = studentRepo.findByStartDateBetween(startLocalDate, endLocalDate);
        model.addAttribute("studentList", studentList);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);

        return "management/report";
    }
    
    //EXCEL
    @RequestMapping(value = "/management/downloadExcel", method = RequestMethod.GET)
    public ModelAndView downloadExcel(Model model) {

        List<StudentEntity> student =  (List<StudentEntity>)studentRepo.findAll();
        ReportStudentToExcelView reportList = new ReportStudentToExcelView();
        return new ModelAndView(reportList, "student",student);
        
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
            model.addAttribute("feeplanList", feeplanMap);
        }
    }

}
