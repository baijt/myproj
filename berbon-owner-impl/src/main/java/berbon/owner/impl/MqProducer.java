package berbon.owner.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqProducer {
	
	
	
	    @Autowired
	    private AmqpTemplate amqpTemplate;

	    private  Logger logger = LoggerFactory.getLogger(MqProducer.class);
	    public void sendDataToQueue(String queueKey, Object object) {
	        try {
	            amqpTemplate.convertAndSend(queueKey, object);
	        } catch (Exception e) {
	        	logger.info("处理异常",e);
	        }

	    }

}
