package model;

import java.util.List;

import dao.MutterDAO;

public class GetMutterListLogic {
//データベースに保存してあった会話の履歴を呼び出す。
    public List<Mutter> execute() {
        //データベースに保存してあった会話履歴を呼び出すためのメゾッド。
        MutterDAO dao = new MutterDAO();
        List<Mutter> mutterList = dao.findAll();
        return mutterList;
    }
}
