package com.bit.academy.controller;

import com.bit.academy.model.ProductVO;
import com.bit.academy.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    // 모던상품 전체요청
    @ResponseBody
    @GetMapping("/member/modernAll")
    public ProductVO modernAll(@RequestParam("category_no") List category_no,
                          Model model) {

        log.debug(String.valueOf(category_no));
        ProductVO productVO = this.productService.modernAll(category_no);

        return productVO;
    }


}


