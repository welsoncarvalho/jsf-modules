package com.test.jsfmodules.listener;

import javax.enterprise.inject.spi.CDI;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.test.modules.model.Group;
import com.test.modules.model.User;
import com.test.modules.repository.util.MapRepository;

@WebListener
public class StartMapDataListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		initGroup();
		initUser();
	}
	
	private void initUser() {
		
		User user = new User();
        user.setId(1L);
        user.setName("Admin");
        user.setGender("M");
        user.setDocument("12345678909");
        user.setLogin("admin");
        user.setPassword("admin");
        
        getMapRepository().getMap(User.class).put(user.getId(), user);
	}
	
	private void initGroup() {
		
		Group group = new Group();
        group.setId(1L);
        group.setName("Administrator");
        
        getMapRepository().getMap(Group.class).put(group.getId(), group);
	}
	
	private MapRepository getMapRepository() {
		return CDI.current().select(MapRepository.class).get();
	}

}
