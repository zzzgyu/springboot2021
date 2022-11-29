package com.allweing.atguigu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.allweing.atguigu.domian.Student;
import com.allweing.atguigu.listener.StudentExcelListener;
import com.allweing.atguigu.service.EasyexcelService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @auther: zzzgyu
 */
@Service
public class EasyexcelServiceImpl implements EasyexcelService {
    @Override
    public void readExcel( MultipartFile file ) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, Student.class, new StudentExcelListener()).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
