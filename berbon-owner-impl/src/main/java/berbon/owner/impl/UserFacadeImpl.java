package berbon.owner.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import berbon.owner.facade.UserFacade;
import berbon.owner.pojo.NameEntity;
import berbon.owner.pojo.User;
@Service
public class UserFacadeImpl implements UserFacade{

	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	@Autowired
	private MqProducer mqProducer;
	
	
	Logger logger = LoggerFactory.getLogger(UserFacadeImpl.class);
	public String getUserInfo() {
		
		
		mqProducer.sendDataToQueue("test_queue", "hello,rabbmitmq!");
		stringRedisTemplate.opsForValue().set("abc", "你好");
		logger.info("----------------"+stringRedisTemplate.opsForValue().get("abc"));
		// TODO Auto-generated method stub
		
		User entity = new User();
		entity.setAge(12);
//		entity.setId(System.currentTimeMillis()+"");
		entity.setName(new NameEntity("caihj", "wawa"));
		entity.setPassword("1234564651");
		entity.setWorks(1);
		entity.setBirth(new Date());
		entity.setRegionName("hahha");
		userDaoImpl.insert(entity);
		userDaoImpl._test();
		User user =userDaoImpl.findOne("5729bc707a5c1c29c00b42c3");
		
		System.err.println("???????????????????????????"+user.toString());
		return "你好.................................";
	}

}
