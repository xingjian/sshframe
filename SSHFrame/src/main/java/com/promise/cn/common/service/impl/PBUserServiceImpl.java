/*@文件名: PBUserServiceImpl.java  @创建人: 邢健   @创建日期: 2011-12-6 下午02:46:02*/
package com.promise.cn.common.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.promise.cn.common.domain.PBUser;
import com.promise.cn.common.service.PBUserService;

/**   
 * @类名: PBUserServiceImpl.java 
 * @包名: com.promise.cn.common.service.Impl 
 * @描述: 用户管理 
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-6 下午02:46:02 
 * @版本 V1.0   
 */
@SuppressWarnings("all")
@Service("pbUserService")
public class PBUserServiceImpl extends HibernateDaoSupport implements PBUserService {
	//日志对象
	private Logger log = LoggerFactory.getLogger(PBUserServiceImpl.class);
	
	/**
	 * 增加用户
	 * 返回1,表示成功, 0 表示用户名已经存在
	 */
	@Override
	public String savePBUser(PBUser pbUser) {
		if(checkUserNameIsUse(pbUser.getName())){
			this.getHibernateTemplate().save(pbUser);
			log.debug("Save PBUser: "+pbUser.getName());
			return "1";
		}else{
			return "0";
		}
	}

	/**
	 * 编辑用户
	 */
	@Override
	public void editPBUser(PBUser pbUser) {
		this.getHibernateTemplate().update(pbUser);
		log.debug("Edit PBUser: "+pbUser.getName());
	}

	/**
	 * 删除用户
	 */
	@Override
	public void deletePBUser(String id) {
		PBUser pbUser = this.getHibernateTemplate().get(PBUser.class, id);
		this.getHibernateTemplate().delete(pbUser);
	}
	
	/**
	 * 获取用户
	 */
	@Override
	public PBUser getPBUserByUserNameAndPWD(String userName, String pwd) {
		String hql = "from PBUser p where p.name='"+userName+"' and p.password='"+pwd+"'";
		List<PBUser> list = this.getHibernateTemplate().find(hql);
		if(null!=list&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * 检验用户名称是否可以使用
	 */
	@Override
	public boolean checkUserNameIsUse(String username) {
		String hql = "from PBUser p where p.name='"+username+"'";
		List<PBUser> list = this.getHibernateTemplate().find(hql);
		if(null!=list&&list.size()>0){
			return false;
		}
		return true;
	}

}
