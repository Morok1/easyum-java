package com.easyum.hibernate;

import com.easyum.hibernate.recipe3.MapEntry;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class Recipe3Test {
    @Test
    public void testSaveOrUpdate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        MapEntry mapEntry = new MapEntry("key1", "value1");
        session.saveOrUpdate(mapEntry);
        tx.commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        MapEntry mapEntry1 = (MapEntry) session.load(MapEntry.class, "key1");
        assertEquals(mapEntry1.getValue(), mapEntry.getValue());
        tx.commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        mapEntry1 = new MapEntry("key1", "value2");
        session.saveOrUpdate(mapEntry1);
        tx.commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        MapEntry mapEntry2 = (MapEntry) session.load(MapEntry.class, "key1");
        assertEquals(mapEntry2.getValue(), "value2");
        tx.commit();
        session.close();

    }

}
