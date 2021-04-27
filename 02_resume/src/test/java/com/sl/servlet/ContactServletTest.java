package com.sl.servlet;

import com.sl.bean.Contact;
import com.sl.service.ContactService;
import com.sl.service.impl.ContactServiceImpl;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

public class ContactServletTest {

    @Test
    public void init() throws Exception {
        ContactService service = new ContactServiceImpl();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Contact contact = new Contact();
            contact.setName("一叶知秋" + random.nextInt(10000));
            contact.setEmail(random.nextInt(10000) + "@qq.com");
            contact.setSubject("招聘" + random.nextInt(10000));
            Date time = new Date();
            time.setYear(1980 + random.nextInt(30));
            time.setMonth(1 + random.nextInt(12));
            time.setDate(1 + random.nextInt(30));
            contact.setCreatedTime(time);
            contact.setComment("聊聊天" + random.nextInt(10000));
            service.save(contact);
        }
    }
}