package cn.tbnb1.after.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.tbnb1.model.Blog;
public interface BolgDao extends JpaRepository<Blog, Integer>{

	List<Blog> findBlogByUid(Integer uid);

	@Modifying
	@Query("delete from Blog b where b.id=?1 and b.uid=?2")
	void deleteBlogByIdAndUid(Integer id, Integer uid);

	
	@Modifying
	@Query("update Blog b set b.isDisplay=?3 where b.uid=?1 and b.id=?2 ")
	void updata(Integer uid, Integer id, String state);


	
	
	
	
	
}
