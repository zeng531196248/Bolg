package cn.tbnb1.after.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tbnb1.after.Dao.BolgTypeDao;
import cn.tbnb1.after.Service.BolgTypeService;
import cn.tbnb1.model.BolgType;
@Service
@Transactional
public class BolgTypeServiceImpl implements BolgTypeService{

	@Autowired
	BolgTypeDao bolgTypeDao;
	@Override
	public List<BolgType> findBolgTypeByUid(Integer uid) {
	
		return bolgTypeDao.findBolgTypeByUid(uid);
	}
	
	@Override
	public int deletByIdAndUid(Integer uid, Integer id) {
		return bolgTypeDao.deletByIdAndUid(uid,id);
	}

	@Override
	public BolgType save(BolgType bolgType) {
	
		return bolgTypeDao.save(bolgType);
	}

	@Override
	public BolgType findBolgTypeByUidAndId(Integer uid, Integer id) {
		return bolgTypeDao.findBolgTypeByUidAndId(uid,id);
	}

	@Override
	public void updatetype(BolgType bolgType) {
		BolgType resbolgType=bolgTypeDao.findBolgTypeByUidAndId(bolgType.getUid(),bolgType.getId());
		resbolgType.setType(bolgType.getType());
		resbolgType.setUpdateTime(bolgType.getUpdateTime());
	}

}
