package com.palette.busi.project.tms.core.base.dao;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.support.PersistenceExceptionTranslator;
/**
 * SqlSessionTemplate不适合在spring容器中被创建和管理，因为sqlSessionTemplate实现了java.lang.AutoCloseable接口，
 * 所有该接口的实现类，Spring都会自动查找是否存在close方法并调用它，而sqlSessionTemplate的close方法被禁用，这个调用就
 * 会报错，因此，我们要在自己创建SqlSessionTemplate，把它放在一个SqlSessionTemplateHolder中，
 * 让SqlSessionTemplateHolder成为Spring管理的bean，需要SqlSessionTemplate的时候从SqlSessionTemplateHolder
 * 中获取即可，这样就避免了spring容器对SqlSessionTemplate的close方法的调用。
 * @author 王立
 *
 */
public class SqlSessionTemplateHolder {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public SqlSessionTemplateHolder(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionTemplate=new SqlSessionTemplate(sqlSessionFactory);
    }
	public SqlSessionTemplateHolder(SqlSessionFactory sqlSessionFactory, ExecutorType executorType) {
		this.sqlSessionTemplate=new SqlSessionTemplate(sqlSessionFactory,executorType);
	}
	public SqlSessionTemplateHolder(SqlSessionFactory sqlSessionFactory, ExecutorType executorType,
		      PersistenceExceptionTranslator exceptionTranslator) {
		this.sqlSessionTemplate=new SqlSessionTemplate(sqlSessionFactory,executorType,exceptionTranslator);
	}
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}
		 
}
