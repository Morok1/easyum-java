package com.easyum.hibernate;


import com.easyum.hibernate.recipe5.Address5;
import com.easyum.hibernate.recipe5.Customer5;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Recipe5 {
    @BeforeMethod
    public void clearAll() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Customer4 c");
        List<Customer5> customers = query.list();
        for (Customer5 c : customers) {
            session.delete(c);
        }
        tx.commit();
        session.close();
    }

    @Test
    public void testOneToOne() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Customer5 customer5 = new Customer5();
        customer5.setName("Absalom");
        session.persist(customer5);

        Address5 address5 = new Address5();
        address5.setAddress("100 Hebron Way");
        address5.setCity("Tel Aviv");

        address5.setCustomer(customer5);
        customer5.setAddress5(address5);

        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();
        Customer5 customer = (Customer5) session
                .byId(Customer5.class)
                .load(customer5.getId());
        Hibernate.initialize(customer.getAddress5());
        tx.commit();
        session.close();

        assertEquals(customer.getName(), customer5.getName());
        assertEquals(customer.getAddress5().getAddress(),
                customer5.getAddress5().getAddress());
    }

    @Test(dependsOnMethods = "testOneToOne")
    public void other() {
    }
}
