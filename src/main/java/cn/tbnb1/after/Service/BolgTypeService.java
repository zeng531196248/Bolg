package cn.tbnb1.after.Service;

import java.util.List;

import cn.tbnb1.model.BolgType;

public interface BolgTypeService {
	public List<BolgType> findBolgTypeByUid(Integer uid);

	public int deletByIdAndUid(Integer uid, Integer id2);

	public BolgType save(BolgType bolgType);

	public BolgType findBolgTypeByUidAndId(Integer id, Integer id2);

	public void updatetype(BolgType bolgType);
		
	
}
