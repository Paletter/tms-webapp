package com.palette.busi.project.tms.web.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.palette.busi.project.tms.web.util.JDBCUtils;
import com.palette.busi.project.tms.web.util.SpringContextUtils;

public class MyPropertyPlaceholderConfigurerExt extends PropertyPlaceholderConfigurer {
	private static MyPropertyPlaceholderConfigurerExt propertyPlaceholderConfigurer = null;

    private static Map<String, Object> ctxPropertiesMap;
    
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            return JDBCUtils.encrypt(propertyValue);
        } else {
            return propertyValue;
        }
    }
 
    /**
     * 判断是否是加密的属性
     * 
     * @param propertyName
     * @return
     */
    private boolean isEncryptProp(String propertyName) {
    	if("jdbc.password".equals(propertyName)) return true;
        return false;
    }
    
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
    	
        super.processProperties(beanFactoryToProcess, props);
        ctxPropertiesMap = new HashMap<String, Object>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
        }
    }

    public String getContextProperty(String name) {
        return (String) ctxPropertiesMap.get(name);
    }

    public static MyPropertyPlaceholderConfigurerExt getInstance() {
        if (propertyPlaceholderConfigurer == null) {
            propertyPlaceholderConfigurer = (MyPropertyPlaceholderConfigurerExt) SpringContextUtils.getBean("propertyPlaceholderConfigurer");
        }
        return propertyPlaceholderConfigurer;
    }
}

