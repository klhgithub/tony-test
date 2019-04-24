package com.qf.with_my_car.service;

import com.qf.with_my_car.dto.*;
import com.qf.with_my_car.pojo.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Linghui Kong
 * @Dcscription:
 * @Date:Created in 15:58 2019/4/13
 * @Modified By:
 */
public interface Memb_bgService {
    public List<MemberProfile_bg> getAllMemb();//会员信息
    public List<Tag_bgdto> getAllTags(int id);           //标签
    public List<Member_bg>getAllMem();
    public Member_Detail_bg getMembDetails(int id);
    public List<MemberPoint_bg>getAllPoint(Long id);//会员管理积分
    public List<MemberCar_bg> getAllCarbg(int id);
    public CarDtobg getCarImg(int id);
    public List<CarMake_bg>getAllBrand();
    public List<CarMake_bg>sousuo_bg(String search);
    public List<CarMake_bg>mohusousuo_bg(String country,String search);
    public List<CarMake_bg> getOneBrand_bg(int id);
    public boolean addOneBrand_bg(CarMake_bg carMake_bg);
    public boolean editOneBrand_bg(CarMake_bg carMake_bg);
    public List<CarMake_bg> getOneMakeById(int id);
    public List<CountryDto_bg>getAllCountry();
    public List<BranDtobg>getAllBran();
    public void addvendor(String otherName,String brandName,String logoUrl,int createTime);
    public void editvendor(int id,String otherName, String brandName, String logoUrl,int createTime);
    public List<CarMake_bg> getOneBranById(int id);
    public List<CarModel_bg>getAllModel();
    public List<ModelBrandDtobg>getAllModelBrands();
    public List<ModelTypeDtobg> getAllModelTypes();
    public List<CarModel_bg>getOneModelById(int id);
    public void addOneModel_bg(CarModel_bg model);
    public List<CarTypeDto_bg>getAllCarType();
    public List<ModelNameDto_bg>getAllModelName();
    public List<CarTypeDto_bg>getOneCarTypeById(int id);
    public List<YearDto_bg>getAllYears();
    public void addOneCarType(CarTypeDto_bg car);
    public void editCarType(CarTypeDto_bg car);
    public List<FavActiviDto_bg>getActiviById(int id);
    public List<FavArticDto_bg>getArticById(int id);
    public List<FavCarDto_bg>getFavCarById(int id);
    public void delCarMakeById(int id);
    public void delModelById_bg(int id);
    public void addCarModel(CarModel_bg car);
    public void delCarTypeById(int id);
    public void editCarModel(CarModel_bg car);
    public List<Vendor>getAllVendor();
    public List<Vendor>searchVendor(String brand,String search);
    public List<Vendor>getOneVendorById(int id);

//    /**
//     * 商品分页功能(集成mybatis的分页插件pageHelper实现)
//     *
//     * @param currentPage    :当前页数
//     * @param pageSize        :每页显示的总记录数
//     * @return
//     */
//    @RequestMapping("/itemsPage")
//    @ResponseBody
//    public List<Item> itemsPage(int currentPage,int pageSize){
//        return itemService.findItemByPage(currentPage, pageSize);
//    }
}
