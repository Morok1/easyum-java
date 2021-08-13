package com.easyum.hibernate;

import com.easyum.hibernate.recipe3.Book3;
import com.easyum.hibernate.recipe3.Chapter3;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class Recipe3 {
    @BeforeMethod
    public void clearAll() {
        HibernateUtil.deleteAll("Book3");
    }

    @Test
    public void bidirectionalOneToMany() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();

        Book3 book3 = new Book3();
        book3.setTitle("First title");

        Chapter3 chapter3 = new Chapter3();
        chapter3.setTitle("first chapter");
        chapter3.setContent("here's some text");
        chapter3.setBook3(book3);
        book3.getChapters().add(chapter3);

        session.save(book3);

        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();

        Book3 book = (Book3) session
                .byId(Book3.class)
                .load(book3.getId());

        assertEquals(book.getTitle(), book3.getTitle());
        assertEquals(book.getChapters().size(),
                book3.getChapters().size());

        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();

        book = (Book3) session
                .byId(Book3.class)
                .load(book3.getId());

        session.delete(book);

        tx.commit();
        session.close();
    }

    @Test
    public void findBookGivenChapter() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();

        Book3 book2 = new Book3();
        book2.setTitle("First title");

        Chapter3 chapter3 = new Chapter3();
        chapter3.setTitle("first chapter");
        chapter3.setContent("here's some text");
        chapter3.setBook3(book2);

        book2.getChapters().add(chapter3);
        session.save(book2);

        tx.commit();
        session.close();

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();

        Chapter3 chapter = (Chapter3) session.byId(Chapter3.class).load(chapter3.getId());
        assertNotNull(chapter);

        // if we need the book, we have it!
        Book3 book = chapter.getBook3();
        assertEquals(book.getTitle(), book2.getTitle());

        tx.commit();
        session.close();
    }


}
