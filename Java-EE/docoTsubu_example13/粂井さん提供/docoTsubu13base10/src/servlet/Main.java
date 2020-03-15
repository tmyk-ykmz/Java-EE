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
			HttpServletResponse response)
					throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		/* つぶやきリストをアプリケーションスコープから取得
		ServletContext application = this.getServletContext();
		@SuppressWarnings("unchecked")	 // 参照（p.472）
		List<Mutter> mutterList =
			(List<Mutter>) application.getAttribute("mutterList");

		// 取得できなかった場合は、つぶやきリストを新規作成して
		// アプリケーションスコープに保存
		if(mutterList == null) {
			mutterList = new ArrayList<Mutter>();
			application.setAttribute("mutterList", mutterList);
		}
		↓ 追記（p.404） */
		// つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);

		// ログインしているか確認するため
		// セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		// ログインしていない場合
		if(loginUser == null) {
			// リダイレクト
			response.sendRedirect("/docoTsubu13base10/");
		} else {
			// ログイン済みの場合は、フォワード
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		// 追記（p.298）
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		// 入力値チェック
		if(text != null && text.length() != 0) {
			/* アプリケーションスコープに保存されたつぶやきリストを取得
			ServletContext application = this.getServletContext();
			@SuppressWarnings("unchecked")	// 参照（p.472）
			List<Mutter> mutterList =
					(List<Mutter>) application.getAttribute("mutterList");
			*/

		// セッションスコープに保存されたユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		// つぶやきをつぶやきリストに追加
		Mutter mutter = new Mutter(loginUser.getName(), text);
		PostMutterLogic postMutterLogic = new PostMutterLogic();
//		postMutterLogic.execute(mutter, mutterList);
		postMutterLogic.execute(mutter);	// 引数1つでメソッドの呼び出し

		/* アプリケーションスコープにつぶやきリストを保存
		application.setAttribute("mutterList", mutterList);
		*/
		}
		// 追記（p.303）
		else {
			// エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg",
					"つぶやきが入力されていません");
		}
		// ---（ここまで）---

		// 追記（p.405）つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);

		// メイン画面にフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
