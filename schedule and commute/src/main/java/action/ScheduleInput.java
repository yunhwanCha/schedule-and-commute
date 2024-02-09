package action;
//action 패키지에 속하는 클래스를 선언하기 위한 선언부

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ScheduleDatabase;
import model.Schedule;
//패키지 외부의 클래스, 패키지, 라이브러리를 사용하기 위해 import로 선언

@WebServlet("/scheduleInput.do")//서블릿을 scheduleInput.do에 매핑하는 어노테이션
public class ScheduleInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//serialVersionUID 직렬화된 객체의 버전번호로써 1L을 사용
	//버전 충돌을 방지하고 직렬화된 객체의 호환성을 보장하기 위해 사용
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTP의 GET 요청을 처리하는 메서드
		response.sendRedirect("scheduleInput.jsp");
		//HttpServletResponse의 sendRedirect("scheduleInput.jsp") scheduleInput.jsp로 리다이렉트
		//페이지를 이동시킴
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTP의 POST 요청을 처리하는 메서드
		ScheduleDatabase ScheduleDatabase = new ScheduleDatabase();
		//ScheduleDatabase클래스를 생성자를 사용하여 ScheduleDatabase라는 이름의 인스턴스 생성
		HttpSession session = request.getSession();
		//세션을 사용하기 위해 HttpServletRequest의 getSession()을 실행
		Schedule schedule = new Schedule();
		//스케쥴 클래스의 인스턴스 생성
		String id = (String)session.getAttribute("USER");
		//세션으로부터 유저 아이디 값을 불러와 id에 대입
		int schedule_id=ScheduleDatabase.GetScheduleNum();
		//ScheduleDatabase의 GetScheduleNum();를 실행시켜 반환값을 schedule_id에 대입
		String schedule_name=request.getParameter("schedule_name");
		String schedule_date=request.getParameter("schedule_date");;
		String schedule_start=request.getParameter("schedule_start");;
		String schedule_end=request.getParameter("schedule_end");;
		//HttpServletRequest의 schedule_name,schedule_date,schedule_start,schedule_end 키의
		//값들을 불러와 각각 schedule_name,schedule_date,schedule_start,schedule_end 에 대입
		
		schedule.setId(id);
		schedule.setSchedule_id(schedule_id);
		schedule.setSchedule_name(schedule_name);
		schedule.setSchedule_date(schedule_date);
		schedule.setSchedule_start(schedule_start);
		schedule.setSchedule_end(schedule_end);
		//모델.스케쥴에 id,schedule_id,schedule_name,schedule_date,schedule_start,schedule_end
		//를 입력시키는 코드
		
		System.out.println(id);
		System.out.println(schedule_id);
		System.out.println(schedule_name);
		System.out.println(schedule_date);
		System.out.println(schedule_start);
		System.out.println(schedule_end);
		
		
		ScheduleDatabase.InputSchedule(schedule);
		//ScheduleDatabase의 InputSchedule(schedule); 메서드를 실행하여
		//schedule의 값들로 새로운 데이터베이스 값을 삽입함
		
		response.sendRedirect("schedule.do");
		//클라이언트를 schedule.do 로 리다이렉트 시킴
		//스케쥴 화면으로 돌아감
	}

}
