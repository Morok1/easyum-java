package com.easyum.hibernate;

import com.easyum.hibernate.recipe5.Address;
import com.easyum.hibernate.recipe5.Geolocation;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Recipe5 {
    @BeforeMethod
    public void cleanAll() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from Address").executeUpdate();
        tx.commit();
        session.close();
    }

    @Test
    public void testReadWrite() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Address address = new Address();
        address.setStreetAddress("100 E. Davie Street");
        address.setGeolocation(new Geolocation(35.7754700, -78.6379910));
        session.persist(address);
        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();
        Address address2 = (Address) session
                .byId(Address.class)
                .load(address.getId());
        assertEquals(address2.getGeolocation().getLongitude().doubleValue(),
                address.getGeolocation().getLongitude().doubleValue(),
                0.01);
        tx.commit();
        session.close();
    }

    @Test
    public void testQueryAttribute() {
        testReadWrite();
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Address address = new Address();
        address.setStreetAddress("89 E 42nd Street");
        address.setGeolocation(new Geolocation(40.7524710, -73.9772950));
        session.persist(address);
        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();
        Query query = session.createQuery(
                "from Address a where a.geolocation.latitude < :latitude");
        query.setBigDecimal("latitude", new BigDecimal(38));
        List<Address> results = query.list();
        assertEquals(results.size(), 1);
        assertTrue(results.get(0).getStreetAddress().contains("100"));
        tx.commit();
        session.close();


    }
}
