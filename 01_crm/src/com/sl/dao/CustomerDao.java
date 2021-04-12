package com.sl.dao;

import com.sl.bean.Customer;
import com.sl.util.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    /**
     * 返回所有的customer数据
     */
    public List<Customer> list() {
        String sql = "SELECT id, name, age, height FROM customer";
        return Dbs.getTpl().query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    /**
     * 将 customer 保存到数据库
     */
    public boolean save(Customer customer) {
        String sql = "INSERT INTO customer(name, age, height) VALUES (?, ?, ?)";
        List<Object> args = buildArgs(customer);
        Object[] array = args.toArray();
        return Dbs.getTpl().update(sql, array) > 0;
    }

    private List<Object> buildArgs(Customer customer) {
        List<Object> args = new ArrayList<>();
        args.add(customer.getName());
        args.add(customer.getAge());
        args.add(customer.getHeight());
        return args;
    }

}
