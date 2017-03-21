package com.example.administrator.mybase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */

public class MyBaseAdapter<E> extends BaseAdapter {


    /**
     * 适配器的父类，声明和实例化一些必须的属性和方法
     *
     * @author Administrator
     * @param <E>要保存的数据类型的泛型
     */

    // 保存数据的集合
    protected List<E> list;
    // 布局构造器
    protected LayoutInflater inflater;
    protected Context context;

    /**
     * 构造方法实例化属性
     *
     * @param context
     */
    public MyBaseAdapter(Context context) {
        list = new ArrayList<E>();
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    //用集合保存数据
    public List<E> getList() {
        return list;
    }

    // 添加数据
    public void add(E e) {
        list.add(e);
    }

    public void add(List<E> elist) {
        list.addAll(elist);
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    // 清空数据
    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        return null;
    }

}

