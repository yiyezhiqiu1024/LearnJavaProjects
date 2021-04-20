package com.sl.dao;

import java.util.List;

public interface BaseDao<T> {
    List<T> list();
    boolean save(T bean);
    boolean remove(Integer id);
    boolean remove(List<Integer> ids);
}
