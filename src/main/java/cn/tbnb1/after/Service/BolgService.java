package cn.tbnb1.after.Service;

import java.util.List;

import cn.tbnb1.model.Blog;

public interface BolgService {

	List<Blog> findBlogByUid(Integer integer);

	void deletBolg(Integer integer, Integer id);

	void updata(Integer id, Integer id2, String state);

}
