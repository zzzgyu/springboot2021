package com.allweing.atguigu.controller;

import com.allweing.atguigu.service.EasyexcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @auther: zzzgyu
 */

@RestController
public class EasyexcelController {

    @Autowired
    EasyexcelService easyexcelService;


    @PostMapping("upload")
    public String readExcel( MultipartFile file ) {
        easyexcelService.readExcel(file);

        return "success";
    }
}
