package com.faceye.component.cache.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.faceye.component.cache.service.CacheExampleService;

@Service
public class CacheExampleServiceImpl implements CacheExampleService {
	org.springframework.data.redis.cache.RedisCacheManager s=null;
	@Override
	public List getUsers() {
		List users = new ArrayList();
		for (int i = 0; i < 100; i++) {
			users.add("user-" + i);
		}
		return users;
	}

}
