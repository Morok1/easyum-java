package com.easyum.hibernate;

import com.easyum.hibernate.recipe1.Book1;
import com.easyum.hibernate.recipe1.Chapter1;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class Recipe1 {
    @BeforeMethod
    public void clearAll() {
        HibernateUtil.deleteAll("Book1");
    }

    @Test
    public void unidirectionalOneToMany() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();

        Book1 book1 = new Book1();
        book1.setTitle("First title");

        Chapter1 chapter1 = new Chapter1();
        chapter1.setTitle("first chapter");
        chapter1.setContent("here's some text");

        book1.getChapters().add(chapter1);
        session.save(book1);

        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();

        Book1 book = (Book1) session
                .byId(Book1.class)
                .load(book1.getId());

        assertEquals(book.getTitle(), book1.getTitle());
        assertEquals(book.getChapters().size(),
                book1.getChapters().size());

        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();

        book = (Book1) session
                .byId(Book1.class)
                .load(book1.getId());

        session.delete(book);

        tx.commit();
        session.close();
    }

    @Test
    public void findBookGivenChapter() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();

        Book1 book1 = new Book1();
        book1.setTitle("First title");

        Chapter1 chapter1 = new Chapter1();
        chapter1.setTitle("first chapter");
        chapter1.setContent("here's some text");

        book1.getChapters().add(chapter1);
        session.save(book1);

        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();

        Chapter1 chapter = (Chapter1) session.byId(Chapter1.class).load(chapter1.getId());
        assertNotNull(chapter);

        Query query = session.createQuery("from Book1 b where :chapter member of b.chapters");
        query.setParameter("chapter", chapter);

        Book1 book = (Book1) query.uniqueResult();
        assertEquals(book.getTitle(), book1.getTitle());

        tx.commit();
        session.close();
    }


}
