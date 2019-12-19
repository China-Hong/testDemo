package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "user", type = "docs", shards = 1, replicas = 0)
public class Person {
    //主键自增长
    @Id
    private Long id;//主键
    @Field(type = FieldType.String, analyzer = "ik_max_word")
    private String user;
    @Field(type = FieldType.String, analyzer = "ik_max_word")
    private  String title;
    @Field(type = FieldType.String, analyzer = "ik_max_word")
    private  String desc;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
