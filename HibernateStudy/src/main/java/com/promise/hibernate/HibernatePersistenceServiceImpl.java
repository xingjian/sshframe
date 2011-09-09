/*@文件名: HibernatePersistenceServiceImpl.java  @创建人: 邢健   @创建日期: 2011-9-9 上午10:47:11*/
package com.promise.hibernate;

import java.io.Serializable;

import org.hibernate.Session;

/**   
 * @类名: HibernatePersistenceServiceImpl.java 
 * @包名: com.promise.hibernate 
 * @描述: hibernate管理持久化对象接口实现类 
 * @作者: 邢健 xingjian@yeah.net   
 * @日期: 2011-9-9 上午10:47:11 
 * @版本 V1.0   
 */
public class HibernatePersistenceServiceImpl extends HibernateUtil implements
		HibernatePersistenceService {

	public Session session;//session
	
	public HibernatePersistenceServiceImpl(){
		super();
	}
	
	/**
	 * 保存对象
	 */
	@SuppressWarnings("finally")
	@Override
	public boolean save(Object object) {
		boolean retBoolean = true;
		this.session = this.sessionFactory.openSession();
		try{
			this.session.beginTransaction();
			this.session.save(object);
			this.session.getTransaction().commit();
		}catch(Exception exception){
			this.session.getTransaction().rollback();
			retBoolean = false;
		}finally{
			this.session.close();
			return retBoolean;
		}
	}

	/**
	 * 更新对象
	 */
	@SuppressWarnings("finally")
	@Override
	public boolean update(Object object) {
		boolean retBoolean = true;
		this.session = this.sessionFactory.openSession();
		try{
			this.session.beginTransaction();
			this.session.update(object);
			this.session.getTransaction().commit();
		}catch(Exception exception){
			this.session.getTransaction().rollback();
			retBoolean = false;
		}finally{
			this.session.close();
			return retBoolean;
		}
	}

	/**
	 * 删除对象
	 */
	@SuppressWarnings("finally")
	@Override
	public boolean delete(Object object) {
		boolean retBoolean = true;
		this.session = this.sessionFactory.openSession();
		try{
			this.session.beginTransaction();
			this.session.delete(object);
			this.session.getTransaction().commit();
		}catch(Exception exception){
			this.session.getTransaction().rollback();
			retBoolean = false;
		}finally{
			this.session.close();
			return retBoolean;
		}
	}

	/**
	 * 获取对象
	 */
	@Override
	public Object get(Class entity, Serializable id) {
		this.session = this.sessionFactory.openSession();
		Object object = this.session.get(entity,id);
		this.session.close();
		return object;
	}

	/**
	 * 获取对象by主键
	 */
	@Override
	public Object load(Class entity, Serializable id) {
		this.session = this.sessionFactory.openSession();
		Object object = this.session.load(entity,id);
		this.session.close();
		return object;
	}
}
