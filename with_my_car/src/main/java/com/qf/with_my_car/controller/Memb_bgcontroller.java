package com.qf.with_my_car.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.with_my_car.dto.*;
import com.qf.with_my_car.pojo.*;
import com.qf.with_my_car.service.Memb_bgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Linghui Kong
 * @Dcscription:
 * @Date:Created in 15:53 2019/4/13
 * @Modified By:
 */
@Controller
public class Memb_bgcontroller {
    int pageSize=10;
    @Autowired
    Memb_bgService memb_bgService;

//    @RequestMapping("/getAllMembDetail")
//    public String getAllMembDetail( Model model){
//        List<MemberProfile_bg>membs=memb_bgService.getAllMemb();
//        List<Tag_bg> tags= memb_bgService.getAllTag();
//        List<MemberPoint_bg>points=memb_bgService.getAllPoint();
//        model.addAttribute("membs",membs);
//        model.addAttribute("tags",tags);
//        model.addAttribute("points",points);
//        model.addAttribute("messeg","123");
//        return "member_manage_bg";
//    }
    @RequestMapping("/getAllMem_bg")            //
    public String getAllMem(HttpServletRequest request, Model model){
        String pageNum=request.getParameter("pageNum");
        int page=pageNum!=null?Integer.valueOf(pageNum):1;
//        int pageSize=2;
        List<Member_bg>membs=memb_bgService.getAllMem();
        PageHelper.startPage(page,pageSize);      //1
        List<Member_bg>membs2=memb_bgService.getAllMem();
        int totlePageNum=membs.size()/pageSize;
        if(membs.size()%pageSize!=0){
            totlePageNum++;
        }
        List<Integer>nums=new ArrayList<>();
        for(int i=1;i<=totlePageNum;i++){
            nums.add(i);
        }
        model.addAttribute("page",page);
        model.addAttribute("nums",nums);
        model.addAttribute("membs",membs2);
        return "member_manage_bg";
    }
    @RequestMapping("/index_bg")
    public String index(){
        return "index_bg";
    }
    @RequestMapping("/member_details_bg")
    public String member_details_bg(@RequestParam int id, Model model){
        System.out.println(id);
        Long id2=new Long(id);

        Member_Detail_bg detail=memb_bgService.getMembDetails(id);            //
        System.out.println(detail);

        List<MemberPoint_bg> points=memb_bgService.getAllPoint(id2);        //
        System.out.println(points);
        int count=0;
        for(MemberPoint_bg point: points){
            count+=point.getPoint();
        }

        List<Tag_bgdto>tags=memb_bgService.getAllTags(id);                    //
        System.out.println(tags);

        List<MemberCar_bg> cars=memb_bgService.getAllCarbg(id);
        System.out.println("所有车辆----"+cars);
        List<CarDtobg>mycars=new ArrayList<>();
        List<CarDtobg>likecars=new ArrayList<>();
        for(MemberCar_bg c:cars){
            CarDtobg car=new CarDtobg();
            CarDtobg cc = memb_bgService.getCarImg(c.getCarId());
            if(c.getType()==1){
                mycars.add(cc);
//                cars.remove(c);
            }else{
                likecars.add(cc);
                //                cars.remove(c);
            }
        }
        System.out.println("已有座驾---"+mycars);
        System.out.println("期望座驾------"+likecars);
        List<FavActiviDto_bg>activis=memb_bgService.getActiviById(id);
        List<FavArticDto_bg>artics=memb_bgService.getArticById(id);
        List<FavCarDto_bg>favcars=memb_bgService.getFavCarById(id);
        System.out.println(activis);
        System.out.println(artics);
        System.out.println(favcars);
        model.addAttribute("activis",activis);
        model.addAttribute("artics",artics);
        model.addAttribute("favcars",favcars);
        model.addAttribute("detail",detail);
        model.addAttribute("count",count);
        model.addAttribute("points",points);
        model.addAttribute("tags",tags);
        model.addAttribute("mycars",mycars);
        model.addAttribute("likecars",likecars);

        return "member_details_bg";
    }
    @RequestMapping("/vendor_add_bg")
    public String vendor_add_bg(Model model){
//        List<CarMake_bg>brands= memb_bgService.getAllBrand();
        List<BranDtobg> brans=memb_bgService.getAllBran();
        System.out.println(brans);
//        System.out.println(brands);
//        model.addAttribute("brands",brands);
        model.addAttribute("brans",brans);
        return "vendor_add_bg";
    }
    @RequestMapping("/vendor_doadd_bg")
    public String vendor_doadd_bg(@RequestParam String vendorname,@RequestParam String brandname,@RequestParam(value = "file") MultipartFile file
            ,Model model){
        String url="";
        Date date=new Date();
        String name=date.getTime()+file.getOriginalFilename();
        if(file!=null) {
            String path = "G:\\apps\\with_my_car\\src\\main\\resources\\static\\images\\photos\\" + name;
            File newFile = new File(path);
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            url = "images/photos/" + name;
        }
        int year = date.getYear() + 1900;
        int month = date.getMonth() + 1;
        int day = date.getDate();
        int time = Integer.valueOf(year + "0" + month + day);
        int createTime = Integer.valueOf(time);
        memb_bgService.addvendor(vendorname,brandname,url,time);

        List<CarMake_bg>brands= memb_bgService.getAllBrand();
        List<BranDtobg> brans=memb_bgService.getAllBran();
        System.out.println(brans);
        System.out.println(brands);
        model.addAttribute("brands",brands);
        model.addAttribute("brans",brans);
        return "vendor_manage_bg";
    }
    @RequestMapping("/vendor_edit_bg")
    public String vendor_edit_bg(@RequestParam int id, Model model){
        List<BranDtobg> brans=memb_bgService.getAllBran();
        model.addAttribute("brans",brans);
        List<Vendor> vendors=memb_bgService.getOneVendorById(id);
        model.addAttribute("vendors",vendors);
        return "vendor_edit_bg";
    }
    @RequestMapping("/vendor_doedit_bg")
    public String vendor_doedit_bg(@RequestParam String id,@RequestParam String vendorname,@RequestParam String brandname,@RequestParam(value = "file") MultipartFile file
            ,Model model){
        String url="";
        int idd=Integer.valueOf(id);
        Date date=new Date();
        String name=date.getTime()+file.getOriginalFilename();
        if(file!=null) {
            String path = "G:\\apps\\with_my_car\\src\\main\\resources\\static\\images\\photos\\" + name;
            File newFile = new File(path);
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            url = "images/photos/" + name;
        }
        int year = date.getYear() + 1900;
        int month = date.getMonth() + 1;
        int day = date.getDate();
        int time = Integer.valueOf(year + "0" + month + day);
        int createTime = Integer.valueOf(time);
        memb_bgService.editvendor(idd,vendorname,brandname,url,time);

        List<CarMake_bg>brands= memb_bgService.getAllBrand();
        List<BranDtobg> brans=memb_bgService.getAllBran();
        System.out.println(brans);
        System.out.println(brands);
        model.addAttribute("brands",brands);
        model.addAttribute("brans",brans);
        return "vendor_manage_bg";
    }
////设置分页参数
//PageHelper.startPage(1,2);
//
//List<Article_bg> article_bgs = articleService.selectAllArticle_bg();
//
////将查询出的结果给到PageInfo集合中
////将分页结果显示出来
//List<Article_bg> articleBgPageInfoList = article_bgPageInfo.getList();
//model.addAttribute("articles",articleBgPageInfoList);
//return "audit_info_bg";
    @RequestMapping("/brand_manage_bg")
    public String brand_manage_bg(HttpServletRequest request, Model model){
        String pageNum=request.getParameter("pageNum");
        int page=pageNum!=null?Integer.valueOf(pageNum):1;
//        int pageSize=2;
        List<CarMake_bg>brands= memb_bgService.getAllBrand();
        PageHelper.startPage(page,pageSize);      //1
        List<CarMake_bg>brands22= memb_bgService.getAllBrand();
        int totlePageNum=brands.size()/pageSize;
        if(brands.size()%pageSize!=0){
            totlePageNum++;
        }
        List<Integer>nums=new ArrayList<>();
        if(totlePageNum <= 5){
            for (int i = 1; i <= totlePageNum; i++) {
                nums.add(i);
            }
        }else if (page == 1 || page == 2){
            for (int i = 1; i <= 5 ; i++) {
                nums.add(i);
            }
        }else if (page >= 3 && totlePageNum - page >= 2){
            for (int i = page -2; i <= page + 2 ; i++) {
                nums.add(i);
            }
        }else if (totlePageNum - page <= 5){
            for (int i = totlePageNum - 4; i <= totlePageNum ; i++) {
                nums.add(i);
            }
        }

        List<CountryDto_bg> countrys=memb_bgService.getAllCountry();
        System.out.println(countrys);
        System.out.println(brands);
        model.addAttribute("brands",brands22);
        model.addAttribute("page",page);
        model.addAttribute("nums",nums);
        model.addAttribute("countrys",countrys);
        return "brand_manage_bg";
    }
//删除
    @RequestMapping("/delCarMakeById")
    public String delCarMakeById(@RequestParam int id,HttpServletRequest request, Model model){
        memb_bgService.delCarMakeById(id);
        this.brand_manage_bg(request,model);
        return "brand_manage_bg";
    }
    @RequestMapping("/delVendorById")
    public String delVendorById(@RequestParam int id,HttpServletRequest request, Model model){
        memb_bgService.delCarMakeById(id);
        this.vendor_manage_bg(request,model);
        return "vendor_manage_bg";
    }
    @RequestMapping("/delModel_bg")
    public String delModelById_bg(@RequestParam int id,HttpServletRequest request, Model model){
        memb_bgService.delModelById_bg(id);
//        this.cartype_bg(request,model);
//        return "car_bg";
        this.car_model_bg(request,model);
        return "car_model_bg";
    }
    @RequestMapping("/delCarTypeById")//删除车系
    public String delCarTypeById(@RequestParam int id,HttpServletRequest request, Model model){
        memb_bgService.delCarTypeById(id);
        this.cartype_bg(request,model);
        return "car_bg";
    }
    @RequestMapping("/carmodel")
    public String carmodel(HttpServletRequest request,Model model){
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String brand = request.getParameter("brand");
        String factory = request.getParameter("factory");
        CarModel_bg car=new CarModel_bg();
        car.setName(name);
        car.setBodyFormName(type);
        car.setBrandName(brand);
        car.setMakeName(factory);
        Date date=new Date();
        int year= date.getYear()+1900;
        int month = date.getMonth()+1;
        int day = date.getDate();
        int time=Integer.valueOf(year+"0"+month+day);
        int createTime=Integer.valueOf(time);
//        int year= date.getYear()+1900;
        car.setCreateTime(createTime);
        System.out.println(createTime);
         memb_bgService.addCarModel(car);
         return this.car_model_bg(request,model);
//         return "car_model_bg";
    }
    @RequestMapping("/editCarModel")
    public String editCarModel(HttpServletRequest request,Model model){
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String brand = request.getParameter("brand");
        String factory = request.getParameter("factory");
        System.out.println(request.getParameter("id"));
        int id=Integer.valueOf(request.getParameter("id"));
        CarModel_bg car=new CarModel_bg();
        car.setName(name);
        car.setBodyFormName(type);
        car.setBrandName(brand);
        car.setMakeName(factory);
        car.setId(id);
        Date date=new Date();
        int year= date.getYear()+1900;
        int month = date.getMonth()+1;
        int day = date.getDate();
        int time=Integer.valueOf(year+"0"+month+day);
        int createTime=Integer.valueOf(time);
//        int year= date.getYear()+1900;
        car.setCreateTime(createTime);
        System.out.println(createTime+"--------"+car);
        memb_bgService.editCarModel(car);
        return this.car_model_bg(request,model);
//         return "car_model_bg";
    }


