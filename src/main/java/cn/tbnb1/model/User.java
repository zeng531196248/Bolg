package cn.tbnb1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * 
* @ClassName: User 
* @Description: 用户
* @author tbnb1.cn
* @date 2017年1月11日 下午3:19:16 
*
 */
@Entity
@Table(name="t_user")
public class User {

	   	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
	   	@Column(unique=true,nullable=false)//不能为空且唯一
	    private String username;
	    private String password;
	    private Integer status;//0删除的用户，1.正常用户
	    @Column(name="create_date")
	    private Date createdate;
	    /** 用户昵称 */
	    private String nickname;
	    /**
	     * 是否是管理员
	     */
	    @Column(name="is_admin")
	    private Integer isAdmin;
	    
	    private Date updateTime;
	    /**头像**/
	    private String touImage;
	    /**签名**/
	    private String sign;
	    /**邮箱**/
	    private String mail;
	    
	    /**盐**/
	    private String salt="tbnb1.cn";
	    
	    
		

		public String getSalt() {
			return salt;
		}

		public void setSalt(String salt) {
			this.salt = salt;
		}

		public String getTouImage() {
			return touImage;
		}

		public void setTouImage(String touImage) {
			this.touImage = touImage;
		}

		public String getSign() {
			return sign;
		}

		public void setSign(String sign) {
			this.sign = sign;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Date getCreatedate() {
			return createdate;
		}

		public void setCreatedate(Date createdate) {
			this.createdate = createdate;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public Integer getIsAdmin() {
			return isAdmin;
		}

		public void setIsAdmin(Integer isAdmin) {
			this.isAdmin = isAdmin;
		}

		public Date getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}
	    
	    
	    
	    
	
}
