/* JavaBeansの作成
 * 1、直列化可能である（java.io.Serializableインターフェースを実装する）
 * 2、package宣言し、クラスはpublicで修飾する
 * 3、publicで引数のないコンストラクタを持つ
 * 4、フィールドはカプセル化する
 * 5、命令規則に従ったgetter/setterを持つ
 */

package model;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String id;
	private String pass;

	// 引数なしコンストラクタ
	public User() {
	}

	public User(String name, String id, String pass) {
		this.name = name;
		this.id = id;
		this.pass = pass;
	}

	// getter/setter
	// 基本的にgetterを使う場合が多い
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

}
