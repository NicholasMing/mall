package com.ming.service;

import com.ming.entity.GoodsBrand;
import com.ming.mapper.GoodsBrandMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class GoodsBrandServiceImpl implements GoodsBrandService{
	@Autowired
	private GoodsBrandMapper goodsBrandMapper;

	public GoodsBrand selectGoodsBrandById(int brandId){
		return goodsBrandMapper.selectGoodsBrandById(brandId);
	}

	public List<GoodsBrand> selectGoodsBrandList(){
		return goodsBrandMapper.selectGoodsBrandList();
	}

	public int deleteByBrandId(int brandId){
		return goodsBrandMapper.deleteByBrandId(brandId);
	}

	public int saveGoodsBrand(GoodsBrand goodsBrand){
		return goodsBrandMapper.saveGoodsBrand(goodsBrand);
	}

	public int updateGoodsBrandByBrandId(GoodsBrand goodsBrand){
		return goodsBrandMapper.updateGoodsBrandByBrandId(goodsBrand);
	}

	public GoodsBrand selectByCondition(GoodsBrand goodsBrand){
		return goodsBrandMapper.selectByCondition(goodsBrand);
	}
}