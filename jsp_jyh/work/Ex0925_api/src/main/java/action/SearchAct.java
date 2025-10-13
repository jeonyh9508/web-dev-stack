package action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list.do")
public class SearchAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// list.do?search_txt=(?) 
		
		String search_txt= request.getParameter("search_txt");
		
		// 네이버 책 API query(검색어)파라미터 조건 -> UTF-8로 인코딩
		// jsp에서 받아온 값을 UTF8로 인코딩
		String search = URLEncoder.encode(search_txt, "UTF8");
	
		// query(필수) + display(선택) (display:20 (기본값 10 -> 20개 출력)
		String urlStr = "https://openapi.naver.com/v1/search/book.json?query=" + search +"&display=20";
		
		// URL 객체
		URL url = new URL(urlStr);
	
		// HttpURLConnection(추상 클래스) url경로를 베이스로 Http와 연결하는 객체
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		// 발급받은 Id / Secret (네이버 API 기준 참고사항)
		conn.setRequestProperty("X-Naver-Client-Id", "QvaUmNBXyGokgMXffJ5C");
		conn.setRequestProperty("X-Naver-Client-Secret", "uR6IntU459");
		
		// Buffer 빠른 작업 
		BufferedReader br = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );
		
		String line;
		String resultJson = "";
		// api에서 읽어온 json 구조의 내용들을 resultJson변수에 저장
		
		// 결과를 줄 단위로 가져오고, 모든 줄이 json에 저장되도록 반복
		while((line = br.readLine()) != null ) {
			resultJson += line;
		}
		
		System.out.println( resultJson );
		
		// Stream close / Connection disconnect
		br.close();
		conn.disconnect();
		
		// json 구조에 한글이 있을 경우 인코딩
		response.setContentType("text/plain;charset=UTF-8");
		
		
		response.getWriter().println("[" + resultJson + "]");
		
	}

}
