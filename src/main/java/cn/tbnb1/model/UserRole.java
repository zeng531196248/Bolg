package cn.tbnb1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
* @ClassName: UserRole 
* @Description: 角色分配
* @author tbnb1.cn
* @date 2017年1月16日 下午2:23:44 
*
 */

@Entity
@Table(name="t_userrole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** 用户Id */
    private Integer uid;

    /** 角色Id */
    private Integer rid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}
    
    
    
    
    
}
