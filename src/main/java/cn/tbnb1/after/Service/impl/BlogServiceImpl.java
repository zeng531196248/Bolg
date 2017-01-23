package cn.tbnb1.after.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import cn.tbnb1.after.Dao.BolgDao;
import cn.tbnb1.after.Service.BlogService;
import cn.tbnb1.model.Blog;
@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	@Autowired
	BolgDao bolgdao;
	@Override
	public Integer save(Blog blog) {
		blog.setId(null);
		blog.setUpdateTime(new Date());
		blog.setCreatTime(blog.getUpdateTime());
	Blog res = bolgdao.save(blog);
	System.out.println(res);
		return 1;
	}

}
