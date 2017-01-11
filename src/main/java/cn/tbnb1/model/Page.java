package cn.tbnb1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
* @ClassName: Page 
* @Description: 主页大图
* @author tbnb1.cn
* @date 2017年1月11日 下午3:18:01 
*
 */
@Entity
@Table(name="t_bigpage")
public class Page {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private	Integer id;
	/**
	 * 大图地址
	 */
	private String url;
	
	/**
	 * 大图显示的顺序
	 */
	private Integer orderNo;
	/**
	 * 是否显示：0不显示，1显示
	 */
	
	private String isDisplay;
	
	/**
	 * 谁的大图
	 */
	private Integer uid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	
	
	
	
}
