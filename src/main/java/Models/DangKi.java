package Models;

public class DangKi {
	private String userName, email, passWord, salt;
	
	public void DangKi() {
		
	}

	public DangKi(String userName, String email, String passWord, String salt) {
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
		this.salt = salt;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "DangKi [userName=" + userName + ", email=" + email + ", passWord=" + passWord + ", salt=" + salt + "]";
	}

}
