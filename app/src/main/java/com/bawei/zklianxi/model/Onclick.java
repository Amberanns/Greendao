package com.bawei.zklianxi.model;

import com.bawei.zklianxi.MyBean;

import java.util.List;



public interface Onclick {
    void  datasuccess(List<MyBean.ResultsBean> list);
    void  error(String rr);
}
