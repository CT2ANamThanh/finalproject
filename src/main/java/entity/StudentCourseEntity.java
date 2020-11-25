package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studentcourse")
public class StudentCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id",insertable=false ,updatable=false)
    private BatchEntity batch;

    @ManyToOne
    @JoinColumn(name = "id",insertable=false ,updatable=false)
    private FeePlanEntity feeplan;
    
    @ManyToOne
    @JoinColumn(name = "id",insertable=false ,updatable=false)
    private StudentEntity student;
    
    @ManyToOne
    @JoinColumn(name = "id",insertable=false ,updatable=false)
    private CourseEntity course;
    
    @ManyToOne
    @JoinColumn(name = "id",insertable=false ,updatable=false)
    private DiscountTypeEntity discounttype;

    public StudentCourseEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BatchEntity getBatch() {
        return batch;
    }

    public void setBatch(BatchEntity batch) {
        this.batch = batch;
    }

   

    public FeePlanEntity getFeeplan() {
        return feeplan;
    }

    public void setFeeplan(FeePlanEntity feeplan) {
        this.feeplan = feeplan;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public DiscountTypeEntity getDiscounttype() {
        return discounttype;
    }

    public void setDiscounttype(DiscountTypeEntity discounttype) {
        this.discounttype = discounttype;
    }
    
    
}
