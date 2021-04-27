package com.sl.service.impl;

import com.sl.bean.Contact;
import com.sl.bean.ContactListParam;
import com.sl.bean.ContactListResult;
import com.sl.dao.ContactDao;
import com.sl.service.ContactService;

public class ContactServiceImpl extends BaseServiceImpl<Contact> implements ContactService {
    @Override
    public ContactListResult list(ContactListParam param) {
        return ((ContactDao) dao).list(param);
    }
}
