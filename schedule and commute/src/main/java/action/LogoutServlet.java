package action;
//action 패키지에 속하는 클래스를 선언하기 위한 선언부
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//패키지 외부의 클래스, 패키지, 라이브러리를 사용하기 위해 import로 선언
@WebServlet("/logout.do")//서블릿을 logout.do에 매핑하는 어노테이션
public class LogoutServlet extends HttpServlet {
	//HttpServlet을 상속받고있고 외부에서 접근 가능한 LoginServlet 클래스
	private static final long serialVersionUID = 1L;
	//serialVersionUID 직렬화된 객체의 버전번호로써 1L을 사용
	//버전 충돌을 방지하고 직렬화된 객체의 호환성을 보장하기 위해 사용

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HTTP의 GET 요청을 처리하는 메서드
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("main.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
