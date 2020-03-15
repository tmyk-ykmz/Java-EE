package model;

import dao.MutterDAO;
//import java.util.List;

public class PostMutterLogic {
	/* メソッド
	public void execute(Mutter mutter, List<Mutter> mutterList) {
		mutterList.add(0, mutter);			// 先頭に追加
	}
	↓ */

	public void execute(Mutter mutter) {	// 引数を1つに変更
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
	}
}
