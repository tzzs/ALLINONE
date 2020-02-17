package com.imtzz.site.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/git")
public class GitWeb {

    @RequestMapping("/pages/sync")
    @ResponseBody
    public String PagesSync(HttpServletRequest request) {
        return "Hello world!";
    }
}
