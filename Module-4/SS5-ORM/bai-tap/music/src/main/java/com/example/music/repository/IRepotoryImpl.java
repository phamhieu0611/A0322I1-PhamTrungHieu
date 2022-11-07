package com.example.music.repository;

import com.example.music.model.Music;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class IRepotoryImpl implements IRepository{
    @Autowired
    private SessionFactory sessionFactory;

    private static EntityManager entityManager;

  /*  private static SessionFactory sessionFactory;


//    @PersistenceContext
//    private static EntityManager entityManager;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }*/
    @Override
    public List<Music> findAll() {
        entityManager = sessionFactory.createEntityManager();
        String queryStr ="Select s from Music as s";
        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Music music) {
        try {
            entityManager = sessionFactory.createEntityManager();
            entityManager.persist(music);
//        currentSession.saveOrUpdate(music);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class, id);
    }

    @Override
    public void update(Music music) {
        entityManager.merge(music);
    }

    @Override
    public void delete(Music music) {
        entityManager.remove(music);
    }
}
