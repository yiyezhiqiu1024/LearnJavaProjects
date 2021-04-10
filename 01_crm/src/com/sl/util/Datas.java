package com.sl.util;

import com.sl.bean.Customer;

import java.util.ArrayList;
import java.util.List;

public class Datas {
    private static final List<Customer> customers = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer("张三" + i, 15 + i, 155.0 + i);
            customers.add(customer);
        }
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void add(Customer customer) {
        customers.add(customer);
    }

}
