package com.easyum.hibernate;

import com.easyum.hibernate.model.Address;
import com.easyum.hibernate.model.Customer;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Recipe3Test {
    @Test
    public void testSetComponents() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Customer customer = new Customer();
        
        Set<Address> addresses = new HashSet<>();
        
        Address secondary = new Address();
        secondary.setAddress1("100 Main Street");
        secondary.setCity("Astoria");
        secondary.setState("Portland");
        secondary.setZip("97210");

        Address primary = new Address();
        primary.setAddress1("1200 Central Ave");
        primary.setCity("Phoenix");
        primary.setState("Arizona");
        primary.setZip("85221");

        addresses.add(primary);
        addresses.add(secondary);
        
        customer.setContacts(addresses);
        customer.setName("Guruzu");
        
        session.persist(customer);
        tx.commit();
        session.close();
    }
}
