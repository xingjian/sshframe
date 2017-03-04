/*@文件名: QueryManagerImpl.java  @创建人: 邢健   @创建日期: 2011-12-6 上午10:57:40*/
package com.promise.dbutil.service.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.internal.CriteriaImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.promise.dbutil.exception.DaoException;
import com.promise.dbutil.service.QueryManager;
import com.promise.dbutil.support.PageSupport;

/**   
 * @类名: QueryManagerImpl.java 
 * @包名: com.promise.dbutil.service.impl 
 * @描述: hibernate查询使用服务类 
 * @作者: 邢健 xingjian@tongtusoft.com.cn   
 * @日期: 2011-12-6 上午10:57:40 
 * @版本 V1.0   
 */
@SuppressWarnings("all")
public class HibernateQueryManagerImpl<T extends Serializable> implements QueryManager<T>{

	private static final Logger logger = LoggerFactory.getLogger(HibernateQueryManagerImpl.class);
	
	private boolean cacheQueries = false;

	private String queryCacheRegion;
	
	private int fetchSize = 0;

	private int maxResults = 0;
	
	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	
	protected final Session getCurrentSession() {
	    return sessionFactory.getCurrentSession();
	}

    public HibernateQueryManagerImpl(){
        super();
    }

    public T load(Class entity, Serializable id) throws DaoException{
        try{
            return (T)getCurrentSession().load(entity, id);
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    public T get(Class entity, Serializable id) throws DaoException{
        try{
            return (T)getCurrentSession().get(entity, id);
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    public List<T> find(String hql) throws DaoException{
        try{
            return getCurrentSession().createQuery(hql).list();
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    public List find(String hql,Object parameter) throws DaoException{
        try{
        	Query query = getCurrentSession().createQuery(hql).setParameter(0, parameter);
        	return query.list();
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    public List find(String hql,Object[] parameters) throws DaoException{
        try{
        	Query query = getCurrentSession().createQuery(hql);
        	if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					query.setParameter(i, parameters[i]);
				}
			}
            return query.list();
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    public PageSupport find(final String hql,final int iPageNo,final int iPageSize) throws DaoException {
        return find(hql,(Object[]) null,iPageNo,iPageSize);
    }

    public PageSupport find(final String hql,final Object parameter,final int iPageNo,final int iPageSize) throws DaoException {
        return find(hql,new Object[]{parameter},iPageNo,iPageSize);
    }

    public PageSupport find(final String hql,final Object[] parameters,final int iPageNo,final int iPageSize) throws DaoException {
    	Query query = getCurrentSession().createQuery(hql);
        Query query_count = getCurrentSession().createQuery(parseSql(hql));
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i, parameters[i]);
                query_count.setParameter(i,parameters[i]);
            }
        }
        return buildPS(query,query_count,iPageNo,iPageSize);
    }

    public List findByNamedQuery(String namedQuery) throws DaoException {
        return findByNamedQuery(namedQuery,(Object[])null);
    }

    public List findByNamedQuery(String namedQuery,Object parameter) throws DaoException {
        return findByNamedQuery(namedQuery,new Object[]{parameter});
    }

    public List findByNamedQuery(String namedQuery,Object[] parameters) throws DaoException {
        try{
        	Query queryObject = getCurrentSession().getNamedQuery(namedQuery);
        	if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					queryObject.setParameter(i, parameters[i]);
				}
			}
			return queryObject.list();
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    public PageSupport findByNamedQuery(final String namedQuery, final int iPageNo,final int iPageSize) throws DaoException {
        return findByNamedQuery(namedQuery,(Object[]) null,iPageNo,iPageSize);
    }

    public PageSupport findByNamedQuery(final String namedQuery, final Object parameter,final int iPageNo,final int iPageSize) throws DaoException {
        return findByNamedQuery(namedQuery,new Object[] {parameter},iPageNo,iPageSize);
    }

    public PageSupport findByNamedQuery(final String namedQuery, final Object[] parameters,final int iPageNo,final int iPageSize) throws DaoException {
    	Query query = getCurrentSession().getNamedQuery(namedQuery);
        Query query_count = getCurrentSession().createQuery(parseSql(query.getQueryString()));
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i, parameters[i]);
                query_count.setParameter(i,parameters[i]);
            }
        }
        return buildPS(query,query_count,iPageNo,iPageSize);

    }

    protected void prepareCriteria(Criteria criteria){
    	criteria.setCacheable(true);
		criteria.setFirstResult(-1);
		criteria.setMaxResults(-1);
    }
    
    //根据查询条件返回查询结果
    public List find(final DetachedCriteria cw) throws DaoException {
        try{
        	Criteria executableCriteria = cw.getExecutableCriteria(getCurrentSession());
			prepareCriteria(executableCriteria);
			return executableCriteria.list();
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    //根据查询条件返回分页查询结果
    public PageSupport find(final DetachedCriteria cw,final int iPageNo,final int iPageSize) throws DaoException {
        return find(cw,(Order)null,iPageNo,iPageSize);
    }

    //根据查询条件和排序条件返回分页查询结果
    public PageSupport find(final DetachedCriteria cw,final Order order,final int iPageNo,final int iPageSize) throws DaoException {
        List ls=new ArrayList();
        if(order!=null){
            ls.add(order);
        }
        return find(cw,ls,iPageNo,iPageSize);
    }

    //根据查询条件和排序条件列表返回分页查询结果
    public PageSupport find(final DetachedCriteria cw,final List orders,final int iPageNo,final int iPageSize) throws DaoException {
    	 Criteria criteria = cw.getExecutableCriteria(getCurrentSession());
         return buildPS(criteria,orders,iPageNo,iPageSize);
    }

    //通过命名查询和命名参数获取数据列表

    public List findByNamedQuery(final String queryName, final Map paramMap) throws DaoException{
    	Query query = getCurrentSession().getNamedQuery(queryName);
        if (paramMap != null) {
            Iterator it=paramMap.keySet().iterator();
            while(it.hasNext()){
                String paramName = (String)it.next();
                Object paramValue=paramMap.get(paramName);
                applyNamedParameterToQuery(query, paramName, paramValue);
            }
        }
        // 返回
        return query.list();
    }

    public PageSupport findByNamedQuery(final String queryName, final Map paramMap,final int iPageNo,final int iPageSize) throws DaoException{
    	Query query = getCurrentSession().getNamedQuery(queryName);
        Query query_count = getCurrentSession().createQuery(parseSql(query.getQueryString()));
        if (paramMap != null) {
            Iterator it=paramMap.keySet().iterator();
            while(it.hasNext()){

                String paramName = (String)it.next();
                Object paramValue=paramMap.get(paramName);

                applyNamedParameterToQuery(query, paramName, paramValue);
                applyNamedParameterToQuery(query_count,paramName,paramValue);
            }
        }
        // 返回
        return buildPS(query,query_count,iPageNo,iPageSize);
    }

    private PageSupport buildPS(Query query,Query queryCount,int iPageNo,int iPageSize){
        PageSupport ps = new PageSupport();
        ps.setPageNo(iPageNo);
        ps.setPageSize(iPageSize);
        Object result = queryCount.iterate().next();
        if(result instanceof Integer){
            ps.setRecTotal(((Integer)result).intValue());
        }
        if(result instanceof Long){
            ps.setRecTotal(((Long)result).intValue());
        }
        query.setFirstResult((iPageNo-1)*iPageSize);
        query.setMaxResults(iPageSize);
        ps.setList(query.list());
        return ps;
    }

    private PageSupport buildPS(Criteria criteria,List orders,int iPageNo,int iPageSize){
        PageSupport ps=new PageSupport();
        ps.setPageNo(iPageNo);
        ps.setPageSize(iPageSize);
        List orderEntrys = null;
        Field field = null;
        try{
            CriteriaImpl impl = (CriteriaImpl)criteria;
            field = CriteriaImpl.class.getDeclaredField("orderEntries");
            field.setAccessible(true);
            orderEntrys = (List)field.get(impl);
            field.set(criteria,new ArrayList());
        }catch(Exception e){
        	logger.error(e.getMessage());
        }
        int rectotal = ((Integer)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        criteria.setProjection(null);
        criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        ps.setRecTotal(rectotal);
        //再恢复Order部分
        try{
            if(orderEntrys!=null){
                List innerOrderEntries = (List)field.get(criteria);
                for(int i=0;i<orderEntrys.size();i++){
                    innerOrderEntries.add(orderEntrys.get(i));
                }
            }
        }catch(Exception e){
        	logger.error(e.getMessage());
        }

        //为了兼容以前的实现
        if(orders!=null){
            for(int i=0;i<orders.size();i++){
                criteria.addOrder((Order)orders.get(i));
            }
        }

        criteria.setFirstResult((iPageNo - 1) * iPageSize);
        criteria.setMaxResults(iPageSize);
        ps.setList(criteria.list());
        return ps;
    }
    //用于获取记录总数,修改hql,加上count(*)
    protected String parseSql(String queryString){
        //去掉硬回车和缩进字符
        queryString=queryString.replaceAll("\n", " ");
        queryString=queryString.replaceAll("\t", " ");

        //去掉order by
        int iOrderIndex=queryString.toLowerCase().indexOf(" order by ");
        if(iOrderIndex>0){
            queryString=queryString.substring(0,iOrderIndex);
        }

        StringBuffer sb = new StringBuffer();

        if (queryString.trim().toLowerCase().indexOf("select ") == 0) {
            int t=0;
            //处理有子查询的情况
            int i=queryString.trim().toLowerCase().lastIndexOf(" as ");
            if(i > 0){
                //主from位置
                t=queryString.toLowerCase().indexOf(" from ",i);
            }else{
                t = queryString.toLowerCase().indexOf(" from ");
            }

            sb.append("SELECT COUNT(*) ");
            sb.append(queryString.substring(t));

        } else {
            sb.append("SELECT COUNT(*) ");
            sb.append(queryString);
        }
        return sb.toString();
    }

    protected void applyNamedParameterToQuery(Query queryObject, String paramName, Object paramValue){
        if (paramValue instanceof Collection) {
            queryObject.setParameterList(paramName, (Collection) paramValue);
        }
        else if (paramValue instanceof Object[]) {
            queryObject.setParameterList(paramName, (Object[]) paramValue);
        }
        else {
            queryObject.setParameter(paramName, paramValue);
        }
    }

	@Override
	public List findBySql(final String sql) {
		return getCurrentSession().createSQLQuery(sql).list();
	}

}