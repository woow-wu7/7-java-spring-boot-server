package com.example.lingjing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lingjing.bean.ProductBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<ProductBean> {
}
