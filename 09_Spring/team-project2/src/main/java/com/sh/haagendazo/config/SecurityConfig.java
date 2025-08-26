package com.sh.haagendazo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http // 괄호 안에 별도 요청 없을 경우, 취소선 처리 되어 있음 (버전마다 문법이 다를 수 있으니 주의할 것!)
				.csrf(csrf -> csrf.disable()) // 웹 보안 토큰 설정 (비활성화)
				.authorizeHttpRequests(authorize -> 
					authorize
						//.requestMatchers("/mypage").authenticated() // 해당 페이지 접근 권한 부여
						.requestMatchers("/admin").hasRole("ADMIN") // ROLE_ADMIN 을 인식하여 권한 부여 
						.anyRequest().permitAll()) // 언급한 페이지 외 전체 접근 가능
				.formLogin(form ->
					form
						.loginPage("/login") // 로그인 페이지 설정 (시큐리티 기본 페이지 아닌 본인이 만든 페이지로 지정 가능)
						.loginProcessingUrl("/login") // 로그인 처리를 위한 POST 요청 URL
						.defaultSuccessUrl("/user"))
				.logout(logout ->
					logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/user"))
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		// 중복 슬래시 허용
		firewall.setAllowUrlEncodedDoubleSlash(true); // URL 인코딩된 // 허용 (%2F%2F)
		firewall.setAllowSemicolon(true); // 세미콜론도 허용할 수 있음 (선택)
		return firewall;
	}
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
	}
}
