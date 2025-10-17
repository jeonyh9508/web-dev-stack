package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("avo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
    private Integer id;
    private String title;
    private String description;
    private Date created;
    private Date updated;
    private Integer member_id;
}
