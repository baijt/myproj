package berbon.owner.impl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import berbon.owner.facade.UserFacade;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test.xml")
public class TestDuboo {

	@Autowired
	UserFacade userFacade;
	
	@Test
	public void test(){
		
		System.out.println(userFacade.getUserInfo());
	}
	
	
	
	
}
