package entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "feeplan")
public class FeePlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String feePlanType;
    private String numberOfPay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @OneToMany(mappedBy = "feeplan", fetch = FetchType.LAZY)
    List<StudentCourseEntity> studentCourseList;

    @OneToMany(mappedBy = "feeplan", fetch = FetchType.LAZY)
    List<CourseEntity> courseList;

    public FeePlanEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeePlanType() {
        return feePlanType;
    }

    public void setFeePlanType(String feePlanType) {
        this.feePlanType = feePlanType;
    }

    public String getNumberOfPay() {
        return numberOfPay;
    }

    public void setNumberOfPay(String numberOfPay) {
        this.numberOfPay = numberOfPay;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public List<StudentCourseEntity> getStudentCourseList() {
        return studentCourseList;
    }

    public void setStudentCourseList(List<StudentCourseEntity> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }

    public List<CourseEntity> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseEntity> courseList) {
        this.courseList = courseList;
    }
    
    

}