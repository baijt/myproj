package berbon.owner.pojo;

public class NameEntity {
	
	  
    private String username;  
  
    private String nickname;  
    
    
  
    public NameEntity() {
		super();
	}

	public NameEntity(String username, String nickname) {
		super();
		this.username = username;
		this.nickname = nickname;
	}

	public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getNickname() {  
        return nickname;  
    }  
  
    public void setNickname(String nickname) {  
        this.nickname = nickname;  
    }  

}
