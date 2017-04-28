package com.headkeeper.dao.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Formatter;
import java.util.List;

public class EntityPreprocessor {

    public static void checkEntityOnExist(String entityName, int id, Session session) throws HibernateException {
        /*
            Here we make a request to database through proxy, which we get from session.load
            If Entity doesn't exist, hibernate throw exception
            If Entity exist - hibernate execute query
        */
        Formatter formatter = new Formatter();
        formatter.format("from %s where id = %d", entityName, id);
        String query = formatter.toString();
        List resultList = session.createQuery(query).list();
        if (resultList.size() == 0) {
            throw new HibernateException("Can't find " + entityName + " with id = " + id);
        }
    }
}
