package cn.tbnb1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
* @ClassName: Navigation 
* @Description: 首页导航
* @author tbnb1.cn
* @date 2017年1月11日 下午3:07:25 
*
 */
@Entity
@Table(name="t_navigation")
public class Navigation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 导航名称
	 */
	private String navName;
	/**
	 * 是否显示
	 */
	private String isDisplay;
	/**
	 * 导航顺序
	 */
	private Integer orderNo;
	/**
	 * 导航连接
	 */
	private String url;
	/**
	 * 导航属于谁
	 */
	private Integer uid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNavName() {
		return navName;
	}
	public void setNavName(String navName) {
		this.navName = navName;
	}
	public String getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	
	
	
	
	
	
	
}
