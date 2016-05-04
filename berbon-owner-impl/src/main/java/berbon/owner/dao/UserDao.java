package berbon.owner.dao;

import java.util.List;

import berbon.owner.pojo.User;

public interface UserDao {
	
	 
	  
    public abstract void _test();  
  
    public abstract void createCollection();  
  
    public abstract List<User> findList(int skip, int limit);  
  
    public abstract List<User> findListByAge(int age);  
  
    public abstract User findOne(String id);  
  
    public abstract User findOneByUsername(String username);  
  
    public abstract void insert(User entity);  
  
    public abstract void update(User entity);  

}
