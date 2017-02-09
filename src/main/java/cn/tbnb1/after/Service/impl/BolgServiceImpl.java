package cn.tbnb1.after.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tbnb1.after.Dao.BolgDao;
import cn.tbnb1.after.Service.BolgService;
import cn.tbnb1.model.Blog;
@Service
@Transactional
public class BolgServiceImpl implements BolgService {
	@Autowired
	private BolgDao bolgdao;
	@Override
	public List<Blog> findBlogByUid(Integer uid) {
		return bolgdao.findBlogByUid(uid);
	}
	@Override
	public void deletBolg(Integer id, Integer uid) {
		bolgdao.deleteBlogByIdAndUid(id,uid);
	}
	@Override
	public void updata(Integer uid, Integer id,String state) {
		bolgdao.updata(uid,id,state);
		
	}

}
