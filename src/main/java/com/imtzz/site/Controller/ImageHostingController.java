package com.imtzz.site.Controller;

import com.imtzz.site.Dao.DTO.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/imageHosting")
public class ImageHostingController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ImageHostingController.class);

    @Value("${ImageHosting.uploadDir}")
    private String uploadDir;

    @RequestMapping("/upload")
    public Message upload(@RequestParam(value = "file") CommonsMultipartFile file) throws RuntimeException {
        Message msg = new Message();
        Map<Object, Object> data = msg.getData();
        if (file.isEmpty()) {
            data.put("res", "图片为空");
            return msg;
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
            data.put("res", fileName);
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return msg;
    }
}
