
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
@Table(name = "method")
public class MethodEntity {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String methodName;
    
    @OneToMany(mappedBy = "method", fetch = FetchType.LAZY)
    List<FollowEntity> followList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    

    public List<FollowEntity> getFollowList() {
        return followList;
    }

    public void setFollowList(List<FollowEntity> followList) {
        this.followList = followList;
    }
    
    
}