    @RequestMapping("/getOneModelById_bg")
    @ResponseBody
    public List<CarModel_bg> getOneModelById_bg(@RequestParam int id){
        List<CarModel_bg>models= memb_bgService.getOneModelById(id);
        return models;
    }


    @RequestMapping("/addOneModel_bg")
    @ResponseBody
    public boolean addOneModel_bg(CarModel_bg model){
        memb_bgService.addOneModel_bg(model);
        return true;
    }
    @RequestMapping("/car_edit_bg")

    public String car_edit_bg(HttpServletRequest request,@RequestParam int id,Model model){
        List<CarTypeDto_bg>models= memb_bgService.getOneCarTypeById(id);
        List<YearDto_bg> years=memb_bgService.getAllYears();
        List<ModelBrandDtobg> brands=memb_bgService.getAllModelBrands();
        List<ModelTypeDtobg> types=memb_bgService.getAllModelTypes();
        List<ModelNameDto_bg> names=memb_bgService.getAllModelName();
        model.addAttribute("models",models);
        model.addAttribute("years",years);
        model.addAttribute("brands",brands);
        model.addAttribute("types",types);
        model.addAttribute("names",names);
        System.out.println(brands);
        System.out.println(types);
        System.out.println(names);

        return "car_edit_bg";
    }
    @RequestMapping("/car_doedit_bg")
    public String car_doedit_bg(HttpServletRequest request,@RequestParam int id,Model model){
        String all_spell = request.getParameter("all_spell");
        String brand_name = request.getParameter("brand_name");
        String year = request.getParameter("year");
        String name = request.getParameter("name");
        String body_form_name = request.getParameter("body_form_name");
        CarTypeDto_bg car=new CarTypeDto_bg();
        car.setAll_spell(all_spell);
        car.setBrand_name(brand_name);
        car.setYear(year);
        car.setName(name);
        car.setBody_form_name(body_form_name);
        car.setId(id);
        memb_bgService.editCarType(car);       //编辑新增
        this.cartype_bg(request,model);
        return "car_bg";
    }
    @RequestMapping("/car_add_bg")

