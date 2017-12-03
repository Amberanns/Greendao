package com.bawei.zklianxi;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class User {
    @Id
    String desc;

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Generated(hash = 178838398)
    public User(String desc) {
        this.desc = desc;
    }

    @Generated(hash = 586692638)
    public User() {
    }




}
