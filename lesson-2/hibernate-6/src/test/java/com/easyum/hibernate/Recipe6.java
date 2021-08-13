package com.easyum.hibernate;

import com.easyum.hibernate.recipe6.Book6DatabaseSorting;
import com.easyum.hibernate.recipe6.Book6InvertedSorting;
import com.easyum.hibernate.recipe6.Book6NaturalSorting;
import com.easyum.hibernate.util.HibernateUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.collection.internal.PersistentSortedSet;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class Recipe6 {
    @BeforeMethod
    public void clearAll() {
        HibernateUtil.deleteAll("Book6NaturalSorting");
        HibernateUtil.deleteAll("Book6InvertedSorting");
        HibernateUtil.deleteAll("Book6DatabaseSorting");
    }

    @Test
    public void testNaturalSorting() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();

        Book6NaturalSorting book6 = new Book6NaturalSorting();

        book6.setTitle("The title");
        book6.getReviews().add("b");
        book6.getReviews().add("c");
        book6.getReviews().add("a");

        session.persist(book6);

        assertEquals(concatenate(book6.getReviews()),
                ":a:b:c");

        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();

        Book6NaturalSorting book = (Book6NaturalSorting) session
                .byId(Book6NaturalSorting.class)
                .load(book6.getId());

        assertEquals(concatenate(book.getReviews()),
                ":a:b:c");

        // this may be a brittle test, because future
        // versions of Hibernate might not use the same
        // class name for PersistentSortedSet.
        assertTrue(book.getReviews() instanceof PersistentSortedSet);

        tx.commit();
        session.close();
    }

    @Test
    public void testInvertedSorting() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();

        Book6InvertedSorting book6 = new Book6InvertedSorting();

        book6.setTitle("The title");
        book6.getReviews().add("b");
        book6.getReviews().add("c");
        book6.getReviews().add("a");

        session.persist(book6);

        // the entity uses natural ordering
        // before reconstruction through Hibernate.
        assertEquals(concatenate(book6.getReviews()),
                ":a:b:c");

        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();

        Book6InvertedSorting book = (Book6InvertedSorting) session
                .byId(Book6InvertedSorting.class)
                .load(book6.getId());

        // the entity should now be using the inverted
        // sort order.
        assertEquals(concatenate(book.getReviews()),
                ":c:b:a");

        tx.commit();
        session.close();
    }

    private String concatenate(Collection<String> collection) {
        StringBuilder sb = new StringBuilder();
        for (String s : collection) {
            sb.append(":").append(s);
        }
        return sb.toString();
    }

    private boolean isInOrder(Set<String> collection) {
        boolean isInOrder = true;

        Iterator<String> iterator = collection.iterator();
        if (iterator.hasNext()) {
            String j = iterator.next();
            while (isInOrder && iterator.hasNext()) {
                String k = iterator.next();
                //noinspection unchecked
                if (k.compareTo(j) < 1) {
                    isInOrder = false;
                }
                j = k;
            }
        }
        return isInOrder;
    }

    @Test
    public void testOrderTest() {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("1");
        set.add("a");
        set.add("b");
        set.add("c");
        assertFalse(isInOrder(set));
        set = new TreeSet<>(set);
        assertTrue(isInOrder(set));
    }

    @Test(dependsOnMethods = "testOrderTest")
    public void testDatabaseSorting() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();

        Book6DatabaseSorting book6 = new Book6DatabaseSorting();

        book6.setTitle("The title");
        for (int i = 0; i < 6; i++) {
            // RandomStringUtils is from Apache's commons-lang3 library.
            book6.getReviews().add(RandomStringUtils.random(8, true, true));
        }

        // keep adding reviews until they're not in order,
        // just in case.
        while (isInOrder(book6.getReviews())) {
            book6.getReviews().add(RandomStringUtils.random(8, true, true));
        }

        session.persist(book6);

        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();

        Book6DatabaseSorting book = (Book6DatabaseSorting) session
                .byId(Book6DatabaseSorting.class)
                .load(book6.getId());

        assertTrue(isInOrder(book.getReviews()));

        tx.commit();
        session.close();
    }
}
