package com.gf.guideforyou.mapper;

import org.apache.ibatis.annotations.Select;

import com.gf.guideforyou.vo.Location_CategoryBasicVo;
import com.gf.guideforyou.vo.TourBasicVo;

public interface Location_CategorySQLMapper {
	
	//한솔추가++지역테이블에서 지역이름 가져오는 것
	@Select("SELECT * FROM GF_LOCATION_CATEGORY WHERE LOCATION_IDX=#{location_idx}")
	public Location_CategoryBasicVo selectLocalNameByLocationIdx(TourBasicVo vo);
	
	
}
