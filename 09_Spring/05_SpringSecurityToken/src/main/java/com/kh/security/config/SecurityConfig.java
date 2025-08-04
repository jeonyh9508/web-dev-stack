package com.kh.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JWTAuthenticationFilter jwtFilter; 

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable()) // 웹 보안 토큰 설정 (비활성화)
				.httpBasic(basic -> basic.disable()) // HTTP Basic 인증 방식 비활성화 -> JWT 토큰 방식 사용
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				 // 세션 설정 -> STATELESS 무상태 방식으로 설정 => 서버가 사용자 상태를 기억하지 못하게.
				.authorizeHttpRequests(authorize -> 
					authorize
						.requestMatchers("/mypage").authenticated()
						.requestMatchers("/admin").hasRole("ADMIN")
						.anyRequest().permitAll()
				)
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
		// authenticated() -> 로그인된 사용자만
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
