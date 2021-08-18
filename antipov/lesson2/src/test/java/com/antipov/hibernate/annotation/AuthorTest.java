package com.antipov.hibernate.annotation;

import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Random;

public class AuthorTest {
    char[] alph = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
                   'H', 'I', 'K', 'L', 'M', 'N', 'O',
                   'P', 'Q', 'R', 'S', 'T', 'V', 'X',
                   'Y', 'Z'};

    @Test
    public void testSavingAuthor() {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        final Author author = new Author("Author", "");
        session.persist(author);
        transaction.commit();
        session.close();
    }

    @Test
    public void testHomeworkLesson2() {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        for(int i = 0; i < 200; i++) {
            final Book author = new Book(randomCharacter(new Random().nextInt(100)), randomCharacter(new Random().nextInt(100)), randomCharacter(new Random().nextInt(100)));
            session.persist(author);

            if(i % 19 == 0) {
                session.flush();
            }
        }

        transaction.commit();
        session.close();
    }

    private String randomCharacter(int length) {
        String str = "";
        for(int i = 0; i < length; i++) {
            str += alph[new Random().nextInt(alph.length)];
        }

        return str;
    }
}