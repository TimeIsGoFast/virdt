/**  
* @Title: TestPropertyUtil.java  
* @Package com.proven.base.test.util  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Administrator  
* @date 2019年4月4日  
* @version V1.0  
*/ 
package com.proven.base.test.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import com.proven.utils.PropertyUtil;

/**  
* @ClassName: TestPropertyUtil  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author Administrator  
* @date 2019年4月4日  
*    
*/
public class TestPropertyUtil {
	@Test
	public void TestGetValueFromProperties() throws IOException{
		
		Properties props = new Properties();
		InputStream in = TestPropertyUtil.class.getClassLoader().getResourceAsStream("properties/virdt.properties");
		props.load(in);
		String value = props.getProperty("service.url");
		//String value = PropertyUtil.getProperty("service.url");
      
		assertEquals("http://192.168.20.9/Citrix/Monitor/OData/v1/Data",value);
		
	}
	
	@Test
	public void testGetDataUseUtil(){
		String value = PropertyUtil.getProperty("service.url");
		assertEquals("http://192.168.20.9/Citrix/Monitor/OData/v1/Data",value);
	}
}
