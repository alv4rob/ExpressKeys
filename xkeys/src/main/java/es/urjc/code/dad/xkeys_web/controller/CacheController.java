package es.urjc.code.dad.xkeys_web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
	
	@Autowired
	private CacheManager cacheManager;
		
	@RequestMapping(value="/cache-productos", method=RequestMethod.GET)
	public Map<Object, Object> getCacheProductosContent() {
		ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("productos");
		
		return cache.getNativeCache();
	}	
	
	@RequestMapping(value="/cache-clientes", method=RequestMethod.GET)
	public Map<Object, Object> getCacheClientesContent() {
		ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("clientes");
		return cache.getNativeCache();
	}
	
}
