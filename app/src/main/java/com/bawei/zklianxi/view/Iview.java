package com.bawei.zklianxi.view;

import com.bawei.zklianxi.MyBean;

import java.util.List;



public interface Iview {
    void showList(List<MyBean.ResultsBean> list);
    void showError(String e);
}
