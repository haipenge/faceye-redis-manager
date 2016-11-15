package com.faceye.test.component.cache.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.faceye.component.cache.service.CacheExampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class CacheExampleServiceTestCase {
	@Autowired
	private CacheExampleService cacheExampleService = null;

	@Test
	public void testGetUsers() throws Exception {
		List users = this.cacheExampleService.getUsers();
		Assert.isTrue(CollectionUtils.isNotEmpty(users));
	}
}
