package com.palette.busi.project.tms.web.support;

import java.io.IOException;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.web.vo.ViewJsonVo;

public class MyJacksonHttpMessageConverter extends MappingJacksonHttpMessageConverter {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String jsonPrefix;
	
	@Override
	protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		
		JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
		JsonGenerator jsonGenerator = super.getObjectMapper().getJsonFactory().createJsonGenerator(outputMessage.getBody(), encoding);

		if (super.getObjectMapper().getSerializationConfig().isEnabled(SerializationConfig.Feature.INDENT_OUTPUT)) {
			jsonGenerator.useDefaultPrettyPrinter();
		}

		try {
			
			if (this.jsonPrefix != null) {
				jsonGenerator.writeRaw(this.jsonPrefix);
			}
			
			if(object instanceof ViewJsonVo){
				
				// Return ViewJsonVo
				super.getObjectMapper().writeValue(jsonGenerator, object);
			} else if(object instanceof PageInfo){
				
				// Return PageInfo
				PageInfo pageInfo = (PageInfo) object;
				
				ViewJsonVo jsonVo = new ViewJsonVo();
				jsonVo.setResult(pageInfo.getData());
				jsonVo.setPageInfo(pageInfo.getPageInfo());
				super.getObjectMapper().writeValue(jsonGenerator, jsonVo);
			} else {
				
				// Return Others
				ViewJsonVo jsonVo = new ViewJsonVo(object);
				super.getObjectMapper().writeValue(jsonGenerator, jsonVo);
			}
			
		} catch (JsonProcessingException ex) {
			
			logger.info("Could not write JSON: " + ex.getMessage());
			throw new HttpMessageNotWritableException("返回结果显示错误，请联系管理员。 ", ex);
		}
	}
	
}
