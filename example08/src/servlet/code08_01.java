package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Human;

/**
 * Servlet implementation class code08_01
 */
@WebServlet("/code08_01")
public class code08_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
//		super.doGet(req, resp);

		// セッションスコープに保存するインスタンスの生成
		Human human = new Human();
		human.setName("湊　雄輔");
		human.setAge(23);

		// HttpSessionインスタンスの取得
		HttpSession session = req.getSession();

		// セッションスコープにインスタンスを保存
		session.setAttribute("human", human);

		// セッションスコープからインスタンスを取得
		Human h = (Human) session.getAttribute("human");

		// セッションスコープからインスタンスを削除
//		session.removeAttribute("human");

		// フォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/code08_02.jsp");
		dispatcher.forward(req, resp);
	}

}
