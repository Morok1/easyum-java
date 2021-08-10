package com.easyum.hibernate;

import com.easyum.hibernate.recipe2.Contact;
import com.easyum.hibernate.recipe2.Phone;
import com.easyum.hibernate.recipe2.Order;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

public class Recipe2Test {
    @Test
    public void testNestedComponents() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Order order = new Order();
        order.setWeekdayContact(new Contact(
                "Srinivas Guruzu",
                "100 Main Street",
                new Phone(454, 555, 1212)));
        order.setHolidayContact(new Contact(
                "Joseph Ottinger",
                "P. O. Box 0",
                new Phone(978, 555, 1212)));
        session.persist(order);
        tx.commit();
        session.close();
    }
}
