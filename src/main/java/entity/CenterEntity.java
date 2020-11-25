package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "center")
public class CenterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "center", fetch = FetchType.LAZY)
    List<EnquiryEntity> enquiryList;

    

    @OneToMany(mappedBy = "center", fetch = FetchType.LAZY)
    List<BatchEntity> batchList;

    @OneToMany(mappedBy = "center", fetch = FetchType.LAZY)
    List<CourseEntity> courseList;

    public CenterEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<EnquiryEntity> getEnquiryList() {
        return enquiryList;
    }

    public void setEnquiryList(List<EnquiryEntity> enquiryList) {
        this.enquiryList = enquiryList;
    }

   

    public List<BatchEntity> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<BatchEntity> batchList) {
        this.batchList = batchList;
    }

    public List<CourseEntity> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseEntity> courseList) {
        this.courseList = courseList;
    }

    
}
