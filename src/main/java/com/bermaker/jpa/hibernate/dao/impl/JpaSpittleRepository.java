/**
 * @Title: JpaSpittleRepository.java
 * @Desc: TODO
 * @Package: com.bermaker.jpa.hibernate.dao.impl
 * @author: yuzhongchun(yuzhongchun@baidu.com)
 * @date: 2018年3月5日 下午5:49:17
 * @version 1.0
 */
package com.bermaker.jpa.hibernate.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bermaker.jpa.hibernate.dao.SpittleRepository;
import com.bermaker.jpa.hibernate.domain.Spittle;

@Repository
public class JpaSpittleRepository implements SpittleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long count() {
        return findAll().size();
    }

    public List<Spittle> findRecent() {
        return findRecent(10);
    }

    @SuppressWarnings("unchecked")
    public List<Spittle> findRecent(int count) {
        return entityManager.createQuery("select s from Spittle s order by s.postedTime desc").setMaxResults(count)
                .getResultList();
    }

    public Spittle findOne(long id) {
        return entityManager.find(Spittle.class, id);
    }

    public Spittle save(Spittle spittle) {
        entityManager.persist(spittle);
        return spittle;
    }

    @SuppressWarnings("unchecked")
    public List<Spittle> findBySpitterId(long spitterId) {
        return entityManager.createQuery(
                "select s from Spittle s, Spitter sp where s.spitter = sp and sp.id=? order by s.postedTime desc")
                .setParameter(1, spitterId).getResultList();
    }

    public void delete(long id) {
        entityManager.remove(findOne(id));
    }

    @SuppressWarnings("unchecked")
    public List<Spittle> findAll() {
        return entityManager.createQuery("select s from Spittle s").getResultList();
    }

}
