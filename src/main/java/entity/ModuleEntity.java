
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
@Table(name = "module")
public class ModuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY)
    List<CourseDetailsEntity> courseDetailsList;

    public ModuleEntity() {
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

    public List<CourseDetailsEntity> getCourseDetailsList() {
        return courseDetailsList;
    }

    public void setCourseDetailsList(List<CourseDetailsEntity> courseDetailsList) {
        this.courseDetailsList = courseDetailsList;
    }
    
    
}
