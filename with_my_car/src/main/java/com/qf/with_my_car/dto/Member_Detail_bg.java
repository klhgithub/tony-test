package com.qf.with_my_car.dto;

import com.qf.with_my_car.pojo.MemberPoint_bg;
import lombok.Data;

/**
 * @Author: Linghui Kong
 * @Dcscription:
 * @Date:Created in 17:30 2019/4/15
 * @Modified By:
 */
@Data
public class Member_Detail_bg {
    private Long id;
    private String username;
    private String nickname;
    private String name;
    private String avatar_url;
    private Byte gender;
    private String email;
//    private List<MemberPoint_bg> points;
    private String address;
    private Integer register_time;
//    private List<Tag_bg> tags;

//    private List<MemberCar_bg> cars;
//    private List<MemberFav_bg> favs;
//    private List<MemberPoint_bg> points;

    //已有座驾(member_car   member_car car_id  car_image list 根据用户id查座驾车款car_id 再查车款图片img_url)
    // 期望座驾 参加的活动 关注的活动
    // (member_point  pointnum  create_time point)总积分 积分时间 积分出入
    //资讯搜藏  article(id,title,cover_pic)
    // 关注车型



}
