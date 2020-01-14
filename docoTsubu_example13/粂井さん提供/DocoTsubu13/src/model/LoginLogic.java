package model;


public class LoginLogic {


	// ログインを判定するメソッド
	public boolean execute(User user) {

		if (user.getPass().equals("1234")) {
			return true;
		}
		return false;
	}
}
