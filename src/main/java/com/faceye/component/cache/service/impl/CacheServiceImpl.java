package com.faceye.component.cache.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faceye.component.cache.service.CacheService;
import com.faceye.component.cache.service.RedisService;

/**
 * 缓存管理 
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年10月18日
 */
@Service
public class CacheServiceImpl implements CacheService {
	@Autowired
	private RedisService redisService = null;

	@Override
	public void deleteCached(String key) throws Exception {
		this.redisService.delete(key);
	}

	@Override
	public void saveCached(String key, Object value, long expire) throws Exception {
		this.redisService.set(key, value, expire, TimeUnit.SECONDS);
	}

	@Override
	public Object getCached(String key) throws Exception {
		return this.redisService.get(key);
	}

}
