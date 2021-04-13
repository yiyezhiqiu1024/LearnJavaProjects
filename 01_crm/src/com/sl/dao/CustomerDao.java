package com.sl.dao;

import com.sl.bean.Customer;
import com.sl.util.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    /**
     * 根据 id 查找 customer
     */
    public Customer find(Integer id) {
        String sql = "SELECT id, name, age, height FROM customer WHERE id = ?";
        return Dbs.getTpl().queryForObject(sql, new BeanPropertyRowMapper<>(Customer.class), id);
    }

    /**
     * 返回所有的 customer 数据
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

    /**
     * 更新 customer
     */
    public boolean update(Customer customer) {
        String sql = "UPDATE customer SET name = ?, age = ?, height = ? WHERE id = ?";
        List<Object> args = buildArgs(customer);
        args.add(customer.getId());
        Object[] array = args.toArray();
        return Dbs.getTpl().update(sql, array) > 0;
    }

    /**
     * 删除 customer
     */
    public boolean remove(Integer id) {
        String sql = "DELETE FROM customer WHERE id = ?";
        return Dbs.getTpl().update(sql, id) > 0;
    }

    private List<Object> buildArgs(Customer customer) {
        List<Object> args = new ArrayList<>();
        args.add(customer.getName());
        args.add(customer.getAge());
        args.add(customer.getHeight());
        return args;
    }
}
