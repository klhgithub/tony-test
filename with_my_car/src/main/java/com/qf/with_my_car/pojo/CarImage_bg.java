package com.qf.with_my_car.pojo;

import java.io.Serializable;

public class CarImage_bg implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_image.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_image.car_id
     *
     * @mbggenerated
     */
    private Integer carId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_image.img_title
     *
     * @mbggenerated
     */
    private String imgTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_image.img_type
     *
     * @mbggenerated
     */
    private Integer imgType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_image.img_url
     *
     * @mbggenerated
     */
    private String imgUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_image.create_time
     *
     * @mbggenerated
     */
    private Integer createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_image.update_time
     *
     * @mbggenerated
     */
    private Integer updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_image.sync_time
     *
     * @mbggenerated
     */
    private Integer syncTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table car_image
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_image.id
     *
     * @return the value of car_image.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_image.id
     *
     * @param id the value for car_image.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_image.car_id
     *
     * @return the value of car_image.car_id
     *
     * @mbggenerated
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_image.car_id
     *
     * @param carId the value for car_image.car_id
     *
     * @mbggenerated
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_image.img_title
     *
     * @return the value of car_image.img_title
     *
     * @mbggenerated
     */
    public String getImgTitle() {
        return imgTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_image.img_title
     *
     * @param imgTitle the value for car_image.img_title
     *
     * @mbggenerated
     */
    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle == null ? null : imgTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_image.img_type
     *
     * @return the value of car_image.img_type
     *
     * @mbggenerated
     */
    public Integer getImgType() {
        return imgType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_image.img_type
     *
     * @param imgType the value for car_image.img_type
     *
     * @mbggenerated
     */
    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_image.img_url
     *
     * @return the value of car_image.img_url
     *
     * @mbggenerated
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_image.img_url
     *
     * @param imgUrl the value for car_image.img_url
     *
     * @mbggenerated
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_image.create_time
     *
     * @return the value of car_image.create_time
     *
     * @mbggenerated
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_image.create_time
     *
     * @param createTime the value for car_image.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_image.update_time
     *
     * @return the value of car_image.update_time
     *
     * @mbggenerated
     */
    public Integer getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_image.update_time
     *
     * @param updateTime the value for car_image.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_image.sync_time
     *
     * @return the value of car_image.sync_time
     *
     * @mbggenerated
     */
    public Integer getSyncTime() {
        return syncTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_image.sync_time
     *
     * @param syncTime the value for car_image.sync_time
     *
     * @mbggenerated
     */
    public void setSyncTime(Integer syncTime) {
        this.syncTime = syncTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", carId=").append(carId);
        sb.append(", imgTitle=").append(imgTitle);
        sb.append(", imgType=").append(imgType);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", syncTime=").append(syncTime);
        sb.append("]");
        return sb.toString();
    }
}