    public String car_add_bg(HttpServletRequest request,Model model){
        List<YearDto_bg> years=memb_bgService.getAllYears();
        List<ModelBrandDtobg> brands=memb_bgService.getAllModelBrands();
        List<ModelTypeDtobg> types=memb_bgService.getAllModelTypes();
        List<ModelNameDto_bg> names=memb_bgService.getAllModelName();
        model.addAttribute("years",years);
        model.addAttribute("brands",brands);
        model.addAttribute("types",types);
        model.addAttribute("names",names);
        System.out.println(brands);
        System.out.println(types);
        System.out.println(names);

        return "car_add_bg";
    }
    @RequestMapping("/car_doadd_bg")
    public String car_doadd_bg(HttpServletRequest request,Model model){
        String all_spell = request.getParameter("all_spell");
        String brand_name = request.getParameter("brand_name");
        String year = request.getParameter("year");
        String name = request.getParameter("name");
        String body_form_name = request.getParameter("body_form_name");
        CarTypeDto_bg car=new CarTypeDto_bg();
        car.setAll_spell(all_spell);
        car.setBrand_name(brand_name);
        car.setYear(year);
        car.setName(name);
        car.setBody_form_name(body_form_name);
        memb_bgService.addOneCarType(car);
        System.out.println(all_spell+brand_name+year+name+body_form_name);
        System.out.println(car);
        this.cartype_bg(request,model);
        return "car_bg";
    }
    @RequestMapping("/cartype_bg")
    public String cartype_bg(HttpServletRequest request,Model model){
        String pageNum=request.getParameter("pageNum");
        int page=pageNum!=null?Integer.valueOf(pageNum):1;
        List<CarTypeDto_bg>cartypes= memb_bgService.getAllCarType();
        System.out.println(cartypes);
        PageHelper.startPage(page,pageSize);      //1
        List<CarTypeDto_bg>cartypes2= memb_bgService.getAllCarType();
        int totlePageNum=cartypes.size()/pageSize;
        if(cartypes.size()%pageSize!=0){
            totlePageNum++;
        }
        List<Integer>nums=new ArrayList<>();
        if(totlePageNum <= 5){
            for (int i = 1; i <= totlePageNum; i++) {
                nums.add(i);
            }
        }else if (page == 1 || page == 2){
            for (int i = 1; i <= 5 ; i++) {
                nums.add(i);
            }
        }else if (page >= 3 && totlePageNum - page >= 2){
            for (int i = page -2; i <= page + 2 ; i++) {
                nums.add(i);
            }
        }else if (totlePageNum - page <= 5){
            for (int i = totlePageNum - 4; i <= totlePageNum ; i++) {
                nums.add(i);
            }
        }
        if(page<1)
            page=1;
        if(page>totlePageNum)
            page=totlePageNum;
        System.out.println(page);
        model.addAttribute("page",page);
        model.addAttribute("nums",nums);
        List<ModelBrandDtobg> brands=memb_bgService.getAllModelBrands();
        List<ModelTypeDtobg> types=memb_bgService.getAllModelTypes();
        List<ModelNameDto_bg> names=memb_bgService.getAllModelName();
        model.addAttribute("models",cartypes2);
        model.addAttribute("brands",brands);
        model.addAttribute("types",types);
        model.addAttribute("names",names);
        System.out.println(brands);
        System.out.println(types);
        System.out.println(names);
        return "car_bg";
    }
    @RequestMapping("/car_model_bg")
    public String car_model_bg(HttpServletRequest request,Model model){
        String pageNum=request.getParameter("pageNum");
        int page=pageNum!=null?Integer.valueOf(pageNum):1;
        List<CarModel_bg>models= memb_bgService.getAllModel();
        PageHelper.startPage(page,pageSize);      //1
        List<CarModel_bg>models2= memb_bgService.getAllModel();
        int totlePageNum=models.size()/pageSize;
        if(models.size()%pageSize!=0){
            totlePageNum++;
        }
        List<Integer>nums=new ArrayList<>();


       if(totlePageNum <= 5){
           for (int i = 1; i <= totlePageNum; i++) {
               nums.add(i);
           }
       }else if (page == 1 || page == 2){
           for (int i = 1; i <= 5 ; i++) {
               nums.add(i);
           }
       }else if (page >= 3 && totlePageNum - page >= 2){
           for (int i = page -2; i <= page + 2 ; i++) {
               nums.add(i);
           }
       }else if (totlePageNum - page <= 5){
           for (int i = totlePageNum - 4; i <= totlePageNum ; i++) {
               nums.add(i);
           }
       }
        if(page<1)
            page=1;
        if(page>totlePageNum)
            page=totlePageNum;
//        page=page<1?1:page;
//        page=page>totlePageNum?totlePageNum:page;
        System.out.println(page);
        model.addAttribute("page",page);
        model.addAttribute("nums",nums);
        List<ModelBrandDtobg> brands=memb_bgService.getAllModelBrands();
        List<ModelTypeDtobg> types=memb_bgService.getAllModelTypes();
        model.addAttribute("models",models2);
        model.addAttribute("brands",brands);
        System.out.println(brands);
        System.out.println(types);
        model.addAttribute("types",types);
        return "car_model_bg";
    }
    @RequestMapping("/vendor_manage_bg")
    public String vendor_manage_bg(HttpServletRequest request,Model model){
        String pageNum=request.getParameter("pageNum");
        int page=pageNum!=null?Integer.valueOf(pageNum):1;
//        int pageSize=2;
        List<CarMake_bg>brands= memb_bgService.getAllBrand();
        PageHelper.startPage(page,pageSize);      //1
        List<CarMake_bg>brands2= memb_bgService.getAllBrand();
        int totlePageNum=brands.size()/pageSize;
        if(brands.size()%pageSize!=0){
            totlePageNum++;
        }
        List<Integer>nums=new ArrayList<>();
        for(int i=1;i<=totlePageNum;i++){
            nums.add(i);
        }
        model.addAttribute("page",page);
        model.addAttribute("nums",nums);
        List<BranDtobg> brans=memb_bgService.getAllBran();
        model.addAttribute("brands",brands2);
        model.addAttribute("brans",brans);
        return "vendor_manage_bg";
    }
    @RequestMapping("/sousuo_bg")
    public String sousuo_bg(@RequestParam String country, @RequestParam String search, Model model){

        List<CarMake_bg>brands= memb_bgService.mohusousuo_bg(country,search);

        List<CountryDto_bg> countrys=memb_bgService.getAllCountry();
        System.out.println(countrys);
        System.out.println(brands);
        model.addAttribute("brands",brands);
        model.addAttribute("countrys",countrys);
        return "brand_manage_bg";
    }
    @RequestMapping("/getOneBrand_bg")
    @ResponseBody
    public List<CarMake_bg> getOneBrand_bg(@RequestParam int id){
        System.out.println(id);
        List<CarMake_bg> cars= memb_bgService.getOneBrand_bg(id);
        System.out.println("123456456465"+cars);
        return cars;
    }

