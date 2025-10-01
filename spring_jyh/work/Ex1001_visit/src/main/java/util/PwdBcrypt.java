package util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PwdBcrypt {

	// 암호화
	public String encodingPwd( String pwd ) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		// pwd를 encoder로 암호화
		String encodedPwd = encoder.encode(pwd);
		
		// 암호화된 pwd를 반환
		return encodedPwd;
	}
	
	// 복호화 (비밀번호 체크)
	public boolean validPwd(String inputPw, String oriPw) {
		
		boolean isValid = false;
		
		// 입력한 비밀번호, 암호화된 비밀번호 순
		isValid = BCrypt.checkpw(inputPw, oriPw);
		
		return isValid;
	}
}
