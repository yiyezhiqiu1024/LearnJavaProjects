package com.sl.dao;

import com.sl.bean.Education;
import java.util.List;

public interface EducationDao {
    List<Education> list();
    boolean save(Education education);
    boolean remove(Integer id);
    boolean remove(List<Integer> ids);
}
