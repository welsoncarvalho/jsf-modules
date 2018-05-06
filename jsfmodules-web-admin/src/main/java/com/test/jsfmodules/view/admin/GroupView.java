package com.test.jsfmodules.view.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.test.modules.model.Group;
import com.test.modules.repository.GroupRepository;

@Named
@ViewScoped
public class GroupView implements Serializable {

	private static final long serialVersionUID = -5083845023981687993L;
	
	@Inject
	private GroupRepository groupRepository;
	
	private List<Group> groups;
	
	private Group group;
	
	@PostConstruct
	public void init() {
		list();
	}
	
	private void list() {
		this.groups = groupRepository.list();
	}
	
	public void newGroup() {
		this.group = new Group();
	}
	
	public void confirmNewGroup() {
		groupRepository.save(this.group);
		this.group = null;
		
		list();
	}
	
	public List<Group> getGroups() {
		return groups;
	}
	
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}

}
