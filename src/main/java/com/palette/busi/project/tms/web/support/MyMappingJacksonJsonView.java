package com.palette.busi.project.tms.web.support;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.palette.busi.project.tms.web.vo.ViewJsonVo;

public class MyMappingJacksonJsonView extends MappingJacksonJsonView {
	
    protected Object filterModel(final Map<String, Object> model) {
        Object result = super.filterModel(model);
        if(result instanceof Map){
        	Map<?, ?> mapResult = (Map<?, ?>) result;
        	if (mapResult.size() == 1) {
            	Object resultModel = mapResult.values().iterator().next();
            	if(resultModel instanceof List){
            		return resultModel;
            	}else if(resultModel instanceof ViewJsonVo){
            		return resultModel;
            	}else{
                    return mapResult;
            	}
            } else {
                return mapResult;  
            }
        }else if(result instanceof ViewJsonVo){
        	return result;  
        }else{
        	return new ViewJsonVo(result);
        }
    }
}
