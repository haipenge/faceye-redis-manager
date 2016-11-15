package com.faceye.component.cache.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

import com.faceye.feature.util.ServiceException;

/**
 * Redis 基础服务
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年4月12日
 */

public interface RedisService<K, V> {
	/**
	 * 取得Redis模板
	 * @todo
	 * @return
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2015年4月7日
	 */
	public RedisTemplate<K, V> getRedisTemplate();

	/**
	 * 设置List
	 * @todo
	 * @param key
	 * @param values
	 * @throws ServiceException
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年4月13日
	 */
	public void rPush(K key, List<V> values);

	/**
	 * 设置一个值
	 * @todo
	 * @param key
	 * @param value
	 * @throws ServiceException
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年4月13日
	 */
	public void rPush(K key, V value);

	/**
	 * 读取list
	 * @todo
	 * @param key
	 * @return
	 * @throws ServiceException
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年4月13日
	 */
	public List<V> getList(K key);

	/**
	 * 设置 key:value
	 * @todo
	 * @param key
	 * @param value
	 * @throws ServiceException
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年4月13日
	 */
	public void set(K key, V value);
	
	/**
	 * 设置有过期时间的K:V结构
	 * @todo
	 * @param key
	 * @param value
	 * @param expireTime
	 * @param timeUnit
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2015年4月8日
	 */
	public void set(K key,V value,long timeout,TimeUnit unit);

	/**
	 * 取值
	 * @todo
	 * @param key
	 * @return
	 * @throws ServiceException
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年4月13日
	 */
	public V get(K key);

	/**
	 * 是否存在某一Key.
	 * @todo
	 * @param key
	 * @return
	 * @throws ServiceException
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年4月14日
	 */
	public Boolean exist(K key);

	/**
	 * 取得Key列表
	 * @todo
	 * @param pattern
	 * @return
	 * @throws ServiceException
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年4月14日
	 */
	public Set<K> getKeys(K pattern);

	/**
	 * 清除缓存
	 * @todo
	 * @param key
	 * @throws ServiceException
	 * @author:@haipenge
	 * haipenge@gmail.com
	 * 2014年5月7日
	 */
	public void delete(K key);
}
