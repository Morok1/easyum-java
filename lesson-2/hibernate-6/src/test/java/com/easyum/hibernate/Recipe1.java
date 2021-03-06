package com.easyum.hibernate;

import com.easyum.hibernate.recipe1.Book1;
import com.easyum.hibernate.recipe1.Book1Embedded;
import com.easyum.hibernate.recipe1.Chapter1;
import com.easyum.hibernate.recipe1.Chapter1Embedded;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class Recipe1 {

    @BeforeMethod
    public void clearAll() {
        HibernateUtil.deleteAll("Book1");
        HibernateUtil.deleteAll("Book1Embedded");
    }

    @Test
    public void testBook() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Book1 book = new Book1();
        book.setTitle("First book");
        Chapter1 chapter = Chapter1.builder()
                .book(book)
                .title("first chapter")
                .content("contents")
                .build();
        book.getChapters().add(chapter);

        chapter = Chapter1.builder()
                .book(book)
                .title("second chapter")
                .content("more contents")
                .build();
        book.getChapters().add(chapter);

        book.getReviews().add("This book is great");
        book.getReviews().add("This book is light on content");
        book.getReviews().add("This book is great");

        session.persist(book);
        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();

        Book1 book1 = (Book1) session.byId(Book1.class)
                .load(book.getId());
        assertEquals(book1.getReviews().size(), 2);
        assertEquals(book1.getChapters().size(), 2);

        tx.commit();
        session.close();
    }

    @Test
    public void testEmbedded() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Book1Embedded book = new Book1Embedded();
        book.setTitle("First book");
        Chapter1Embedded chapter = Chapter1Embedded.builder()
                .title("first chapter")
                .content("contents")
                .build();
        book.getChapters().add(chapter);

        chapter = Chapter1Embedded.builder()
                .title("second chapter")
                .content("more contents")
                .build();
        book.getChapters().add(chapter);

        book.getReviews().add("This book is great");
        book.getReviews().add("This book is light on content");
        book.getReviews().add("This book is great");

        session.persist(book);
        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();

        Book1Embedded book1 = (Book1Embedded) session
                .byId(Book1Embedded.class)
                .load(book.getId());
        assertEquals(book1.getReviews().size(), 2);
        assertEquals(book1.getChapters().size(), 2);

        tx.commit();
        session.close();
    }
}
