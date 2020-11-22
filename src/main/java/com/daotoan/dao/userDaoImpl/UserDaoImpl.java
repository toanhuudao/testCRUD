package com.daotoan.dao.userDaoImpl;

import com.daotoan.dao.UserDao;
import com.daotoan.entity.UserDB;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addUser(UserDB user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(UserDB user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    public void deleteUser(int userId) {
        sessionFactory.getCurrentSession().delete(getUser(userId));
    }

    @Override
    public UserDB getUser(int userId) {
        return (UserDB) sessionFactory.getCurrentSession().get(UserDB.class, userId);
    }

    @Override
    public List<UserDB> getAllUser() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDB.class);
        return criteria.list();
    }
}
