package com.test.modules.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.test.modules.model.AbstractModel;
import com.test.modules.repository.util.MapRepository;

public abstract class AbstractRepository<M extends AbstractModel> {

	@Inject
	private MapRepository mapRepository;
	
	private Class<? extends AbstractModel> clazz;
	
	protected void init(Class<? extends AbstractModel> clazz)  {
		this.clazz = clazz;
	}
	
	public List<M> list() {
        return new ArrayList<>(getMap().values());
    }
	
	public void save(M m) {
        if (m.getId() == null) {
            m.setId((long) (getMap().size() + 1));

        } else {

            getMap().remove(m.getId());
        }

        getMap().put(m.getId(), m);
    }
	
	@SuppressWarnings("unchecked")
	protected Map<Long, M> getMap() {
		return (Map<Long, M>) this.mapRepository.getMap(this.clazz);
	}
	
}
