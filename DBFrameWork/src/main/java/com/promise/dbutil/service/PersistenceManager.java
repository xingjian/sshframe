/*@文件名: PersistenceManager.java  @创建人: 邢健   @创建日期: 2011-12-6 上午10:26:03*/
package com.promise.dbutil.service;

import java.io.Serializable;
import java.util.Collection;

import com.promise.dbutil.exception.DaoException;

/**   
 * @类名: PersistenceManager.java 
 * @包名: com.promise.dbutil.service 
 * @描述: PersistenceManager.java 
 * @作者: 邢健 xingjian@tongtusoft.com.cn   
 * @日期: 2011-12-6 上午10:26:03 
 * @版本 V1.0   
 */
@SuppressWarnings("all")
public interface PersistenceManager<T extends Serializable> {

	/**
	 * 保存对象
	 * @param entity
	 * @throws DaoException
	 */
	 public void save(final T entity) throws DaoException;
     public void saveOrUpdate(final T entity) throws DaoException;
     /**
      * 保存entity,是否立即生效
      * @param entity
      * @param flush
      * @throws DaoException
      */
     public void save(final T entity,boolean flush) throws DaoException;
     /**
      * 修改entity
      * @param entity
      * @throws DaoException
      */
     public void update(final T entity) throws DaoException;
     /**
      * 删除entity
      * @param entity
      * @throws DaoException
      */
     public void remove(final T entity) throws DaoException;
     /**
      * 删除该id的entity
      * @param clz
      * @param id
      * @throws DaoException
      */
     public void remove(Class clz,Serializable id) throws DaoException;
     /**
      * 删除集合中的entity
      * @param entities
      * @throws DaoException
      */
     public void removeAll(Collection<T> entities) throws DaoException;
     /**
      * 删除数组中的id的entity
      * @param clz
      * @param ids
      * @throws DaoException
      */
     public void removeAll(Class clz,Serializable[] ids) throws DaoException;
}
