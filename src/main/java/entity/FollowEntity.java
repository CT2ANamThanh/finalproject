
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
@Table(name = "follow")
public class FollowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String content;
    private String result;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate meetTime;
    

    @ManyToOne
    @JoinColumn(name = "enquiryId")
    private EnquiryEntity enquiry;
    
    @ManyToOne
    @JoinColumn(name= "methodId")
    private MethodEntity method;

    public FollowEntity() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDate getMeetTime() {
        return meetTime;
    }

    public void setMeetTime(LocalDate meetTime) {
        this.meetTime = meetTime;
    }

    public EnquiryEntity getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(EnquiryEntity enquiry) {
        this.enquiry = enquiry;
    }

    public MethodEntity getMethod() {
        return method;
    }

    public void setMethod(MethodEntity method) {
        this.method = method;
    }

    
}
