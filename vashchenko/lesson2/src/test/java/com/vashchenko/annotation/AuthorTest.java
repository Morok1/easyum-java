package com.vashchenko.annotation;

import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {

    @Test
    public void testSavingAuthor(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int k = 0;
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < 10; i++) {
                Author author = new Author();
                author.setName("Author" + k++);
//                session.save(author);
                session.persist(author);
            }
            session.flush();
        }
        transaction.commit();
        session.close();
    }


}