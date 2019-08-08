package com.bit.academy.mapper;

import com.bit.academy.model.MemberVO;
import com.bit.academy.model.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface ProductMapper {

    void insertProduct(ProductVO productVO);
}
