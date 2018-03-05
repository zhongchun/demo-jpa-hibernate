/**
 * @Title: SpitterRepository.java
 * @Desc: TODO
 * @Package: com.bermaker.jpa.hibernate.dao
 * @author: yuzhongchun(yuzhongchun@baidu.com)
 * @date: 2018年3月5日 下午4:17:32
 * @version 1.0
 */
package com.bermaker.jpa.hibernate.dao;

import java.util.List;

import com.bermaker.jpa.hibernate.domain.Spitter;

/**
 * ClassName: SpitterRepository
 * 
 * @Desc: TODO
 * @author: yuzhongchun(yuzhongchun@baidu.com)
 * @date: 2018年3月5日 下午4:17:32
 * @version 1.0
 */
public interface SpitterRepository {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
