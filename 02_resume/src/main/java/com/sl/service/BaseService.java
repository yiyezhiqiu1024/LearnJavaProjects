package com.sl.service;

import com.sl.bean.Education;

import java.util.List;

public interface BaseService<T>{
    List<T> list();
    boolean save(T bean);
    boolean remove(Integer id);
    boolean remove(List<Integer> ids);
}
