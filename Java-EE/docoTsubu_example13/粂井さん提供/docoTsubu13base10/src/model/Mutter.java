package model;

import java.io.Serializable;

public class Mutter implements Serializable {
	// フィールド
	private int id;			// id：追加
	private String userName;	// ユーザー名
	private String text;		// つぶやき内容

	// コンストラクタ
	public Mutter() {}
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
// ↓ 追加
	public Mutter(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}

	// アクセサメソッド
	// 追加
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	// ↑ここまで↑
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
