package model;

import java.io.Serializable;

public class Mutter implements Serializable{

	// フィールド
	private int id;			// ID
	private String userName;	// ユーザー名
	private String text;		// 内容


	// コンストラクタ
	public Mutter() {}

	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}

	public Mutter(int id,String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}

	// getter
	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getText() {
		return text;
	}

	// setter
/*	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setMutter(String mutter) {
		this.mutter = mutter;
	}
*/
}
