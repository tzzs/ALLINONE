package com.imtzz.site.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/imageHosting")
public class ImageHostingController {
    private final  static Logger LOGGER = LoggerFactory.getLogger(ImageHostingController.class);

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value = "file")CommonsMultipartFile file) throws RuntimeException {
        if (file.isEmpty()){

        }
        return "Hello world!";
    }
}
