package com.qf.with_my_car.dto;

import lombok.Data;

/**
 * @Author: Linghui Kong
 * @Dcscription:
 * @Date:Created in 21:44 2019/4/15
 * @Modified By:
 */
//@Data
public class Tag_bgdto {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Tag_bgdto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag_bgdto() {
    }

    public Tag_bgdto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
