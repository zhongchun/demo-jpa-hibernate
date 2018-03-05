/**
 * @Title: JpaSpitterRepository.java
 * @Desc: TODO
 * @Package: com.bermaker.jpa.hibernate.dao.impl
 * @author: yuzhongchun(yuzhongchun@baidu.com)
 * @date: 2018年3月5日 下午4:18:47
 * @version 1.0
 */
package com.bermaker.jpa.hibernate.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bermaker.jpa.hibernate.dao.SpitterRepository;
import com.bermaker.jpa.hibernate.domain.Spitter;

/**
 * ClassName: JpaSpitterRepository
 * 
 * @Desc: TODO
 * @author: yuzhongchun(yuzhongchun@baidu.com)
 * @date: 2018年3月5日 下午4:18:47
 * @version 1.0
 */
@Repository
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * @Title: count
     * @Desc:
     * @return
     * @see com.bermaker.jpa.hibernate.dao.SpitterRepository#count()
     */
    @Override
    public long count() {
        return findAll().size();
    }

    /**
     * @Title: save
     * @Desc:
     * @param spitter
     * @return
     * @see com.bermaker.jpa.hibernate.dao.SpitterRepository#save(com.bermaker.jpa.hibernate.domain.Spitter)
     */
    @Override
    public Spitter save(Spitter spitter) {
        entityManager.persist(spitter);
        return spitter;
    }

    /**
     * @Title: fineOne
     * @Desc:
     * @param id
     * @return
     * @see com.bermaker.jpa.hibernate.dao.SpitterRepository#fineOne(long)
     */
    @Override
    public Spitter findOne(long id) {
        return entityManager.find(Spitter.class, id);
    }

    /**
     * @Title: findByUsername
     * @Desc:
     * @param username
     * @return
     * @see com.bermaker.jpa.hibernate.dao.SpitterRepository#findByUsername(java.lang.String)
     */
    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) entityManager.createQuery("select s from Spitter s where s.username=?")
                .setParameter(1, username).getSingleResult();
    }

    /**
     * @Title: findAll
     * @Desc:
     * @return
     * @see com.bermaker.jpa.hibernate.dao.SpitterRepository#findAll()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>) entityManager.createQuery("select s from Spitter s").getResultList();
    }

}
