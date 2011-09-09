/*@文件名: HibernatePersistenceService.java  @创建人: 邢健   @创建日期: 2011-9-9 上午10:37:54*/
package com.promise.hibernate;

import java.io.Serializable;

/**   
 * @类名: HibernatePersistenceService.java 
 * @包名: com.promise.hibernate 
 * @描述: hibernate管理持久化对象接口 
 * @作者: 邢健 xingjian@yeah.net   
 * @日期: 2011-9-9 上午10:37:54 
 * @版本 V1.0   
 */
public interface HibernatePersistenceService {
	/**
	 * 保存对象
	 * @param object
	 * @return
	 */
	public boolean save(Object object);
	/**
	 * 更新持久化对象
	 * @param object
	 * @return
	 */
	public boolean update(Object object);
	/**
	 * 删除对象
	 * @param object
	 * @return
	 */
	public boolean delete(Object object);
	/**
	 * 获取对象，非惰性
	 * @param entity
	 * @param id
	 * @return
	 */
	public Object get(Class entity,Serializable id);
	/**
	 * 获取对象，惰性加载
	 * @param entity
	 * @param id
	 * @return
	 */
	public Object load(Class entity,Serializable id);
}
