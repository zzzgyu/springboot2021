package com.allweing.atguigu.domian;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @auther: zzzgyu
 */

@Data
@ToString
public class Student {

    @ExcelProperty(index = 0)
    private String name;

    @ExcelProperty(index = 1)
    private Integer age;


}
