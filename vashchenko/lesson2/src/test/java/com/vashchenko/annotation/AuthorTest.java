package com.vashchenko.annotation;

import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import static org.junit.Assert.*;

public class AuthorTest {

    public void testSavingAuthor(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Author author = new Author("Author");
        session.persist(author);
        transaction.commit();
        session.close();


    }


}