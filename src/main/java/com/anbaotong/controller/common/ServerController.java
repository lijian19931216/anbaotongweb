package com.anbaotong.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ServerController {
    @RequestMapping(value="/config")
    public String  config(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/utf8-jsp/jsp/config.json";
    }
}
