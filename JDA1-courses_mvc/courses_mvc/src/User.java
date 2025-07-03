import java.io.Serializable;

public class User implements Serializable {
	int user_id;
	private String email;
	private String password;
	
	public User() {
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User(int user_id, String email, String password) {
		this.user_id = user_id;
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	}
	public String getPassword() {		return password;	}
	public void setPassword(String password) {		this.password = password;	}
	
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "User ID: " + user_id + "\tE-mail: " + email + "\tpassword: " + password;
	}
}