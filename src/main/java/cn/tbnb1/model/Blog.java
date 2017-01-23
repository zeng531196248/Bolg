package cn.tbnb1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import java.util.Date;


@Entity
@Table(name="t_blog")
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 
	
	private String title;//博客标题
	
	private  String  author;//作者
	@Lob
	private String content;//内容
	
	private Integer bolgType;//博客类型
	
	private Integer uid;//博客属于谁
	
	private Date updateTime;//博客更新时间
	
	private Date creatTime;//创建时间
	
	/**
	 * 是否显示：0不显示，1显示;逻辑删除
	 */
	
	private String isDisplay="1";
	
	@Lob
	private String zhaiyao;//摘要

	
	
	private String privacy;//是不是私密的
	
	private  String recommend;//是不是推荐的
	
	
	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getZhaiyao() {
		return zhaiyao;
	}

	public void setZhaiyao(String zhaiyao) {
		this.zhaiyao = zhaiyao;
	}

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getBolgType() {
		return bolgType;
	}

	public void setBolgType(Integer bolgType) {
		this.bolgType = bolgType;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
	}
	
	//摘要
	
	
	
	
}
