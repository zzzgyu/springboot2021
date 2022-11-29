package com.allweing.atguigu.service;

import org.springframework.web.multipart.MultipartFile;

public interface EasyexcelService {
    void readExcel( MultipartFile file );
}
