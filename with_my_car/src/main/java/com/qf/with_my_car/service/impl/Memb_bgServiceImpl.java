package com.qf.with_my_car.service.impl;

import com.qf.with_my_car.dto.*;
import com.qf.with_my_car.mapper.*;
import com.qf.with_my_car.pojo.*;
import com.qf.with_my_car.service.Memb_bgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Linghui Kong
 * @Dcscription:
 * @Date:Created in 15:59 2019/4/13
 * @Modified By:
 */
@Service
public class Memb_bgServiceImpl implements Memb_bgService {
    @Autowired
    MemberProfileMapper_bg memberProfileMapperBg;
    @Autowired
    TagMapper_bg tagMapper;
    @Autowired
    MemberPointMapper_bg memberPointMapperBg;
    @Autowired
    Memb_bgMapper memb_bgMapper;
    @Autowired
    MemberCarMapper_bg memberCarMapperBg;
    @Autowired
    CarMakeMapper_bg carMakeMapper_bg;
    @Autowired
    CarModelMapper_bg carModelMapper_bg;
    @Autowired
    VendorMapper vendorMapper;
    @Override
    public List<MemberProfile_bg> getAllMemb() {
        MemberProfileExample_bg example=new MemberProfileExample_bg();
        return memberProfileMapperBg.selectByExample(example);
    }

    @Override
    public List<Tag_bgdto> getAllTags(int id) {
//        TagExample_bg example=new TagExample_bg();
//        TagExample_bg.Criteria criteria = example.createCriteria();
//        criteria.and
        List<Tag_bgdto> tags=memb_bgMapper.getAllTags(id);
        return tags;
    }

    @Override
    public List<MemberPoint_bg> getAllPoint(Long id) {
        MemberPointExample_bg example=new MemberPointExample_bg();
        MemberPointExample_bg.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(id);
        return memberPointMapperBg.selectByExample(example);
    }

    @Override
    public List<MemberCar_bg> getAllCarbg(int id) {
        MemberCarExample_bg example_bg=new MemberCarExample_bg();
        MemberCarExample_bg.Criteria criteria = example_bg.createCriteria();
        Long id2=new Long(id);
        criteria.andMemberIdEqualTo(id2);
        return memberCarMapperBg.selectByExample(example_bg);
    }

    @Override
    public CarDtobg getCarImg(int id) {
        return memb_bgMapper.getCarImg(id);
    }

    @Override
    public List<CarMake_bg> getAllBrand() {
        CarMakeExample_bg example_bg=new CarMakeExample_bg();
        List<CarMake_bg> list=carMakeMapper_bg.selectByExample(example_bg);
        return list;
    }

    @Override
    public List<CarMake_bg> sousuo_bg(String search) {
        CarMakeExample_bg example=new CarMakeExample_bg();
        CarMakeExample_bg.Criteria criteria = example.createCriteria();
        criteria.andBrandNameLike(search);
//        criteria.and(country);
        return carMakeMapper_bg.selectByExample(example);
    }

    @Override
    public List<CarMake_bg> mohusousuo_bg(String country,String search) {

        return memb_bgMapper.mohusousuo_bg(country,search);
    }

    @Override
    public List<CarMake_bg> getOneBrand_bg(int id) {
        CarMakeExample_bg example_bg=new CarMakeExample_bg();
        CarMakeExample_bg.Criteria criteria = example_bg.createCriteria();
        criteria.andIdEqualTo(id);

        return carMakeMapper_bg.selectByExample(example_bg);
    }

    @Override
    public boolean addOneBrand_bg(CarMake_bg carMake_bg) {
//        CarMakeExample_bg example=new CarMakeExample_bg();
//        CarMakeExample_bg.Criteria criteria = example.createCriteria();
//        criteria.andBrandNameEqualTo(carMake_bg.getBrandName());
//        if(carMakeMapper_bg.selectByExample(example)!=null){
//            return false;
//        }
//        carMakeMapper_bg.insertSelective(carMake_bg);
        Date date=new Date();
        int year= date.getYear()+1900;
        int month = date.getMonth()+1;
        int day = date.getDate();
        String time=year+"0"+month+day;
        int createTime=Integer.valueOf(time);


        memb_bgMapper.addOneBrand_bg(carMake_bg.getBrandName(),carMake_bg.getLogoUrl(),createTime);
        return true;
    }

    @Override
    public boolean editOneBrand_bg(CarMake_bg carMake_bg) {
        CarMakeExample_bg example=new CarMakeExample_bg();
        CarMakeExample_bg.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(carMake_bg.getId());
        carMakeMapper_bg.updateByExampleSelective(carMake_bg,example);
        return true;
    }

    @Override
    public List<CarMake_bg> getOneMakeById(int id) {
        CarMakeExample_bg example=new CarMakeExample_bg();
        CarMakeExample_bg.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return carMakeMapper_bg.selectByExample(example);
    }

    @Override
    public List<CountryDto_bg> getAllCountry() {
        return memb_bgMapper.getAllCountry();
    }

    @Override
    public List<BranDtobg> getAllBran() {
        return memb_bgMapper.getAllBran();
    }

