package com.sawlov2code.rmbackend.security.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sawlov2code.rmbackend.security.domain.HttpResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import java.io.IOException;
import java.io.OutputStream;


public class JwtAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {
  Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        logger.debug("Pre-authenticated entry point called. Rejecting access");
        HttpResponse httpResponse = new HttpResponse(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.toString(), HttpStatus.FORBIDDEN.getReasonPhrase());
        response.setContentType("application/json");
        response.setStatus(HttpStatus.FORBIDDEN.value());
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, httpResponse);
        outputStream.flush();
    }
}
