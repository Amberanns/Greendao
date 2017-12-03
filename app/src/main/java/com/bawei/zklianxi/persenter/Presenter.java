package com.bawei.zklianxi.persenter;

import com.bawei.zklianxi.MyBean;
import com.bawei.zklianxi.model.Imodel;
import com.bawei.zklianxi.model.Onclick;
import com.bawei.zklianxi.model.model;
import com.bawei.zklianxi.view.Iview;

import java.util.List;



public class Presenter {
    Imodel imodel;
    Iview iview;

    public Presenter( Iview iview) {

        this.iview = iview;
        imodel=new model();
    }
    public  void getok(String url){
        imodel.Request(url, new Onclick() {
            @Override
            public void datasuccess(List<MyBean.ResultsBean> list) {
                iview.showList(list);

            }

            @Override
            public void error(String rr) {
                iview.showError(rr);
            }
        });

    }

}
