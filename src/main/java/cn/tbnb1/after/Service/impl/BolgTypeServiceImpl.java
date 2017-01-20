package cn.tbnb1.after.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tbnb1.after.Dao.BolgTypeDao;
import cn.tbnb1.after.Service.BolgTypeService;
import cn.tbnb1.model.BolgType;
@Service
public class BolgTypeServiceImpl implements BolgTypeService{

	@Autowired
	BolgTypeDao bolgTypeDao;
	@Override
	public List<BolgType> findBolgTypeByUid(Integer uid) {
	
		return bolgTypeDao.findBolgTypeByUid(uid);
	}

}
