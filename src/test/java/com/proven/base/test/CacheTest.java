package com.proven.base.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:spring-cache.xml","classpath:application.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CacheTest {
	
	
}
