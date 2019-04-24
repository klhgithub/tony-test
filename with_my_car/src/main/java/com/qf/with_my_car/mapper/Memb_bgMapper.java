package com.qf.with_my_car.mapper;

import com.qf.with_my_car.dto.*;
import com.qf.with_my_car.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Linghui Kong
 * @Dcscription:
 * @Date:Created in 17:03 2019/4/13
 * @Modified By:
 */
@Mapper
public interface Memb_bgMapper {
    public List<ModelBrandDtobg>getAllModelBrands();
    public List<ModelTypeDtobg> getAllModelTypes();
    public List<Member_bg> getAllMember_bg();//
    public Member_Detail_bg getMembDetails(int id);

    public List<Tag_bgdto> getAllTags(@Param("id") int id);
//    getAllPoint

    public CarDtobg getCarImg(int id);
//    public CarMake_bg getOneBrand_bg(int id);
    public void addOneBrand_bg(@Param("brandName")String brandName,@Param("logoUrl")String logoUrl,@Param("createTime") int createTime);
    public List<CountryDto_bg>getAllCountry();
    public List<CarMake_bg> mohusousuo_bg(String country,String search);
    public List<BranDtobg> getAllBran();
    public List<CarTypeDto_bg>getAllCarType();
    public List<ModelNameDto_bg>getAllModelName();
    public List<CarTypeDto_bg>getOneCarTypeById(int id);
    public List<YearDto_bg>getAllYears();
    public void addOneCarType(CarTypeDto_bg car);
    public int getCarTypeId(CarTypeDto_bg car);
    public void addOneCarTypeYear(CarTypeDto_bg car);
    public void editCarType(CarTypeDto_bg car);
    public List<FavActiviDto_bg>getActiviById(int id);
    public List<FavArticDto_bg>getArticById(int id);
    public List<FavCarDto_bg>getFavCarById(int id);
    public void delCarMakeById(int id);
    public void delModelById_bg(int id);
    public void addCarModel(CarModel_bg car);
    public void updateCarTypeLevel(CarTypeDto_bg car);
    public void delCarTypeById(@Param("id") int id);
    public void delModelImageByd(@Param("id") int id);
    public void editCarModel(CarModel_bg car);

}
