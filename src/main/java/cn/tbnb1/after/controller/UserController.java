package cn.tbnb1.after.controller;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;  

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.util.SystemInfo;
import cn.tbnb1.after.Service.BolgTypeService;
import cn.tbnb1.after.Service.UserService;
import cn.tbnb1.model.BolgType;
import cn.tbnb1.model.User;
import cn.tbnb1.tools.ConfigTools;

@Controller
public class UserController {

	private static final ObjectMapper objectMapper = new ObjectMapper();  
	
	@Autowired
	UserService uservice;
	@Autowired
	BolgTypeService bolgTypeService;
	@Autowired
	ConfigTools configtools;
	@GetMapping("backstage/wblog")
	public String wblog(Model model){
		Integer uid=1;//TODO这里还没完善
		List<BolgType> resBolgType = bolgTypeService.findBolgTypeByUid(uid);
		model.addAttribute("ListBolgType", resBolgType);
		return "Html/Blohg/wblog";
	}
	
	@GetMapping("backstage/main")
	public String toPage(Model model,HttpServletRequest request) {
		   String ServerName= request.getServerName();//获取服务器地址
		   int ServerPort=request.getServerPort();//服务的端口
		   String remoteHost = request.getRemoteHost();//客户端主机名
		   String host=request.getRemoteHost();//主机名
		   String header=request.getHeader("user-agent");//浏览器基本信息
		   String propertyname=request.getHeader("os.name");//客户端系统名称
		   String propertyversion=request.getHeader("os.version");//客户端系统版本
		   String propertyarch=request.getHeader("os.arch");//客户端操作系统位数
		   String protocol=request.getProtocol();//HTTP协议版本
		   String ecoding=request.getCharacterEncoding();//请求编码格式
		   String accept=request.getCharacterEncoding();//Accept
		   String acceptLanguage=request.getHeader("Accept-Language");//Accept-语言
		   String acceptEncoding=request.getHeader("Accept-Encoding");//Accept-编码
		   String connection=request.getHeader("Connection");//Connection
		   String cookie=request.getHeader("Cookie");//cookie
		   String requestUrl=request.getRequestURI();//请求行中的资源名部分
		   String localName=request.getLocalName();//WEB服务器的主机名
		   int remotePort=request.getRemotePort();//客户机所使用的网络端口号
		   String method=request.getMethod();//客户机请求方式
		   cn.tbnb1.viewModel.SystemInfo	systemInfo=new cn.tbnb1.viewModel.SystemInfo(ServerName, ServerPort, remoteHost, host, header, propertyname, propertyversion, propertyarch, protocol, ecoding, accept, acceptLanguage, acceptEncoding, connection, cookie, requestUrl, localName, remotePort, method);
		model.addAttribute("systemInfo", systemInfo);
		return "Html/Blohg/main";
		
	}
	

	
	@RequestMapping("backstage/loginpage")
	public String loginPage(Model model) {
		return "admin/login";
	}
	/**
	 * 
	* @Title: loginUser 
	* @Description: 登录
	* @param @param model
	* @param @param user
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@PostMapping("backstage/login")
	public  String loginUser(Model model, User user,
			HttpServletRequest request) {
		if (user == null) {
			return "false";
		}
		String Msg = null;
		User u = uservice.findByUsername(user.getUsername());
		if (u == null) {
			Msg = "当前用户不存在";
			return "false";
		}
		try {
			if (!Md5Crypt.apr1Crypt(user.getPassword(),user.getSalt()).equals(u.getPassword())) {
				Msg = "账号或者密码错误";
				return "false";
			}
		} catch (Exception e) {
			Msg = "服务器繁忙，请稍后再试！";
			return "false";
		}
		request.getSession().setAttribute("loginUser", u);
		return "redirect:/backstage/admin";

	}

	
	
	/**
	 * 
	* @Title: toIndex 
	* @Description:后台主页 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@GetMapping("backstage/admin")
	public String toIndex(Model model){
		//TODO 需要 从redis中取一次数据，判断该用户有没有存在不存在就直接回到login
		
		return "Html/Blohg/index";
		
	}
	
	
	/**
	 * 
	* @Title: fileUpload 
	* @Description: 上传图片
	* @param @param request
	* @param @param response
	* @param @param file
	* @param @return
	* @param @throws ServletException
	* @param @throws IOException
	* @param @throws FileUploadException    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	@SuppressWarnings("all")
	 @RequestMapping(value = "backstage/admin/kindeditor/file-upload.do", method = RequestMethod.POST)  
	    @ResponseBody  
	    public Map<String, Object> fileUpload(HttpServletRequest request,  
	            HttpServletResponse response,@RequestParam("imgFile")MultipartFile file) throws ServletException, IOException,  
	            FileUploadException {  
	        ServletContext application = request.getSession().getServletContext();  
	        String savePathTemp = application.getRealPath("/") + "attached/";  
	        String   savePath= savePathTemp.replaceFirst("webapp", "resources\\static");
	//		String savePath=configtools.getUploadPath();
	        // 文件保存目录URL  
	        String saveUrl = request.getContextPath() + "/attached/";  
	       
	        // 定义允许上传的文件扩展名  
	        HashMap<String, String> extMap = new HashMap<String, String>();  
	        extMap.put("image", "gif,jpg,jpeg,png,bmp");  
	        extMap.put("flash", "swf,flv");  
	        extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");  
	        extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");  
	  
	        // 最大文件大小  
	        long maxSize = 10485860;  
	  
	        response.setContentType("text/html; charset=UTF-8");  
	  
	        if (!ServletFileUpload.isMultipartContent(request)) {  
	            return getError("请选择文件。");  
	            
	        }  
	        System.out.println(savePath);
	        // 检查目录  
	        File uploadDir = new File(savePath);  
	        if (!uploadDir.isDirectory()) {  
//	            return getError("上传目录不存在。");  
	        	System.out.println("上传目录不存在,将要创建新目录");
	           	uploadDir.mkdirs(); 
	        } 
	        // 检查目录写权限  
	        if (!uploadDir.canWrite()) {  
	            return getError("上传目录没有写权限。");  
	        }  
	  
	        String dirName = request.getParameter("dir");  
	        if (dirName == null) {  
	            dirName = "image";  
	        }  
	        if (!extMap.containsKey(dirName)) {  
	            return getError("目录名不正确。");  
	        }  
	        // 创建文件夹  
	        savePath += dirName + "/";  
	        saveUrl += dirName + "/";  
	        File saveDirFile = new File(savePath);  
	        if (!saveDirFile.exists()) {  
	            saveDirFile.mkdirs();  
	        }  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
	        String ymd = sdf.format(new Date());  
	        savePath += ymd + "/";  
	        saveUrl += ymd + "/";  
	        File dirFile = new File(savePath);  
	        if (!dirFile.exists()) {  
	            dirFile.mkdirs();  
	        }  
	  
	        FileItemFactory factory = new DiskFileItemFactory();  
	        ServletFileUpload upload = new ServletFileUpload(factory);  
	        upload.setHeaderEncoding("UTF-8");  
	        List items = upload.parseRequest(request);  
			Iterator itr = items.iterator();  
	       
//	            FileItem item = (FileItem) itr.next();  
	            String fileName = file.getOriginalFilename();  
	            if (true) {  
	                // 检查文件大小  
	                if (file.getSize() > maxSize) {  
	                	System.out.println(file.getSize());
	                    return getError("上传文件大小超过限制。");  
	                }  
	                // 检查扩展名  
	                String fileExt = fileName.substring(  
	                        fileName.lastIndexOf(".") + 1).toLowerCase();  
	                if (!Arrays.<String> asList(extMap.get(dirName).split(","))  
	                        .contains(fileExt)) {  
	                    return getError("上传文件扩展名是不允许的扩展名。\n只允许"  
	                            + extMap.get(dirName) + "格式。");  
	                }  
	  
	                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
	                String newFileName = df.format(new Date()) + "_"  
	                        + new Random().nextInt(1000) + "." + fileExt;  
	                try {  
	                	System.out.println("savePath:"+savePath);
	                	System.out.println("newFileName:"+newFileName);
	                    File uploadedFile = new File(savePath, newFileName);  
	                    File saveFile = new File(savePath+newFileName);  
	                    	file.transferTo(saveFile);
	                    	createThumbnail(savePath, newFileName); 
	                } catch (Exception e) {  
	                	e.printStackTrace();
	                    return getError("上传文件失败。");  
	                }  
	                Map<String, Object> msg = new HashMap<String, Object>();  
	                msg.put("error", 0);  
	                msg.put("url", saveUrl + newFileName);  
	                return msg;  
	            }  
	        return null;  
	    }
		
		/**
		 * @param savePath
		 * @param newFileName
		 */
		private void createThumbnail(String savePath, String newFileName) {
			try {
				Thumbnails.of(savePath+newFileName)   
				.size(200,200)  
				.toFile(savePath+"thump"+newFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}  
	  
	    private Map<String, Object> getError(String message) {  
	        Map<String, Object> msg = new HashMap<String, Object>();  
	        msg.put("error", 1);  
	        msg.put("message", message);  
	        return msg;  
	    }  
	  
	    @RequestMapping(value = "backstage/admin/kindeditor/file-manager.do")  
	    public void fileManager(HttpServletRequest request,  
	            HttpServletResponse response) throws ServletException, IOException {  
	        ServletContext application = request.getSession().getServletContext();  
	        ServletOutputStream out = response.getOutputStream();  
	        // 根目录路径，可以指定绝对路径，比如 /var/www/attached/  
	        String rootPath = application.getRealPath("/") + "attached/";  
	        // 根目录URL，可以指定绝对路径，比如 http://www.yoursite.com/attached/  
	        
	        String rootUrl = request.getContextPath() + "/attached/";  

	        // 图片扩展名  
	        String[] fileTypes = new String[] { "gif", "jpg", "jpeg", "png", "bmp" };  
	  
	        String dirName = request.getParameter("dir");  
	        if (dirName != null) {  
	            if (!Arrays.<String> asList(  
	                    new String[] { "image", "flash", "media", "file" })  
	                    .contains(dirName)) {  
	                out.println("Invalid Directory name.");  
	                return;  
	            }  
	            rootPath += dirName + "/";  
	            rootUrl += dirName + "/";  
	            File saveDirFile = new File(rootPath);  
	            if (!saveDirFile.exists()) {  
	                saveDirFile.mkdirs();  
	            }  
	        }  
	        // 根据path参数，设置各路径和URL  
	        String path = request.getParameter("path") != null ? request  
	                .getParameter("path") : "";  
	        String currentPath = rootPath + path;  
	        String currentUrl = rootUrl + path;  
	        String currentDirPath = path;  
	        String moveupDirPath = "";  
	        if (!"".equals(path)) {  
	            String str = currentDirPath.substring(0,  
	                    currentDirPath.length() - 1);  
	            moveupDirPath = str.lastIndexOf("/") >= 0 ? str.substring(0,  
	                    str.lastIndexOf("/") + 1) : "";  
	        }  
	  
	        // 排序形式，name or size or type  
	        String order = request.getParameter("order") != null ? request  
	                .getParameter("order").toLowerCase() : "name";  
	  
	        // 不允许使用..移动到上一级目录  
	        if (path.indexOf("..") >= 0) {  
	            out.println("Access is not allowed.");  
	            return;  
	        }  
	        // 最后一个字符不是/  
	        if (!"".equals(path) && !path.endsWith("/")) {  
	            out.println("Parameter is not valid.");  
	            return;  
	        }  
	        // 目录不存在或不是目录  
	        File currentPathFile = new File(currentPath);  
	        if (!currentPathFile.isDirectory()) {  
	            out.println("Directory does not exist.");  
	            return;  
	        }  
	        // 遍历目录取的文件信息  
	        List<Hashtable> fileList = new ArrayList<Hashtable>();  
	        if (currentPathFile.listFiles() != null) {  
	            for (File file : currentPathFile.listFiles()) {  
	                Hashtable<String, Object> hash = new Hashtable<String, Object>();  
	                String fileName = file.getName();  
	                if (file.isDirectory()) {  
	                    hash.put("is_dir", true);  
	                    hash.put("has_file", (file.listFiles() != null));  
	                    hash.put("filesize", 0L);  
	                    hash.put("is_photo", false);  
	                    hash.put("filetype", "");  
	                } else if (file.isFile()) {  
	                    String fileExt = fileName.substring(  
	                            fileName.lastIndexOf(".") + 1).toLowerCase();  
	                    hash.put("is_dir", false);  
	                    hash.put("has_file", false);  
	                    hash.put("filesize", file.length());  
	                    hash.put("is_photo", Arrays.<String> asList(fileTypes)  
	                            .contains(fileExt));  
	                    hash.put("filetype", fileExt);  
	                }  
	                hash.put("filename", fileName);  
	                hash.put("datetime",  
	                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file  
	                                .lastModified()));  
	                fileList.add(hash);  
	            }  
	        }  
	  
	        if ("size".equals(order)) {  
	            Collections.sort(fileList, new SizeComparator());  
	        } else if ("type".equals(order)) {  
	            Collections.sort(fileList, new TypeComparator());  
	        } else {  
	            Collections.sort(fileList, new NameComparator());  
	        }  
	        Map<String, Object> msg = new HashMap<String, Object>();  
	        msg.put("moveup_dir_path", moveupDirPath);  
	        msg.put("current_dir_path", currentDirPath);  
	        msg.put("current_url", currentUrl);  
	        msg.put("total_count", fileList.size());  
	        msg.put("file_list", fileList);  
	        response.setContentType("application/json; charset=UTF-8");  
	        String msgStr = objectMapper.writeValueAsString(msg);
	        out.println(msgStr);  
	    }  
	  
	    class NameComparator implements Comparator {  
	        public int compare(Object a, Object b) {  
	            Hashtable hashA = (Hashtable) a;  
	            Hashtable hashB = (Hashtable) b;  
	            if (((Boolean) hashA.get("is_dir"))  
	                    && !((Boolean) hashB.get("is_dir"))) {  
	                return -1;  
	            } else if (!((Boolean) hashA.get("is_dir"))  
	                    && ((Boolean) hashB.get("is_dir"))) {  
	                return 1;  
	            } else {  
	                return ((String) hashA.get("filename"))  
	                        .compareTo((String) hashB.get("filename"));  
	            }  
	        }  
	    }  
	  
	    class SizeComparator implements Comparator {  
	        public int compare(Object a, Object b) {  
	            Hashtable hashA = (Hashtable) a;  
	            Hashtable hashB = (Hashtable) b;  
	            if (((Boolean) hashA.get("is_dir"))  
	                    && !((Boolean) hashB.get("is_dir"))) {  
	                return -1;  
	            } else if (!((Boolean) hashA.get("is_dir"))  
	                    && ((Boolean) hashB.get("is_dir"))) {  
	                return 1;  
	            } else {  
	                if (((Long) hashA.get("filesize")) > ((Long) hashB  
	                        .get("filesize"))) {  
	                    return 1;  
	                } else if (((Long) hashA.get("filesize")) < ((Long) hashB  
	                        .get("filesize"))) {  
	                    return -1;  
	                } else {  
	                    return 0;  
	                }  
	            }  
	        }  
	    }  
	  
	    class TypeComparator implements Comparator {  
	        public int compare(Object a, Object b) {  
	            Hashtable hashA = (Hashtable) a;  
	            Hashtable hashB = (Hashtable) b;  
	            if (((Boolean) hashA.get("is_dir"))  
	                    && !((Boolean) hashB.get("is_dir"))) {  
	                return -1;  
	            } else if (!((Boolean) hashA.get("is_dir"))  
	                    && ((Boolean) hashB.get("is_dir"))) {  
	                return 1;  
	            } else {  
	                return ((String) hashA.get("filetype"))  
	                        .compareTo((String) hashB.get("filetype"));  
	            }  
	        }  
	    }  
}
