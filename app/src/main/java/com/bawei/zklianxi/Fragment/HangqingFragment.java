package com.bawei.zklianxi.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.zklianxi.Adapter;
import com.bawei.zklianxi.Api;
import com.bawei.zklianxi.DbHelper;
import com.bawei.zklianxi.MyBean;
import com.bawei.zklianxi.R;
import com.bawei.zklianxi.User;
import com.bawei.zklianxi.UserDao;
import com.bawei.zklianxi.persenter.Presenter;
import com.bawei.zklianxi.view.Iview;
import com.bawei.zklianxi.view.MyGreendaoAdapter;

import java.util.List;



public class HangqingFragment extends Fragment implements Iview{

    private RecyclerView re;
    private Presenter presenter;
    private UserDao personDao;
    private User user;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.fragment_home,null);

        re = view.findViewById(R.id.re);
        presenter = new Presenter(this);
        presenter.getok(Api.PATH);

        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        personDao = DbHelper.getInstance(getActivity()).getPersonDao();
        user = new User();

        List<User> users = personDao.loadAll();
        re.setLayoutManager(new LinearLayoutManager(getActivity()));
        re.setAdapter(new MyGreendaoAdapter(users,getActivity()));



    }

    @Override
    public void showList(List<MyBean.ResultsBean> list) {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        re.setLayoutManager(linearLayoutManager);
        Adapter adapter=new Adapter(list,getContext());
        re.setAdapter(adapter);
        for(int i=0;i<list.size();i++){
            user.setDesc(list.get(i).getDesc());
            personDao.insert(user);
        }
    }

    @Override
    public void showError(String e) {

    }



}
