/*@文件名: PersistenceManagerImpl.java  @创建人: 邢健   @创建日期: 2011-12-6 上午10:31:28*/
package com.promise.dbutil.service.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.promise.dbutil.exception.DaoException;
import com.promise.dbutil.service.PersistenceManager;

/**   
 * @类名: PersistenceManagerImpl.java 
 * @包名: com.promise.dbutil.service.impl 
 * @描述: PersistenceManager接口实现类 
 * @作者: 邢健 xingjian@tongtusoft.com.cn   
 * @日期: 2011-12-6 上午10:31:28 
 * @版本 V1.0   
 */
@SuppressWarnings("all")
public class HibernatePersistenceManagerImpl<T extends Serializable> implements PersistenceManager<T> {
	
	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	
	protected final Session getCurrentSession() {
	    return sessionFactory.getCurrentSession();
	}
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/**
	 * 保存实体对象
	 */
	@Override
	public void save(final T entity) throws DaoException {
		getCurrentSession().save(entity);
	}
	
	/**
	 * 保存或者更新实体对象
	 */
	@Override
	public void saveOrUpdate(final T entity) throws DaoException {
		getCurrentSession().saveOrUpdate(entity);
	}

	/**
	 * 保存实体对象，是否立刻刷新
	 */
	@Override
	public void save(final T entity, final boolean flush) throws DaoException {
		getCurrentSession().save(entity);
		if(flush){
			getCurrentSession().flush();
	        getCurrentSession().clear();
		}
	}
	
	/**
	 * 更新实体对象
	 */
	@Override
	public void update(final T entity) throws DaoException {
		getCurrentSession().update(entity);
	}

	/**
	 * 删除实体对象
	 */
	@Override
	public void remove(final T entity) throws DaoException {
		getCurrentSession().delete(entity);
	}

	/**
	 * 通过实体ID删除对象
	 */
	@Override
	public void remove(Class clz, Serializable id) throws DaoException {
		 Object entity = getCurrentSession().load(clz,id);
		 getCurrentSession().delete(entity);
	}

	/**
	 * 批量删除实体对象
	 */
	@Override
	public void removeAll(Collection<T> entities) throws DaoException {
		for(final T entity:entities){
			getCurrentSession().delete(entity);
		}
	}

	/**
	 * 通过ID集合批量删除实体对象
	 */
	@Override
	public void removeAll(Class clz, Serializable[] ids) throws DaoException {
		for(Serializable id : ids){
            remove(clz,id);
		}
	}

}
