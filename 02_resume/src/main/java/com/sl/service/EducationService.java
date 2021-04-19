package com.sl.service;

import com.sl.bean.Education;

import java.util.List;

public interface EducationService {
    List<Education> list();
    boolean save(Education education);
    boolean remove(Integer id);
    boolean remove(List<Integer> ids);
}
