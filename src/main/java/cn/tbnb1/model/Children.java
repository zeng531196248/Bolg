package cn.tbnb1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
* @ClassName: Children 
* @Description: 侧导航下的子导航菜单
* @author tbnb1.cn
* @date 2017年1月18日 下午2:46:00 
*
 */

@SuppressWarnings("all")
@Entity
@Table(name="t_children")
public class Children implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//导航的id
	
	private String title;//导航的标题
	
	private String icon;//图标
	
	private String href;//导航的连接
	
	private Integer uid;//导航属于谁的
	
	private String statu;//该导航是不是还在是使用
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "children_id")
	private Navs navs;

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

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}
	
	
	
	
	
}
