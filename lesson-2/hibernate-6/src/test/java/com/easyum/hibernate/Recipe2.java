package com.easyum.hibernate;

import com.easyum.hibernate.recipe2.Book2;
import com.easyum.hibernate.recipe2.Book2IdBag;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Joseph on 9/2/2014.
 */
public class Recipe2 {
    @BeforeMethod
    public void clearAll() {
        HibernateUtil.deleteAll("Book2");
    }

    @Test
    public void testBagNoId() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Book2 book2 = new Book2();
        book2.setTitle("Title");
        book2.getReviews().add("awesome book");
        book2.getReviews().add("best ever");
        // duplicate is intentional; it's allowed in a bag!
        book2.getReviews().add("best ever");

        session.persist(book2);
        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();
        Book2 book = (Book2) session.byId(Book2.class)
                .load(book2.getId());
        assertEquals(book.getReviews().size(), 3);
        book.getReviews().remove(0); // remove the first one
        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();
        book = (Book2) session.byId(Book2.class)
                .load(book2.getId());
        assertEquals(book.getReviews().size(), 2);
        book.getReviews().set(0, "updated review");
        tx.commit();
        session.close();
    }

    @Test
    public void testIdBag() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Book2IdBag book2 = new Book2IdBag();
        book2.setTitle("Title");
        book2.getReviews().add("awesome book");
        book2.getReviews().add("best ever");
        // duplicate is intentional; it's allowed in a bag!
        book2.getReviews().add("best ever");

        session.persist(book2);
        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();
        Book2IdBag book = (Book2IdBag) session.byId(Book2IdBag.class)
                .load(book2.getId());
        assertEquals(book.getReviews().size(), 3);
        book.getReviews().remove(0); // remove the first one
        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();
        book = (Book2IdBag) session.byId(Book2IdBag.class)
                .load(book2.getId());
        assertEquals(book.getReviews().size(), 2);
        book.getReviews().set(0, "updated review");
        tx.commit();
        session.close();
    }
}
