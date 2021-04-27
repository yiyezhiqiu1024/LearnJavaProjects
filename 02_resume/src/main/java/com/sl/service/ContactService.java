package com.sl.service;

import com.sl.bean.Contact;
import com.sl.bean.ContactListParam;
import com.sl.bean.ContactListResult;

public interface ContactService extends BaseService<Contact> {
    ContactListResult list(ContactListParam param);
    boolean read(Integer id);
}
