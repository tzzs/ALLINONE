package com.imtzz.site.Controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/imageHosting")
public class ImageHostingController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ImageHostingController.class);

    @Value("${ImageHosting.uploadDir}")
    private String uploadDir;

    @RequestMapping("/upload")
    public JSONObject upload(@RequestParam(value = "file") CommonsMultipartFile file) throws RuntimeException {
        JSONObject jsonObject = new JSONObject();

        if (file.isEmpty()) {
            jsonObject.put("res", "图片为空");
            return jsonObject;
        }

        String fileName = file.getOriginalFilename();
        LOGGER.info("图片文件名：" + fileName);
        assert fileName != null;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        LOGGER.info("图片后缀名：" + suffixName);

        String filePath = uploadDir;
        File dest = new File(filePath + fileName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            LOGGER.info("上传文件路径：" + filePath + fileName);
            jsonObject.put("res", fileName);
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return jsonObject;
    }
}
