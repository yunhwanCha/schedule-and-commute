package action;
//action 패키지에 속하는 클래스를 선언하기 위한 선언부
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDatabase;
//패키지 외부의 클래스, 패키지, 라이브러리를 사용하기 위해 import로 선언
@WebServlet("/login.do")//서블릿을 login.do에 매핑하는 어노테이션
public class LoginServlet extends HttpServlet {
	//HttpServlet을 상속받고있고 외부에서 접근 가능한 LoginServlet 클래스
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HTTP의 GET 요청을 처리하는 메서드
	response.sendRedirect("login.jsp");
	//login.jsp로 리다이렉트시킴
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String login="";
		UserDatabase userDatabase = new UserDatabase(); 
		String pwDB = userDatabase.getPw(id);
		if(pwDB == null) {
			login="not ok";
			response.sendRedirect("login.jsp?R="+login);
		}else {
			if(pw.equals(pwDB)) {
				HttpSession session = request.getSession();
				session.setAttribute("USER", id);
				response.sendRedirect("main.jsp");
			}else {
				login="not ok";
				response.sendRedirect("login.jsp?R="+login);
				return;
			}//else
		}//else

	}//if
	

}
