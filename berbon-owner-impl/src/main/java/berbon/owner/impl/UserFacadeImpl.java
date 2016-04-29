package berbon.owner.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import berbon.owner.facade.UserFacade;
@Service
public class UserFacadeImpl implements UserFacade{

	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	
	Logger logger = LoggerFactory.getLogger(UserFacadeImpl.class);
	public String getUserInfo() {
		stringRedisTemplate.opsForValue().set("abc", "你好");
		logger.info("----------------"+stringRedisTemplate.opsForValue().get("abc"));
		// TODO Auto-generated method stub
		return "你好.................................";
	}

}
