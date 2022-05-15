package com.shan.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("tbl_book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    int id;
    String type;
    String name;
    @TableField("descp")
    String description;
}
