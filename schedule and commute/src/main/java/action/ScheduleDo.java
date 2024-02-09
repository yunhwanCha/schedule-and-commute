package action;
//action 패키지에 속하는 클래스를 선언하기 위한 선언부

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ScheduleDatabase;
import model.DateToday;
import model.Schedule;
//패키지 외부의 클래스, 패키지, 라이브러리를 사용하기 위해 import로 선언


@WebServlet("/schedule.do")//서블릿을 schedule.do에 매핑하는 어노테이션
public class ScheduleDo extends HttpServlet {
	//HttpServlet을 상속받고있고 외부에서 접근 가능한 ScheduleDo 클래스
	//public : 다른클래스에서도 접근 가능하게 해주는 접근 제어자
	//class 클래스를 정의함
	//extends HttpServlet에 대한 상속을 나타냄
	//HttpServlet : JAVA에서 HTTP에 대한 요청을 처리하는 기본 클래스
	private static final long serialVersionUID = 1L;
	//private 접근 제어자로, 이 변수가 선언된 클래스 내에서만 접근 가능함을 나타내는 접근 제어자
	//static 정적 변수로 클래스의 모든 인스턴스에 공유되며 객체를 생성하지 않고 클래스 이름을 통해 접근할 수 있음
	//final 상수임을 나타내며, 한 번 할당되면 변경 불가능
	//long 64비트 정수를 나타내는 데이터타입
	
	//serialVersionUID 직렬화된 클래스의 버전을 관리하기 위해 존재함
	//serialVersionUID를 사용하여 로드된 클래스가 직렬화된 개체와 정확히 일치하는지 확인
	//1L은 첫번째 버전을 의미하며 클래스의 구조가 바뀔 때 업데이트하는 것을 권장함
	//버전 충돌을 방지하고 직렬화된 객체의 호환성을 보장하기 위해 사용
	
	//직렬화 : 객체를 바이트 스트림 상태로 바꿈,데이터를 네트워크로 전송하거나
	//				DB나 파일에 저장가능한 형식으로 바꾸는 프로세스
	//역직렬화 : 외부 소스에서 데이터를 읽고 이를 런타임 객체로 바꾸는 반대 프로세스
	
	ScheduleDatabase ScheduleDatabase = new ScheduleDatabase();
	//ScheduleDatabase클래스를 생성자를 사용하여 ScheduleDatabase라는 이름의 인스턴스 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//protected 서브클래스에서만 접근할 수 있게 하는 접근 제어자
		//void 리턴값이 없는 메서드
		//doGet HTTP의 GET 요청을 처리하는 메서드
		
		//HttpServletRequest 객체의 이름을 request 라는 이름으로 저장 
		//클라이언트가 서버에 보낸 HTTP 요청
		
		//HttpServletResponse 객체의 이름을 response라는 이름으로 저장 
		//서버에서 클라이언트에게 응답을 보낼 때 사용

		//throws 예외를 선언
		//ServletException 서블릿 처리 중에 발생하는 일반적인 예외
		//IOException 입출력 작업 중에 발생하는 예외
		
		
		HttpSession session = request.getSession();
		//http요청에서 세션을 가져오는 메서드 request.getSession();
		//사용자를 식별하고 사용자에 맞는 정보를 저장할 수 있게 해줌
		
		//HttpServletRequest객체의 getSession() 메서드를 호출
		//세션값을 가져올 때 사용
		
		String id = (String)session.getAttribute("USER");
		//String 문자열을 나타내는 데이터타입
		//session의 getAttribute메서드를 호출하여 세션에서 "USER"라는 이름의 속성 값을 가져옴
		Integer weeks;
		//Integer 정수를 나타내는 데이터타입 weeks라는 정수타입 변수를 선언
		
