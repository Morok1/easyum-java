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
        Author author = new Author();
        author.setName("Author");

//        session.persist(author);
        session.save(author);
        transaction.commit();
        session.close();


    }


}