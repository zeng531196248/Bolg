package cn.tbnb1.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
* @ClassName: Navs 
* @Description: 侧导航
* @author tbnb1.cn
* @date 2017年1月18日 下午2:55:11 
*
 */

@Table(name="t_navs")
@Entity
public class Navs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String title;
	
	private String icon;
	
	private boolean spread;//是否展开，true是展开菜单，false是不展开
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY ,mappedBy="navs")
	private List<Children> childrens;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean isSpread() {
		return spread;
	}
	public void setSpread(boolean spread) {
		this.spread = spread;
	}
	public List<Children> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<Children> childrens) {
		this.childrens = childrens;
	}
	

	
	
	
	
	
	
	
	
}
