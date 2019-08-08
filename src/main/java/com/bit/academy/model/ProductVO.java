package com.bit.academy.model;

import lombok.Data;

@Data
public class ProductVO {

    private int p_id;
    private String p_name;
    private int p_price;
    private String p_brand;
    private String p_spec;
    private String thumb_name;
    private String thumb_route;
    private String thumb_100;
    private String thumb_300;
    private String thumb_600;
    private String detailimg_name;
    private String detailimg_route;
}
