package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        System.out.println("MainクラスのdoGetメゾッドを実行しました。");
        //過去のつぶやいた内容を取得する。取得するためのSQLコマンドはGetMuttterListLogicを経由してMutterDAOに記述されている。
        //MutterDAOにはSQLとやり取りする（取得・保存）ためのコマンド。
        //にはSQLとやり取りするためのコマンドの内容を直接記述せずに
        //MutterDAOの中にあるSQLの処理内容がかかれたメゾッドのインスタンスを生成させるために
        //
        //MutterDAOにはデータベースとやり取りするためのSQLの実行コマンドを
        //GetMutterListLogicクラスには
        // つぶやきリストを取得して、リクエストスコープに保存する。
        GetMutterListLogic getMutterListLogic =
                new GetMutterListLogic();
        
        List<Mutter> mutterList = getMutterListLogic.execute();
        request.setAttribute("mutterList", mutterList);
System.out.println("リクエストスコープに保存しました");


        // ログインしているか確認するため
        // セッションスコープからユーザー情報を取得
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
System.out.println("セッションスコープからユーザー情報を取得しました。");

        if(loginUser == null) { // ログインしていない場合
            // リダイレクト
            response.sendRedirect("/DocoTsubu13/index.jsp");

        } else { // ログイン済みの場合
            // フォワード
            RequestDispatcher disp =
                    request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            disp.forward(request, response);
        }
    }
    /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // doGet(request, response);
        System.out.println("MainクラスのdoPostメゾッドを実行しました");
        // リクエストパラメータを取得
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");

        // 入力値チェック
        if(text != null && text.length() != 0) {

            // セッションスコープに保存されたユーザー情報を取得
            HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute("loginUser");

            // つぶやきをつぶやきリストに追加
            Mutter mutter = new Mutter(loginUser.getName(),text);
            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.execute(mutter);

            // つぶやきを取得して、リクエストスコープに保存
            GetMutterListLogic getMutterListLogic =
                    new GetMutterListLogic();
            List<Mutter> mutterList = getMutterListLogic.execute();
            request.setAttribute("mutterList", mutterList);
        } else {
            // エラーメッセージをリクエストスコープに保存
            request.setAttribute("errorMsg", "つぶやきが入力されていません");
        }
        // メイン画面にフォワード
        RequestDispatcher disp =
                request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        disp.forward(request, response);
    }
}
