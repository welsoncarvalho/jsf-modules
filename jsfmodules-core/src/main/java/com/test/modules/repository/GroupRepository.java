package com.test.modules.repository;

import java.io.Serializable;

import com.test.modules.model.Group;

public class GroupRepository extends AbstractRepository<Group> implements Serializable {

	private static final long serialVersionUID = 8660378500802861584L;
	
	{
        init(Group.class);
    }

}
