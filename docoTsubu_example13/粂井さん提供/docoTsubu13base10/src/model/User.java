package model;

import java.io.Serializable;

public class User implements Serializable {
	// フィールド
	private String name;	// ユーザー名
	private String pass;	// パスワード

	// コンストラクタ
	public User() {}
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	// アクセサメソッド
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
