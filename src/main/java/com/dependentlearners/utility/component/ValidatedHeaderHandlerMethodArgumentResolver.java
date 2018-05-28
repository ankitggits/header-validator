package com.dependentlearners.utility.component;

import com.dependentlearners.utility.annotation.ValidatedHeader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Slf4j
public class ValidatedHeaderHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	String headerName;
	String regex;
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		 ValidatedHeader header = parameter.getParameterAnnotation(ValidatedHeader.class);
		 if(header!=null){
			 regex = header.regex();
			 headerName = header.name();
			 return true;
		 }
		 return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String headerValue = webRequest.getHeader(headerName);
		if(!headerValue.matches(regex)){
			log.error("header does not match");
			throw new RuntimeException(headerName+" -> Header not matched");
		}
		return headerValue;
	}

}
