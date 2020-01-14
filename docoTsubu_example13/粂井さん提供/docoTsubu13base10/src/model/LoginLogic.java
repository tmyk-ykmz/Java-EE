package model;

public class LoginLogic {
	// 認証確認メソッド
	public boolean execute(User user) {
		if(user.getPass().equals("1234")) {
			return true;
		}
		return false;
	}

}
