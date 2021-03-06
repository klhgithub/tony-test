package com.qf.with_my_car.mapper;

import com.qf.with_my_car.pojo.MemberProfile_bg;
import com.qf.with_my_car.pojo.MemberProfileExample_bg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface MemberProfileMapper_bg {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile
     *
     * @mbggenerated
     */
    int countByExample(MemberProfileExample_bg example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile
     *
     * @mbggenerated
     */
    int deleteByExample(MemberProfileExample_bg example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile
     *
     * @mbggenerated
     */
    int insert(MemberProfile_bg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile
     *
     * @mbggenerated
     */
    int insertSelective(MemberProfile_bg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile
     *
     * @mbggenerated
     */
    List<MemberProfile_bg> selectByExampleWithRowbounds(MemberProfileExample_bg example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile
     *
     * @mbggenerated
     */
    List<MemberProfile_bg> selectByExample(MemberProfileExample_bg example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile
     *
     * @mbggenerated
     */
    MemberProfile_bg selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MemberProfile_bg record, @Param("example") MemberProfileExample_bg example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MemberProfile_bg record, @Param("example") MemberProfileExample_bg example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MemberProfile_bg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MemberProfile_bg record);
}