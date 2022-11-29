package com.allweing;

/**
 * @auther: zzzgyu
 */


public class YuService {


    private String name;
    private String age;
    private String sex;

    public YuService( YuProperties yuProperties ) {
        this.name = yuProperties.getName();
        this.age = yuProperties.getAge();
        this.sex = yuProperties.getSex();
    }

    public String getMyName() {
        return name;
    }


    public String getMyAge() {
        return age;
    }


    public String getMySex() {
        return sex;
    }

}
