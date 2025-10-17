package service;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSendService {

	// 메일 전송을 위한 의존성 주입
	private JavaMailSender javaMailSender;

	private int authNumber = 0;
	
	public MailSendService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	// 난수(인증번호 6자리) 인증번호 생성
	public void makeRandomNumber() {
		Random rnd = new Random();
		// 난수 범위 111111 ~ 999999
		int checkNum = rnd.nextInt(999999 - 111111 + 1 ) + 111111;
		System.out.println("인증번호 : " + checkNum);
		authNumber = checkNum;
	}
	
	// 이메일을 전달할 양식
	public String joinEmail(String email) {
		makeRandomNumber();
		// 보내는 사람
		String setFrom = "plus08089@naver.com";
		// 받는 사람
		String toMail = email;
		// 제목
		String title = "회원 가입 인증 이메일";
		// 내용
		String content = "인증 번호는 <b>" + authNumber +"</b> 입니다.";
		
		try {
			
			MimeMessage mail = javaMailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
			
			// 메일로 보낼 세팅된 정보들 바인딩
			mailHelper.setFrom(setFrom);
			mailHelper.setTo(toMail);
			mailHelper.setSubject(title);
			// html 태그를 사용하기 위해서 true 사용
			mailHelper.setText(content, true);
			
			// 전송
			javaMailSender.send(mail);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 정수형을 문자열로 
		return String.valueOf(authNumber);
	}
}
