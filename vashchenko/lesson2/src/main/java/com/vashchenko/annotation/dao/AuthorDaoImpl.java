package com.vashchenko.annotation.dao;

import com.easyum.hibernate.util.HibernateUtil;
import com.vashchenko.annotation.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AuthorDaoImpl implements AuthorDao{


    @Override
    public List<Author> getAuthor() {
            return null;
    }
}
