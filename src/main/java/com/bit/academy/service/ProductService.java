package com.bit.academy.service;

import com.bit.academy.model.ProductVO;

import java.util.List;

public interface ProductService {


    /**
     * modernAll
     * @return
     */
    ProductVO modernAll(List list);


    /**
     * antiqueAll
     * @return
     */
    ProductVO antiqueAll(List list);


    /**
     * warmAll
     * @return
     */
    ProductVO warmAll(List list);


}
