package entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private CenterEntity center;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    List<FeePlanEntity> feePlanList;
    
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    List<CourseDetailsEntity> courseDetailsList;
    
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    List<StudentCourseEntity> studentCourseList;

    public CourseEntity() {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public CenterEntity getCenter() {
        return center;
    }

    public void setCenter(CenterEntity center) {
        this.center = center;
    }

    public List<FeePlanEntity> getFeePlanList() {
        return feePlanList;
    }

    public void setFeePlanList(List<FeePlanEntity> feePlanList) {
        this.feePlanList = feePlanList;
    }

    public List<CourseDetailsEntity> getCourseDetailsList() {
        return courseDetailsList;
    }

    public void setCourseDetailsList(List<CourseDetailsEntity> courseDetailsList) {
        this.courseDetailsList = courseDetailsList;
    }

    public List<StudentCourseEntity> getStudentCourseList() {
        return studentCourseList;
    }

    public void setStudentCourseList(List<StudentCourseEntity> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }
    
    

   

    
}
