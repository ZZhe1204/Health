package com.java.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MainMenu {
    private int id;
    private String title;
    private String path;
    List<SubMenu> slist;
}
