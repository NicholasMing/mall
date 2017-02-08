package com.ming.controller;

import com.ming.entity.GoodsBrand;
import com.ming.service.GoodsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Nicholas on 2017/2/7.
 */
@Controller
@RequestMapping("/goodBrand")
public class GoodBrandController {
    @Autowired
    private GoodsBrandService goodsBrandService;

    @RequestMapping("goodBrandList")
    @ResponseBody
    public List<GoodsBrand> goodBrandList() {
        return goodsBrandService.selectGoodsBrandList();
    }

    @RequestMapping("goodBrandById/{goodsBrandId}")
    @ResponseBody
    public GoodsBrand goodsBrandById(@PathVariable int goodsBrandId) {
        return goodsBrandService.selectGoodsBrandById(goodsBrandId);
    }

    @RequestMapping("addGoodsBrand")
    @ResponseBody
    public boolean addGoodsBrand(GoodsBrand goodsBrand) {
        goodsBrand.setBrandNickname("mi");
        goodsBrand.setBrandName("xiaomi");
        goodsBrand.setBrandUrl("www.mi.com");
        goodsBrand.setBrandLogo("2");
        return goodsBrandService.saveGoodsBrand(goodsBrand) == 1 ? true : false;
    }

    @RequestMapping("goodsBrandDel/{goodsBrandId}")
    @ResponseBody
    public boolean delGoodsBrand(@PathVariable int goodsBrandId) {
        return goodsBrandService.deleteByBrandId(goodsBrandId) == 1 ? true : false;
    }

    @RequestMapping("goodsBrandUpdate/{goodsBrandId}")
    @ResponseBody
    public boolean updateGoodsBrand(GoodsBrand goodsBrand, @PathVariable int goodsBrandId) {
        goodsBrand.setBrandId(String.valueOf(goodsBrandId));
        goodsBrand.setBrandNickname("华为");
        goodsBrand.setBrandName("huawei");
        goodsBrand.setBrandUrl("www.huawei.com");
        goodsBrand.setBrandLogo("2");
        return goodsBrandService.updateGoodsBrandByBrandId(goodsBrand) == 1 ? true : false;
    }
}
