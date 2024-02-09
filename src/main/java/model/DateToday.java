package model;
//model 패키지에 속하는 클래스를 선언하기 위한 선언부
public class DateToday {
	private String startOfWeek;
	private String endOfWeek;
	private String id;
	//정보 은닉과 캡슐화를 위해 private를 사용하여 외부에서 접근할 수 없는 변수 선언
	
	public String getStartOfWeek() {
		return startOfWeek;
	}//startOfWeek의 값을 외부로 반환하는 메서드
	public void setStartOfWeek(String startOfWeek) {
		this.startOfWeek = startOfWeek;
	}//startOfWeek의 값을 외부에서 설정하기 위한 메서드
	public String getEndOfWeek() {
		return endOfWeek;
	}//EndOfWeek의 값을 외부로 반환하는 메서드
	public void setEndOfWeek(String endOfWeek) {
		this.endOfWeek = endOfWeek;
	}//endOfWeek의 값을 외부에서 설정하기 위한 메서드
	public String getId() {
		return id;
	}//id의 값을 외부로 반환하는 메서드
	public void setId(String id) {
		this.id = id;
	}//id의 값을 외부에서 설정하기 위한 메서드
	
	
	
	
	
}
