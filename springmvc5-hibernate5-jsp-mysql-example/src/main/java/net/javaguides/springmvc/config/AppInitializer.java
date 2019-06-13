package net.javaguides.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Ramesh Fadatare
 * AbstractAnnotationConfigDispatcherServletInitializer
 * 会同时配置 DispatcherServlet和ContextLoaderListener
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppContext.class };
		//return null;
	}
 /**
  * getServletConfigClasses
  * 由DispatcherServlet来创建 应用长下文child
  * 包含：control、HandlerMapping、ViewReslover
  * */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}
 
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
 
}