    @RequestMapping("/addOneBrand_bg")
    @ResponseBody
    public boolean addOneBrand_bg(CarMake_bg carMake_bg){
        System.out.println(carMake_bg);
        boolean b;
        System.out.println("进入add"+carMake_bg);
        b= memb_bgService.addOneBrand_bg(carMake_bg);
        return b;
    }
    @RequestMapping("/editOneBrand_bg")
    @ResponseBody
    public boolean editOneBrand_bg(CarMake_bg carMake_bg){
        System.out.println(carMake_bg);
        boolean b;
        System.out.println("进入edit");
        b=memb_bgService.editOneBrand_bg(carMake_bg);
        return b;
    }

    @RequestMapping("/getOneMakeById")
    @ResponseBody
    public List<CarMake_bg> getOneMakeById(int id){
        System.out.println(id);
        List<CarMake_bg> carMakes=memb_bgService.getOneMakeById(id);
        return carMakes;
    }
    @RequestMapping("/getAllVendor")
    public String getAllVendor(HttpServletRequest request,Model model){
        List<BranDtobg> brans = memb_bgService.getAllBran();
        String pageNum=request.getParameter("pageNum");
        int page=pageNum!=null?Integer.valueOf(pageNum):1;
        List<Vendor> vendors=memb_bgService.getAllVendor();
        PageHelper.startPage(page,pageSize);      //1
        List<Vendor> vendorss=memb_bgService.getAllVendor();
        int totlePageNum=vendors.size()/pageSize;
        if(vendors.size()%pageSize!=0){
            totlePageNum++;
        }
        List<Integer>nums=new ArrayList<>();


        if(totlePageNum <= 5){
            for (int i = 1; i <= totlePageNum; i++) {
                nums.add(i);
            }
        }else if (page == 1 || page == 2){
            for (int i = 1; i <= 5 ; i++) {
                nums.add(i);
            }
        }else if (page >= 3 && totlePageNum - page >= 2){
            for (int i = page -2; i <= page + 2 ; i++) {
                nums.add(i);
            }
        }else if (totlePageNum - page <= 5){
            for (int i = totlePageNum - 4; i <= totlePageNum ; i++) {
                nums.add(i);
            }
        }
        if(page<1)
            page=1;
        if(page>totlePageNum)
            page=totlePageNum;
        System.out.println(page);
        model.addAttribute("page",page);
        model.addAttribute("nums",nums);

        model.addAttribute("brans",brans);
        System.out.println(vendors);
        model.addAttribute("vendors",vendorss);
        return "vendor_manage_bg";
    }
    @RequestMapping("/searchVendor")
    public String searchVendor(HttpServletRequest request,Model model){
        String sel = request.getParameter("sel");
        String search = request.getParameter("search");
        sel=sel!=null?sel:"";
        search=search!=null?search:"";
        System.out.println(sel+"-----------"+search);
        List<BranDtobg> brans = memb_bgService.getAllBran();
        String pageNum=request.getParameter("pageNum");
        int page=pageNum!=null?Integer.valueOf(pageNum):1;
        List<Vendor> vendors=memb_bgService.searchVendor(sel,search);
        PageHelper.startPage(page,pageSize);      //1
        List<Vendor> vendorss=memb_bgService.searchVendor(sel,search);
        int totlePageNum=vendors.size()/pageSize;
        if(vendors.size()%pageSize!=0){
            totlePageNum++;
        }
        List<Integer>nums=new ArrayList<>();


        if(totlePageNum <= 5){
            for (int i = 1; i <= totlePageNum; i++) {
                nums.add(i);
            }
        }else if (page == 1 || page == 2){
            for (int i = 1; i <= 5 ; i++) {
                nums.add(i);
            }
        }else if (page >= 3 && totlePageNum - page >= 2){
            for (int i = page -2; i <= page + 2 ; i++) {
                nums.add(i);
            }
        }else if (totlePageNum - page <= 5){
            for (int i = totlePageNum - 4; i <= totlePageNum ; i++) {
                nums.add(i);
            }
        }
        if(page<1)
            page=1;
        if(page>totlePageNum)
            page=totlePageNum;
        System.out.println(page);
        model.addAttribute("page",page);
        model.addAttribute("nums",nums);

        model.addAttribute("brans",brans);
        System.out.println(vendors);
        model.addAttribute("vendors",vendorss);
        return "vendor_manage_bg";
    }






}
