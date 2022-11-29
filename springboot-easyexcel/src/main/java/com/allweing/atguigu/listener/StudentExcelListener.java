package com.allweing.atguigu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.allweing.atguigu.domian.Student;

/**
 * @auther: zzzgyu
 */

public class StudentExcelListener extends AnalysisEventListener<Student> {
    @Override
    public void invoke( Student student, AnalysisContext analysisContext ) {
        System.out.println(student);
        System.out.println("====================================");
    }

    @Override
    public void doAfterAllAnalysed( AnalysisContext analysisContext ) {

    }
}
