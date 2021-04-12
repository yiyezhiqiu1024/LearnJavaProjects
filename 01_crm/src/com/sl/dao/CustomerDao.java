package com.sl.dao;

import com.sl.bean.Customer;
import com.sl.util.Dbs;

import java.util.List;

public class CustomerDao {

    /**
     * 返回所有的customer数据
     */
    public List<Customer> list() {
        String sql = "SELECT id, name, age, height FROM customer";
        return Dbs.query(sql, (rs, row) -> {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setAge(rs.getInt("age"));
            customer.setHeight(rs.getDouble("height"));
            return customer;
        });
    }

    /**
     * 将 customer 保存到数据库
     */
    public boolean save(Customer customer) {
        String sql = "insert into customer(name, age, height) values(?, ?, ?)";
        return Dbs.update(sql, customer.getName(), customer.getAge(), customer.getHeight()) > 0;
    }

}
