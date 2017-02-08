package com.ming.service;

import com.ming.entity.GoodsBrand;

import java.util.List;

public interface GoodsBrandService {

	GoodsBrand selectGoodsBrandById(int brandId);

	List<GoodsBrand> selectGoodsBrandList();

	int deleteByBrandId(int brandId);

	int saveGoodsBrand(GoodsBrand goodsBrand);

	int updateGoodsBrandByBrandId(GoodsBrand goodsBrand);

	GoodsBrand selectByCondition(GoodsBrand goodsBrand);
}