package com.faceye.component.cache.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
/**
 * 缓存工具类
 * @author haipenge
 *
 */
public class CacheUtils {

	private CacheUtils() {

	}

	static class CacheUtilsHolder {
		static CacheUtils INSTANCE = new CacheUtils();
	}

	public static CacheUtils getInstance() {
		return CacheUtilsHolder.INSTANCE;
	}

	/**
	 * 构建缓存Key
	 * 
	 * @return
	 * @Desc:
	 * @Author:haipenge
	 * @Date:2016年6月14日 下午2:08:29
	 */
	public String buildKey(Serializable seed) {
		String key = "";
		if (seed != null) {
			key = seed.toString();
		}
		return key;
	}

	public String buildKey(String prefix, Serializable seed) {
		String key = "";
		key += prefix;
		if (seed != null) {
			key = buildKey(key + "_" + seed.toString());
		}
		return key;
	}

	public String buildKey(String prefix, Map params) {
		String key = "";
		key += prefix+"_";
		if (MapUtils.isNotEmpty(params)) {
			Iterator it = params.keySet().iterator();
			List<String> keys = new ArrayList<String>();
			while (it.hasNext()) {
				keys.add(it.next().toString());
			}
			Collections.sort(keys);
			for (String k : keys) {
				key += k;
				key += MapUtils.getString(params, k);
				key += "-";
			}
			if (StringUtils.length(key) > 255) {
				key = StringUtils.substring(key, 0, 254);
			}
		}
		return key;
	}

	/**
	 * 构建列表的缓存key
	 * 
	 * @todo
	 * @param params
	 * @param page
	 * @param size
	 * @return
	 * @author:@haipenge haipenge@gmail.com 2015年4月8日
	 */
	public String buildPageCacheKey(Map params, int page, int size) {
		String key = "";
		if (MapUtils.isEmpty(params)) {
			params = new HashMap();
		}
		params.put("page", "" + page);
		params.put("size", "" + size);
		key = this.buildKey("LIST", params);
		return key;
	}
}
