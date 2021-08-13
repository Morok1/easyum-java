package com.easyum.hibernate;

import com.easyum.hibernate.recipe3.Book3Version;
import com.easyum.hibernate.util.HibernateUtil;
import org.hibernate.LockOptions;
import org.hibernate.PessimisticLockException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Recipe4 {
  Book3Version b3v;

  @BeforeMethod
  public void clearData() {
    HibernateUtil.deleteAll("Book3Timestamp");
    HibernateUtil.deleteAll("Book3Version");
    Session session = HibernateUtil.openSession();
    Transaction tx = session.beginTransaction();
    b3v = new Book3Version();
    b3v.setTitle("Book3V");
    b3v.setInventoryCount(100);
    session.persist(b3v);

    tx.commit();
    session.close();
  }

  @Test(expectedExceptions = PessimisticLockException.class)
  public void showPessimisticLocking() {
    Session session1 = HibernateUtil.openSession();
    Session session2 = HibernateUtil.openSession();
    Transaction tx1 = session1.beginTransaction();
    Transaction tx2 = session2.beginTransaction();
    try {
      Book3Version s1book3 = (Book3Version) session1.byId(Book3Version.class)
          .with(LockOptions.UPGRADE)
          .load(b3v.getId());

      Book3Version s2book3 = (Book3Version) session2.byId(Book3Version.class)
          .with(LockOptions.UPGRADE)
          .load(b3v.getId());

    } finally {
      session1.close();
      session2.close();
    }
  }
}
