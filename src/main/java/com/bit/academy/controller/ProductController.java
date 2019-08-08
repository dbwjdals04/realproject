package com.bit.academy.controller;

import com.bit.academy.model.BoardVO;
import com.bit.academy.model.ProductVO;
import com.bit.academy.service.ProductService;
import com.bit.academy.service.UploadService;
import com.bit.academy.util.UploadFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Slf4j
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UploadService uploadService;

    @GetMapping("/admin/product")
    public String product(){
        return "admin/productList";
    }

    /*
    @PostMapping("/admin/product/add")
    public String productAdd(@ModelAttribute ProductVO productVO, Model model, MultipartFile file) throws Exception{
        String uploadPath = "D:\\zzz";
        String imgUploadPath = uploadPath + File.separator + "imgUpload";
        log.debug("======================Controller======================");
        log.debug(imgUploadPath);
        String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
        log.debug(ymdPath);
        String fileName = null;

        if(file != null) {
            log.debug("!=null");
            fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
        } else {
            log.debug("null");
            fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
        }

        productVO.setThumb_600(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
        productVO.setThumb_name(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);

        log.debug(productVO.toString());
        this.productService.insertProduct(productVO);
        return "admin/productList";
    } */
    @PostMapping("/admin/product/add")
    public String productAdd (@ModelAttribute ProductVO productVO, Model model, @RequestParam("thumbnail") MultipartFile thumbnail, @RequestParam("detailImg") MultipartFile imageFile){
        String returnValue = "start";
        try {
            //this.productService.insertProduct(productVO);
            //log.debug(this.uploadService.saveImage(imageFile, productVO).toString());
            this.productService.insertProduct(this.uploadService.saveImage(thumbnail, imageFile,productVO));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error saving photo ", e);
            returnValue = "error";
        }
        return "admin/productList";
    }




}
