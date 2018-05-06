package com.test.modules.repository.util;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import com.test.modules.model.AbstractModel;

@Singleton
public class MapRepository {

	private Map<Class<? extends AbstractModel>, Map<Long, AbstractModel>> map;
	
	{
		this.map = new HashMap<>();
	}
	
	public Map<Long, AbstractModel> getMap(Class<? extends AbstractModel> clazz) {
		
		if (!this.map.containsKey(clazz)) {
			this.map.put(clazz, new HashMap<>());
		}
		
		return map.get(clazz);
	}
}
