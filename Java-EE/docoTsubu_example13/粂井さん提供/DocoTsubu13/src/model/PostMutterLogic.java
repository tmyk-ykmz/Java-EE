package model;

import dao.MutterDAO;

public class PostMutterLogic {

    public void execute(Mutter mutter) {
        MutterDAO dao = new MutterDAO();
        dao.create(mutter);
        System.out.println("MutterDAOクラスのexecuteメゾッドを実行しました。");
    }
}
