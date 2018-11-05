package com.ufpb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class HomeController {

    @GetMapping("/")
    public void redirectToTwitter(HttpServletResponse httpServletResponse, HttpServletRequest request) throws IOException {
        httpServletResponse.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/swagger-ui.html");
    }
}
