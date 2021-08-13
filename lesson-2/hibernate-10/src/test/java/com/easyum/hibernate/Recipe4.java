package com.easyum.hibernate;

import com.easyum.hibernate.recipe4.Book4;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.assertEquals;

public class Recipe4 {

  @BeforeMethod
  public void setup() {
    HibernateUtil.deleteAll("Book4");
  }

  @Test
  public void testFilter() {
    Session session = HibernateUtil.openSession();
    Transaction tx = session.beginTransaction();
    Book4 book4 = new Book4("The Fog in the Dog", 1);
    session.save(book4);
    book4 = new Book4("Angsty Dead People", 2);
    session.save(book4);
    tx.commit();
    session.close();

    session = HibernateUtil.openSession();
    tx = session.beginTransaction();
    Query query = session.getNamedQuery("book4.findAll");
    List<Book4> books = (List<Book4>) query.list();
    assertEquals(books.size(), 2);
    tx.commit();
    session.close();

    session = HibernateUtil.openSession();
    tx = session.beginTransaction();

    // we don't want Angsty Dead People shown to a young child.
    session.enableFilter("rank").setParameter("rank", 1);
    query = session.getNamedQuery("book4.findAll");
    books = (List<Book4>) query.list();
    assertEquals(books.size(), 1);
    tx.commit();
    session.close();

  }

}
