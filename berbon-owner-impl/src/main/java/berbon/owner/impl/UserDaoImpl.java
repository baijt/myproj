package berbon.owner.impl;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;

import berbon.owner.dao.UserDao;
import berbon.owner.pojo.User;

@Repository
public class UserDaoImpl implements UserDao{
	  public static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);  
	  
	    @Autowired  
	    private MongoTemplate mongoTemplate;  

	public void _test() {
		Set<String> colls = this.mongoTemplate.getCollectionNames();  
        for (String coll : colls) {  
            logger.info("CollectionName=" + coll);  
        }  
        DB db = this.mongoTemplate.getDb();  
        logger.info("db=" + db.toString());  
		
	}

	public void createCollection() {
		// TODO Auto-generated method stub
		
	}

	public List<User> findList(int skip, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findListByAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findOne(String id) {
		
		Query query = new Query();
        query.addCriteria(new Criteria("_id").is(id));  
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(query, User.class,"db.test");
	}

	public User findOneByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(User entity) {
		
		
		mongoTemplate.insert(entity, "db.test");
		
	}

	public void update(User entity) {
		// TODO Auto-generated method stub
		
	}

}
