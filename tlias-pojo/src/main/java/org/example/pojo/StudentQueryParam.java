package org.example.pojo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentQueryParam {
    private Integer page; //页码
    private Integer pageSize; //每页条数
    private String name; //姓名
    private String no; //学号
    private Integer gender; //性别
    private Integer degree; //学历
}
