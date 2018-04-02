package com.faceye.test.component.cache.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

import com.faceye.component.cache.service.RedisService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class RedisServiceTestCase {

	@Autowired
	private RedisService redisService = null;

	private SetObject setObject = null;
	private String key=null;

	@Before
	public void set() throws Exception {
		setObject = new SetObject();
		setObject.setId(System.currentTimeMillis());
		setObject.setName("Test-Set-Object");
		key="set-test";
	}

	@Test
	public void testGetKeys() throws Exception {
		Set<String> keys = redisService.getKeys("*");
		SetObject o = (SetObject)this.redisService.get("t");
		Assert.assertTrue(null != keys && keys.size() > 0);
	}

	@Test
	public void testSet() throws Exception {
		List<SetObject> values=new ArrayList<SetObject>();
		values.add(setObject);
		this.redisService.set(key, values);
		List set = (List)this.redisService.get(key);
		Assert.assertTrue(set != null);
	}

	@Test
	public void testSetWithTimeout() throws Exception {
		this.redisService.set(key, setObject, 30, TimeUnit.SECONDS);
		SetObject set = (SetObject)this.redisService.get(key);
		Assert.assertTrue(set != null);
	}

	@Test
	public void testDelete() throws Exception{
		this.redisService.delete(key);
		Assert.assertTrue(null==this.redisService.get(key));
	}

}
