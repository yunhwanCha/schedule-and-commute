package dao;
//데이터베이스에 접근하기 위한 DAO 패키지에 속하는 클래스를 선언하기 위한 선언부
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//패키지 외부의 클래스, 패키지, 라이브러리를 사용하기 위해 import로 선언
public class UserDatabase {//User와 관련된 DB처리를 하는 메서드
	private final String MAPPER_NAME = "mapper.userMapper.";
	// 스케쥴 매퍼의 위치를 상수로 설정
	
	public String getPw(String id) {//User DB 에서 id로 검색해서 나온 pw값을 받는 메서드
		SqlSession ss = getSession();//MyBatis의 SqlSession을 생성하여 DB에 연결
		String pw;//pw값을 넣을 변수 선언
		try {
			pw = ss.selectOne(MAPPER_NAME+"getPw",id);
			//id를 넣어 getPw 쿼리를 실행하고 결과 1개를 pw에 대입함
		}finally {
			ss.close();//DB와 연결 끊음
		}
		return pw;//pw값을 리턴함
	}
	
	private SqlSession getSession() {//mybatis와 상호작용하기 위한 메서드
		String config = "mybatisConfig.xml";
		//mybatisConfig.xml 에서 설정을 가져와 config에 대입
		
		InputStream is = null;
		//설정 파일을 읽어오기 위한 InputStream을 초기화
		
		try {//예외가 발생할 수도 있는 코드
			is = Resources.getResourceAsStream(config);//config의 파일 경로를 읽어 is에 대입
		}catch(Exception e) {}//예외를 처리하지 않음
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//MyBatis의 SqlSessionFactoryBuilder를 사용하여 SqlSessionFactory를 생성
		SqlSessionFactory factory = builder.build(is);
		//SqlSessionFactoryBuilder에서 is 의 주소에서 설정파일을 불러와 SqlSessionFactory생성
		SqlSession ss = factory.openSession();
		//SqlSessionFactory의 openSession()으로 SqlSession 생성
		//SqlSession 데이터베이스 연산을 수행하기 위한 인터페이스
		
		return ss;//SqlSession ss 를 반환
}
	
}
