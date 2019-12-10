package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Human;

/**
 * Servlet implementation class code09_01
 */
@WebServlet("/code09_01")
public class code09_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		//		super.doGet(req, resp);

		// アプリケーションスコープに保存するインスタンスの生成
		Human human = new Human("湊　雄輔", 23);

		// ServletContextインスタンスの取得
		ServletContext application = this.getServletContext();

		// アプリケーションスコープにインスタンスを保存
		application.setAttribute("human", human);

		// アプリケーションスコープからインスタンスを取得
		Human h = (Human) application.getAttribute("human");

		// アプリケーションスコープからインスタンスを削除
		//		application.removeAttribute("human");

		// フォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/code09_02.jsp");
		dispatcher.forward(req, resp);
	}

}
