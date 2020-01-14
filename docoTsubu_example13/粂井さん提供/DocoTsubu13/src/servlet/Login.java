package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
    IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());
    }






    /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
    IOException {
        // TODO Auto-generated method stub
        // doGet(request, response);
        //リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        // Userインスタンス
        User user = new User(name,pass);
        // LoginLogicインスタンス
        LoginLogic loginLogic = new LoginLogic();

        boolean isLogin = loginLogic.execute(user);


//ログインに成功するとセッションスコープに保存される
        if(isLogin) {

            // Httpsessionインスタンスの取得
            HttpSession session = request.getSession();

            // セッションスコープにインスタンスを保存
            session.setAttribute("loginUser", user);

        }
        // フォワード
                    RequestDispatcher disp =
                            request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
                    disp.forward(request, response);

    }

}
