package berbon.owner.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import berbon.owner.mapper.SettleLogMapper;
import berbon.owner.pojo.SettleLog;
@Service
public class PosMybaitsImp {
	
	@Autowired
	SettleLogMapper settleLogMapper;
	
	public List<SettleLog>  getOrder(String  starTime,String endTime){
		
	List<SettleLog>	result =settleLogMapper.getSettleLogs(starTime, endTime);
	return result;
	
	}
	public int insert(SettleLog settleLog){
		
		return settleLogMapper.insertSelective(settleLog);	
		
	}

}
