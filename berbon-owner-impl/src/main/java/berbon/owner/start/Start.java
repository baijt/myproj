package berbon.owner.start;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
	
	
	
	public static void main(String[] args) throws IOException {
		Logger logger = Logger.getLogger("13415");
		logger.setLevel(Level.INFO);
		logger.info("........................");
		System.setProperty("dubbo.application.logger","slf4j");  
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/*.xml");
		context.start();
		System.in.read();

	}

}
