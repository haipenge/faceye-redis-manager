package com.faceye.test.component.cache.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

import com.faceye.component.cache.service.CacheService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class CacheServiceTestCase {
    
	@Autowired
	private CacheService cacheService=null;
	@Test
	public void testGetUsers() throws Exception{
		//List users=this.cacheService.getUsers();
		//Assert.assertTrue(CollectionUtils.isNotEmpty(users));
	}
	@Test
	public void testGetUser() throws Exception{
		//Map user= this.cacheService.getUser("a");
		//Assert.assertTrue(MapUtils.isNotEmpty(user));
	}
}
