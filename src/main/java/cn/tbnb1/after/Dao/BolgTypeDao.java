package cn.tbnb1.after.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.tbnb1.model.BolgType;

public interface BolgTypeDao extends JpaRepository<BolgType, Integer> {

	List<BolgType> findBolgTypeByUid(Integer uid);

}
