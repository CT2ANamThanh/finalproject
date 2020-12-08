
package controller;

import entity.EnquiryEntity;
import entity.FollowEntity;
import entity.StudentEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.EnquiryRepository;
import repository.FollowRepository;

@Controller
@RequestMapping(value = "/")
public class CounselorsController {
    
    @Autowired
    EnquiryRepository enquiryRepo;
    
    @Autowired
    FollowRepository followRepo;
    @RequestMapping(value = "counselors/counselors", method = RequestMethod.GET)
    public String showPage(Model model) {
        
        return "counselors/counselors";
    }
    //ENQUIRY
    @RequestMapping(value = "counselors/enquiry", method = RequestMethod.GET)
    public String showManagerEnquiry(Model model) {
        List<EnquiryEntity> enquiryList = (List<EnquiryEntity>) enquiryRepo.findAll();
        model.addAttribute("enquiryList", enquiryList);
        return "counselors/enquiry";
    }
     @RequestMapping(value = "counselors/addNewEnquiry", method = RequestMethod.GET)
    public String showAddNewEnquiry(Model model) {
              
        model.addAttribute("enquiry", new EnquiryEntity());
        
          
        return "counselors/addNewEnquiry";
    }

    @RequestMapping(value = "counselors/addNewEnquiry", method = RequestMethod.POST)
    public String saveNewEnquiry(EnquiryEntity enquiry, Model model) {
        
        enquiryRepo.save(enquiry);
        return "redirect:/counselors/enquiry";
    }
    @RequestMapping(value = "counselors/delete/{id}", method = RequestMethod.GET)
    public String deleteBatch(@PathVariable(name = "id") int id) {
        enquiryRepo.deleteById(id);
        return "redirect:/counselors/enquiry";
    }
    
    @RequestMapping(value = "counselors/edit/{id}", method = RequestMethod.GET)
    public String showEditEnquiry(@PathVariable(value = "id") int id, Model model) {

        EnquiryEntity enquiry = enquiryRepo.findById(id);
        model.addAttribute("enquiry", enquiry);

        return "counselors/editEnquiry";
    }

    @RequestMapping(value = "/update4", method = RequestMethod.POST)
    public String updateEnquiry(EnquiryEntity enquiry) {
        EnquiryEntity newEnquiry = enquiryRepo.save(enquiry);
        return "redirect:/counselors/enquiry";
    }
    
    @RequestMapping(value = "/search4", method = RequestMethod.GET)
    public String searchStudent(@RequestParam(name = "searchText") String searchText, Model model) {

        String searchText1 = "%" + searchText + "%";
        List<EnquiryEntity> enquiryList = enquiryRepo.findByNameLikeOrEnquiryStatusLike(searchText, searchText1);
        model.addAttribute("enquiryList", enquiryList);
        model.addAttribute("searchText", searchText);
        return "counselors/enquiry";
    }
   
    
    //FOLLOW UP
    @RequestMapping(value = "counselors/follow", method = RequestMethod.GET)
    public String showFollowUp(Model model) {
        List<FollowEntity> followList = (List<FollowEntity>) followRepo.findAll();
        model.addAttribute("followList", followList);
        return "counselors/follow";
    }
}
