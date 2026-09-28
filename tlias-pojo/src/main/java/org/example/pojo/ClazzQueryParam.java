package org.example.pojo;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ClazzQueryParam {
    private String name;        //班级名称
    private LocalDate begin;    //结课时间-开始
    private LocalDate end;      //结课时间-结束
    private Integer page;       //页码
    private Integer pageSize;   //每页条数
    private Integer pageStart;  //分页起始下标
}
