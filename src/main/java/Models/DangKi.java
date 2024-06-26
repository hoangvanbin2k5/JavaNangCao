package Models;

public class DangKi {
	private String userName, email, passWord, confirmPW;
	
	public void DangKi() {
		
	}

	public DangKi(String userName, String email, String passWord, String confirmPW) {
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
		this.confirmPW = confirmPW;
	}
	
	

	public DangKi(String userName, String email, String passWord) {
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
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

	public String getConfirmPW() {
		return confirmPW;
	}

	public void setConfirmPW(String confirmPW) {
		this.confirmPW = confirmPW;
	}

	@Override
	public String toString() {
		return "DangKi [userName=" + userName + ", email=" + email + ", passWord=" + passWord + ", confirmPW="
				+ confirmPW + "]";
	}

}
