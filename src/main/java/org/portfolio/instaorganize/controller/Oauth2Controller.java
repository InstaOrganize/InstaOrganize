package org.portfolio.instaorganize.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.portfolio.instaorganize.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@RestController
public class Oauth2Controller {
    @GetMapping("/user")
    public ResponseEntity<UserDTO> user(@AuthenticationPrincipal OAuth2User principal) throws JsonProcessingException {
        UserDTO userDTO =  new UserDTO(principal.getAttribute("login"),principal.getAttribute("name"));
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/error")
    public String error(HttpServletRequest request) {
        String message = (String) request.getSession().getAttribute("error.message");
        request.getSession().removeAttribute("error.message");
        return message;
    }
}