    @Override
    public void addvendor(String otherName, String brandName, String logoUrl,int createTime) {
        Vendor vendor=new Vendor();
        vendor.setBrandname(otherName);
        vendor.setVendorname(brandName);
        vendor.setVendorlogo(logoUrl);
        vendor.setCreatetime(createTime);
        VendorExample example=new VendorExample();
        vendorMapper.insertSelective(vendor);
    }
    @Override
    public void editvendor(int id,String otherName, String brandName, String logoUrl,int createTime) {
        Vendor vendor=new Vendor();
        vendor.setId(id);
        if(brandName!="")
        vendor.setBrandname(brandName);
        if(otherName!="")
        vendor.setVendorname(otherName);
        if(logoUrl!="")
        vendor.setVendorlogo(logoUrl);
        vendor.setCreatetime(createTime);
        VendorExample example=new VendorExample();
        VendorExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        vendorMapper.updateByExampleSelective(vendor,example);
    }

    @Override
    public List<CarMake_bg> getOneBranById(int id) {
        CarMakeExample_bg example=new CarMakeExample_bg();
        CarMakeExample_bg.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return carMakeMapper_bg.selectByExample(example);
    }

    @Override
    public List<CarModel_bg> getAllModel() {
        CarModelExample_bg example=new CarModelExample_bg();
        return carModelMapper_bg.selectByExample(example);
    }

    @Override
    public List<ModelBrandDtobg> getAllModelBrands() {
        return memb_bgMapper.getAllModelBrands();
    }

    @Override
    public List<ModelTypeDtobg> getAllModelTypes() {
        return memb_bgMapper.getAllModelTypes();
    }

    @Override
    public List<CarModel_bg> getOneModelById(int id) {
        CarModelExample_bg example=new CarModelExample_bg();
        CarModelExample_bg.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return carModelMapper_bg.selectByExample(example);
    }

    @Override
    public void addOneModel_bg(CarModel_bg model) {
        carModelMapper_bg.insertSelective(model);
    }

    @Override
    public List<CarTypeDto_bg> getAllCarType() {
        return memb_bgMapper.getAllCarType();
    }

    @Override
    public List<ModelNameDto_bg> getAllModelName() {
        return memb_bgMapper.getAllModelName();
    }

    @Override
    public List<CarTypeDto_bg> getOneCarTypeById(int id) {
        return memb_bgMapper.getOneCarTypeById(id);
    }

    @Override
    public List<YearDto_bg> getAllYears() {
        return memb_bgMapper.getAllYears();
    }

    @Override
    public void addOneCarType(CarTypeDto_bg car) {


        memb_bgMapper.addOneCarType(car);
        int id= memb_bgMapper.getCarTypeId(car);
        car.setId(id);
        memb_bgMapper.updateCarTypeLevel(car);
        memb_bgMapper.addOneCarTypeYear(car);

    }

    @Override
    public void editCarType(CarTypeDto_bg car) {
        memb_bgMapper.editCarType(car);
    }

    @Override
    public List<FavActiviDto_bg> getActiviById(int id) {
        return memb_bgMapper.getActiviById(id);
    }

    @Override
    public List<FavArticDto_bg> getArticById(int id) {
        return memb_bgMapper.getArticById(id);
    }

    @Override
    public List<FavCarDto_bg> getFavCarById(int id) {
        return memb_bgMapper.getFavCarById(id);
    }

    @Override
    public void delCarMakeById(int id) {
        memb_bgMapper.delCarMakeById(id);
    }

    @Override
    public void delModelById_bg(int id) {
        memb_bgMapper.delModelById_bg(id);
    }

    @Override
    public void addCarModel(CarModel_bg car) {
        memb_bgMapper.addCarModel(car);
    }

    @Override
    public void delCarTypeById(int id) {
        memb_bgMapper.delModelImageByd(id);
        memb_bgMapper.delCarTypeById(id);
    }

    @Override
    public void editCarModel(CarModel_bg car) {
        memb_bgMapper.editCarModel(car);
    }

    @Override
    public List<Vendor> getAllVendor() {
        VendorExample example=new VendorExample();
        VendorExample.Criteria criteria = example.createCriteria();
        return vendorMapper.selectByExample(example);
    }

    @Override
    public List<Vendor> searchVendor(String brand, String search) {
        VendorExample example=new VendorExample();
        VendorExample.Criteria criteria = example.createCriteria();
        if(brand!="") {
            criteria.andBrandnameEqualTo(brand);
        }
        if(search!="")
        {
            criteria.andVendornameLike(search);
        }
        return vendorMapper.selectByExample(example);
    }

    @Override
    public List<Vendor> getOneVendorById(int id) {
        VendorExample example=new VendorExample();
        VendorExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return vendorMapper.selectByExample(example);
    }

    @Override
    public List<Member_bg> getAllMem() {
        return memb_bgMapper.getAllMember_bg();
    }

    @Override
    public Member_Detail_bg getMembDetails(int id) {
        Member_Detail_bg detail_bg=memb_bgMapper.getMembDetails(id);

        return detail_bg;
    }
//    @Override
//    public List<Item> findItemByPage(int currentPage,int pageSize) {
//        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
//        PageHelper.startPage(currentPage, pageSize);
//
//        List<Item> allItems = itemMapper.findAll();        //全部商品
//        int countNums = itemMapper.countItem();            //总记录数
//        PageBean<Item> pageData = new PageBean<>(currentPage, pageSize, countNums);
//        pageData.setItems(allItems);
//        return pageData.getItems();
//    }


}
