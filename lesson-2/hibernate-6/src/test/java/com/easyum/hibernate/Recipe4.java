package com.easyum.hibernate;

import com.easyum.hibernate.recipe4.Book4;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class Recipe4 {
    @BeforeMethod
    public void clearAll() {
        HibernateUtil.deleteAll("Book4");
    }
    @Test
    public void testArray() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Book4 book = new Book4();
        book.setTitle("First book");

        String[] reviews = new String[]{
                "This book is great",
                "This book is light on content"
        };

        book.setReviews(reviews);

        session.persist(book);
        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();

        Book4 book1 = (Book4) session
                .byId(Book4.class)
                .load(book.getId());
        assertEquals(book1.getReviews().length, 2);

        tx.commit();
        session.close();
    }
}
