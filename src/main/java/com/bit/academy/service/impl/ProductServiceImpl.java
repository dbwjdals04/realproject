package com.bit.academy.service.impl;

import com.bit.academy.mapper.ProductMapper;
import com.bit.academy.model.ProductVO;
import com.bit.academy.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductVO modernAll(List category_no) {
        ProductVO modern = this.productMapper.modernAll(category_no);

        return modern;
    }

    @Override
    public ProductVO antiqueAll(List list) {
        return null;
    }

    @Override
    public ProductVO warmAll(List list) {
        return null;
    }
}
