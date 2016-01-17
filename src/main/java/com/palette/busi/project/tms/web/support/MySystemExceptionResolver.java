package com.palette.busi.project.tms.web.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.web.exception.BusinessException;
import com.palette.busi.project.tms.web.exception.LoginException;
import com.palette.busi.project.tms.web.vo.ViewJsonVo;

public class MySystemExceptionResolver implements HandlerExceptionResolver {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
		
		if(exception != null) {
			if(exception instanceof BusinessException
			   || exception instanceof BusinessException) {
				
				// Return business error json result
				logger.info(exception.getMessage(), exception);
				ViewJsonVo jsonVo = new ViewJsonVo(null, exception.getMessage(), ViewJsonVo.STATUS_BUSINESS_EXCEPTION);
				return new ModelAndView().addObject(jsonVo);
			} else if(exception instanceof LoginException) {
				
				// Return login auth error json result
				logger.info(exception.getMessage(), exception);
				ViewJsonVo jsonVo = new ViewJsonVo(null, exception.getMessage(), ViewJsonVo.STATUS_LOGIN_EXCEPTION);
				return new ModelAndView().addObject(jsonVo);
			} else {
				
				// Return system error json result
				logger.info(exception.getMessage(), exception);
				String error = StringUtils.isNullOrEmpty(exception.getMessage()) ? exception.getClass().getSimpleName() : exception.getMessage();
				ViewJsonVo jsonVo = new ViewJsonVo(null, error, ViewJsonVo.STATUS_SYSTEM_EXCEPTION);
				return new ModelAndView().addObject(jsonVo);
			}
		}
		
		return null;
	}

}
