package com.qf.with_my_car.dto;

import lombok.Data;

/**
 * @Author: Linghui Kong
 * @Dcscription:
 * @Date:Created in 9:20 2019/4/16
 * @Modified By:
 */
@Data
public class MDto_bg {
    private Integer id;
    private String username;
    private String nickname;
    private String name;
    private String avatar_url;
    private Byte gender;
    private String email;
//    private Integer point;
    private String address;
    private Integer register_time;
}
