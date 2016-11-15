package com.faceye.component.cache.service;


public interface CacheService {

	  /**
     * 删除 缓存
     * @param key
     * @return
     * @throws Exception
     */
    public void deleteCached(String key)throws Exception;
    /**
     * 更新 缓存
     * @param key
     * @param value
     * @param expire
     * @return
     * @throws Exception
     */
    public void saveCached(String key,Object value,long expire)throws Exception;
    /**
     * 获取缓存
     * @param key
     * @return
     * @throws Exception
     */
   public  Object getCached(String key)throws Exception;
}
