package com.java.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class QueryInfo {
    private String query;
    private int pageNum=1;
    private int pageSize=1;

}
