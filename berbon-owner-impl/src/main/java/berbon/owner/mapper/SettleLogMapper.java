package berbon.owner.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import berbon.owner.pojo.SettleLog;

public interface SettleLogMapper {
	List<SettleLog> getSettleLogs(@Param("startTime")String startTime,@Param("endTime")String endTime);
	int insertSelective(SettleLog shoppingCardOrder);
	
	

}
