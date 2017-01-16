package cn.tbnb1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * \
* @ClassName: RoleMenu 
* @Description: 不同用户角色菜单
* @author tbnb1.cn
* @date 2017年1月16日 下午2:23:10 
*
 */
@Entity
@Table(name="t_rolemenu")
public class RoleMenu {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;

	    /** 角色Id */
	    private Integer rid;

	    /** 菜单Id */
	    private Integer mid;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getRid() {
			return rid;
		}

		public void setRid(Integer rid) {
			this.rid = rid;
		}

		public Integer getMid() {
			return mid;
		}

		public void setMid(Integer mid) {
			this.mid = mid;
		}
	    
	    
	    
	    
	    
	    

}
