package com.sl.dao;

import com.sl.bean.Contact;
import com.sl.bean.ContactListParam;
import com.sl.bean.ContactListResult;

public interface ContactDao extends BaseDao<Contact> {
    ContactListResult list(ContactListParam param);
    boolean read(Integer id);
}
