
package entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "action")
public class ActionEntity {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private LocalDate date; 
     private String position;
     
    @ManyToOne
    @JoinColumn(name = "id",insertable=false ,updatable=false)
    private StudentEntity student;

    public ActionEntity() {
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
     
}
