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
@Table(name = "enquiry")
public class EnquiryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate equiryDate;
    private String sex;
    private String address;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private CenterEntity center;
    
    @OneToMany(mappedBy = "enquiry", fetch = FetchType.LAZY)
    List<FollowEntity> followList;

    public EnquiryEntity() {
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

    public LocalDate getEquiryDate() {
        return equiryDate;
    }

    public void setEquiryDate(LocalDate equiryDate) {
        this.equiryDate = equiryDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CenterEntity getCenter() {
        return center;
    }

    public void setCenter(CenterEntity center) {
        this.center = center;
    }

    public List<FollowEntity> getFollowList() {
        return followList;
    }

    public void setFollowList(List<FollowEntity> followList) {
        this.followList = followList;
    }
    

}