package cn.tbnb1.after.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.tbnb1.model.BolgType;

public interface BolgTypeDao extends JpaRepository<BolgType, Integer> {

	@Modifying
	@Query("update BolgType b set b.isDisplay = '1' where b.uid = ?1 and b.id=?2") 
	int deletByIdAndUid(Integer uid, Integer id);
	@Modifying
	@Query("select b from BolgType b where b.uid = ?1 and b.isDisplay = '0'") 
	List<BolgType> findBolgTypeByUid(Integer uid);
	
	
	@Query("select b from BolgType b where b.uid = ?1 and b.id=?2 and b.isDisplay = '0'")
	BolgType findBolgTypeByUidAndId(Integer uid, Integer id);


}
