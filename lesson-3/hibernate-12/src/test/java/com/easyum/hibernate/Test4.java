package com.easyum.hibernate;

import com.easyum.hibernate.recipe4.Book4;
import com.easyum.hibernate.recipe4.Chapter4;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test4 {
    Book4 book4;

    @BeforeMethod
    public void clear() {
        HibernateUtil.deleteAll("Chapter4");
        HibernateUtil.deleteAll("Book4");

        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        book4 = new Book4();
        book4.setTitle("sample book");
        book4.getChapters().add(new Chapter4("chapter one"));
        book4.getChapters().add(new Chapter4("chapter two"));
        session.persist(book4);
        tx.commit();
        session.close();
    }

    @Test
    public void testCollectionCache() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Statistics stats = sessionFactory.getStatistics();
        stats.clear();

        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Book4 book = (Book4) session.byId(Book4.class).load(book4.getId());
        assertEquals(book.getTitle(), book4.getTitle());
        assertEquals(book.getChapters().size(), 2);
        tx.commit();
        session.close();
        assertEquals(stats.getSecondLevelCacheHitCount(), 0);
        assertEquals(stats.getSecondLevelCacheMissCount(), 2);
        // one book, two chapters, one collection
        assertEquals(stats.getSecondLevelCachePutCount(), 4);

        session = HibernateUtil.openSession();
        tx = session.beginTransaction();
        book = (Book4) session.byId(Book4.class).load(book4.getId());
        assertEquals(book.getTitle(), book4.getTitle());
        assertEquals(book.getChapters().size(), 2);
        tx.commit();
        session.close();

        // should hit the book, chapters, collection now
        assertEquals(stats.getSecondLevelCacheHitCount(), 4);
        assertEquals(stats.getSecondLevelCacheMissCount(), 2);
        // one book, two chapters, one collection
        assertEquals(stats.getSecondLevelCachePutCount(), 4);
    }
}
