package com.faceye.component.cache.service.impl;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.faceye.component.cache.service.RedisService;
 


/**
 * Redis基础服务
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年4月12日
 */
@Service
public class RedisServiceImpl<K , V> implements RedisService<K, V> {
	@Autowired
	private RedisTemplate redisTemplate = null;
	@Override
	public RedisTemplate<K, V> getRedisTemplate() {
		return redisTemplate;
	}

	/**
	 * 存储list结构
	 * @todo
	 * @param key
	 * @param value
	 * @ 
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年4月13日
	 */
	public void rPush(K key, V value)  {
		this.getRedisTemplate().boundListOps(key).rightPush(value);
	}

	public void rPush(K key, List<V> values)  {
		if (key != null && CollectionUtils.isNotEmpty(values)) {
			for (V value : values) {
				this.rPush(key, value);
			}
		}
	}

	public List<V> getList(K key){
		List res = null;
		res = this.getRedisTemplate().boundListOps(key).range(0, -1);
		return res;
	}

	@Override
	public void set(K key, V value) {
		this.getRedisTemplate().opsForValue().set(key, value);
	}
	
	@Override
	public void set(K key, V value, long timeout, TimeUnit unit) {
		this.redisTemplate.opsForValue().set(key, value, timeout, unit);
	}

	@Override
	public V get(K key) {
		V o = this.getRedisTemplate().opsForValue().get(key);
		return o == null ? null : o;
	}

	@Override
	public Boolean exist(K key) {
		return this.redisTemplate.hasKey(key);
	}

	@Override
	public Set<K> getKeys(K pattern) {
		return this.redisTemplate.keys(pattern);
	}
	@Override
	public void delete(K key) {
		this.redisTemplate.delete(key);
	}

}
