package cn.tbnb1.model;

import java.util.Date;
import java.util.List;


/**
 * 
 * @ClassName: AuthToken
 * @Description:封装登录的用户数据到缓存中（包含权限）
 * @author tbnb1.cn
 * @date 2017年1月17日 上午11:00:37
 *
 */
public class AuthToken {
	// 登录的用户
	private User user;
	//用户的权限菜单
	private List<MenuDto> authMenu;
	// 用户权限范围内的sn列表
	private List<String> authList;
	// 登录时间
	private Date login_time;
	// 登录的Ip
	private String login_ip;
	// 浏览器
	private String userBrowser;
	// 操作系统名
	private String system;
	//登录地方
	private String site;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<MenuDto> getAuthMenu() {
		return authMenu;
	}
	public void setAuthMenu(List<MenuDto> authMenu) {
		this.authMenu = authMenu;
	}
	public List<String> getAuthList() {
		return authList;
	}
	public void setAuthList(List<String> authList) {
		this.authList = authList;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	public String getUserBrowser() {
		return userBrowser;
	}
	public void setUserBrowser(String userBrowser) {
		this.userBrowser = userBrowser;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	} 
}
