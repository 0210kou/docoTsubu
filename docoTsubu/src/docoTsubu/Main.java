package docoTsubu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet1(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
    protected void doGet1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


    }*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * GETリクエストのときはdogetメソッドが呼ばれ、
		 * 「単にメイン画面を表示するメソッドになっている」
		 * POSTリクエストのときはdopostメソッドが呼ばれ
		 * 「つぶやき投稿を行うためのサーブレットクラスに」
		 * 1つのサーブレットでどちらのメソッドも受付け
		 * なおかつ違う挙動をする
		 *
		 *
		 */

		//つぶやきリストをアプリケーションスコープから取得
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");

		//取得できなかった場合は、つぶやきリストを新規作成してアプリケーションスコープに保存
		if(mutterList == null){
			mutterList = new ArrayList<Mutter>();
			application.setAttribute("mutterList",mutterList);
		}

		//ログインしているか確認するためセッションスコープからユーザー情報を取得
		HttpSession session  = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		if(loginUser == null){
			//ログインしていない場合、トップ画面にリダイレクトその際、index.jspは省略
			response.sendRedirect("/docoTsubu/");

		}else { //ログイン済みの場合フォワード
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	//Postで呼び出された場合には「つぶやき投稿の処理」をするよに記述していく


		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		//入力値チェック
		//判定条件は変数textがnullではなく、なおかつ文字列の長さが0じゃないとき
		if(text != null && text.length() != 0){
			//アプリケーションスコープに保存されたつぶやきリストを取得 nnnnnn
			ServletContext application = this.getServletContext();

			List<Mutter> mutterList =
					(List<Mutter>) application.getAttribute("mutterList");

			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");

			//つぶやきをつぶやきリストに追加
			Mutter mutter = new Mutter(loginUser.getName(),text);

			PostMutterLogic postMutterLogic = new PostMutterLogic();

			postMutterLogic.execute(mutter, mutterList);


			//アプリケーションスコープにつぶやきリストを保存
			application.setAttribute("mutterList",mutterList);

		}else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg","つぶやきが入力されていません");
		}

		//メイン画面にフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request,response);

	}

}