		String weeksParam=request.getParameter("weeks");
		//httprequest에서 "weeks"라는 키의 매개변수 값을 가져옴
		if(org.apache.commons.lang3.StringUtils.isEmpty(weeksParam)) {
			//Apache Commons Lang 라이브러리의 StringUtils.isEmpty()메서드
			//weeksParam이 null이거나 길이가 0이면 true 그렇지 않으면 false
			weeks=0;
			//weeksParam이 null이거나 길이가 0이면 weeks의 값을 0으로
		}else{//weeksParam이 null이 아니고 길이가 0이 아닌 경우
			weeks=Integer.parseInt(weeksParam);
			//weeks의 값은 weeksParam의 값을 Integer로 변환한 값으로 설정
			//주단위로 스케쥴을 불러오기 위한 값 week
		}
		 LocalDate today = LocalDate.now().plusDays(weeks);
		 //날짜 데이터타입 LocalDate
		 //now()오늘
		 //plusDays() ()안의 숫자만큼 더함
	     LocalDate startOfWeekDate = today.with(DayOfWeek.MONDAY);
	     //today가 포함된 주의 월요일 날짜
	     LocalDate endOfWeekDate = today.with(DayOfWeek.SUNDAY);
	     //today가 포함된 주의 일요일 날짜
	     //today가 포함된 주의 월~일요일 사이의 스케쥴만 불러오기 위해 작성
	     
	     String startOfWeek = startOfWeekDate.toString();
	     //LocalDate타입의 startOfWeekDate 를 String으로 변환하여 startOfWeek에 대입
	     String endOfWeek = endOfWeekDate.toString();
	     //LocalDate타입의 endOfWeekDate 를 String으로 변환하여 endOfWeek에 대입
	     //데이터베이스에 삽입하기 위해 String으로 변환 
	     
	     DateToday date = new DateToday();
	     //DateToday라는 클래스를 생성자를 사용하여 date라는 이름의 인스턴스 생성
	     //DateToday 클래스 에는 해당 주의 월,일요일 날짜와 id가 존재
	     
	     System.out.println(startOfWeek);
	     System.out.println(endOfWeek);
	     System.out.println(id);
	   //콘솔창에 id,startOfWeek,endOfWeek의 값을 표시
	     
	     date.setEndOfWeek(endOfWeek);
	     //DateToday 클래스인 date의 EndOfWeek에 endOfWeek의 값을 대입
	     //private로 접근이 제한되어 있기 때문에 set을 써서 값을 넣어야 함
	     date.setStartOfWeek(startOfWeek);
	     //DateToday 클래스인 date의 startOfWeek에 startOfWeek의 값을 대입
	     date.setId(id);
	     //DateToday 클래스인 date의 id에 id의 값을 대입
	     
		ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
		//Schedule 객체들을 저장하는 ArrayList를 scheduleList 라는 이름으로생성
		
		if(id==null) {//id의값이 null인 경우
			response.sendRedirect("login.jsp");//로그인 페이지로 이동시킴
		}else {//id의값이 null이 아닌 경우
			scheduleList = ScheduleDatabase.getSchedule(date);
			//ScheduleDatabase의 getSchedule()메서드에 date 값을 파라미터로 넣고 반환된 값을
			//scheduleList에 대입
			
			////scheduleList = dao.getSchedule(date);
			request.setAttribute("schedule", scheduleList);
			//서블릿에서 jsp로 scheduleList의 값을 schedule라는 키의 밸류로 설정 하여 보냄
			request.setAttribute("weeks", weeks);
			//서블릿에서 jsp로 weeks의 값을 weeks라는 키의 밸류로 설정 하여 보냄
			
			request.getRequestDispatcher("schedule.jsp").forward(request, response);
			//getRequestDispatcher("schedule.jsp") 서블릿에서 schedule.jsp로 요청을 전달
			//forward() 페이지를 이동시킴
			//forward(request, response) request, response의 값도 이동시킴
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost HTTP의 POST 요청을 처리하는 메서드
	}

}
