package com.mynager.rest.api.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynager.rest.api.config.UserSpringSecurity;
import com.mynager.rest.api.config.jwt.JWTUtil;
import com.mynager.rest.api.services.UserSpringSecurityServiceImpl;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	JWTUtil jwtUtil;

	@PostMapping("/refresh_token")
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSpringSecurity userCont = UserSpringSecurityServiceImpl.authenticated();
		String token = jwtUtil.generateToken(userCont.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers","Authorization");
        return ResponseEntity.noContent().build();
	}
}
