/**
 * @Title: SpittleRepository.java
 * @Desc: TODO
 * @Package: com.bermaker.jpa.hibernate.dao
 * @author: yuzhongchun(yuzhongchun@baidu.com)
 * @date: 2018年3月5日 下午5:48:43
 * @version 1.0
 */
package com.bermaker.jpa.hibernate.dao;

import java.util.List;

import com.bermaker.jpa.hibernate.domain.Spittle;

/**
 * ClassName: SpittleRepository
 * 
 * @Desc: TODO
 * @author: yuzhongchun(yuzhongchun@baidu.com)
 * @date: 2018年3月5日 下午5:48:43
 * @version 1.0
 */
public interface SpittleRepository {

    long count();

    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    Spittle findOne(long id);

    Spittle save(Spittle spittle);

    List<Spittle> findBySpitterId(long spitterId);

    void delete(long id);

}