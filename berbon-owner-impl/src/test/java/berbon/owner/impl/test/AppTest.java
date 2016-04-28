package berbon.owner.impl.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import berbon.owner.impl.PosMybaitsImp;
import berbon.owner.pojo.SettleLog;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	
	private static Logger logger = LoggerFactory.getLogger(AppTest.class);
	private ClassPathXmlApplicationContext appContext;

	@Before
	// 在测试之前需要调用的方法，主要在测试钱启动基本的配置
	public void before() {
		logger.info("this is before method!!!");
		// 系统参数加载，如果是全部依赖Spring的情况，这里可以省略此步
		// 获得Spring上下文
	    appContext = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/*.xml");
		// 从Spring上下文中获取需要的bean
		//AppTest appTest=(AppTest) ApplicationContextUtils.getApplicationContext().getBean("appTest");
	}
	
	
	@Test
	public void testMybaits(){
		PosMybaitsImp mybaitsImp = (PosMybaitsImp) appContext.getBean("posMybaitsImp");
		System.err.println("..........................................................................................");
		List<SettleLog> list =mybaitsImp.getOrder("20141218", "20141219");
		
		System.err.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.err.println(list.get(i).toString());
		}
//		SettleLog settleLog = new SettleLog();
//		settleLog.setOrderId("5684646545");
//		settleLog.setSettleOrderId("1544653132");
//		settleLog.setInsCode("0001");
//		settleLog.setMerCode("13242578");
//		settleLog.setOrdTime("2016-4-28 11:32:00");
//		settleLog.setSettleAmount(1541L);
//		System.err.println(mybaitsImp.insert(settleLog));
		
	}
}
