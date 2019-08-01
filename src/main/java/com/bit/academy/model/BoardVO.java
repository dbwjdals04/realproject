package com.bit.academy.model;


import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

    private int qna_no;
    private int m_no;
    private String qna_context;
    private String qna_passwd;
    private Date qna_regdate;

    private String m_id;
    private String m_name;

}
