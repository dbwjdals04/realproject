package com.bit.academy.mapper;


import com.bit.academy.model.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface ProductMapper {

    /**
     * 모던디자인 전체보기
     * @param list
     */
    ProductVO modernAll(List list);


    /**
     * 골동디자인 전체보기
     * @param list
     */
    ProductVO antiqueAll(List list);


    /**
     * 따듯한디자인 전체보기
     * @param list
     */
    ProductVO warmAll(List list);

}
