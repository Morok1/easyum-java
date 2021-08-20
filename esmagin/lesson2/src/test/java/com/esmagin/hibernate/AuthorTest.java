package com.esmagin.hibernate;

import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

public class AuthorTest {

    @Test
    public void testSavingAuthor() {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        final Author author = new Author();
        author.setName("Author");
        try {
            session.persist(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
        transaction.commit();
        session.close();
    }
}