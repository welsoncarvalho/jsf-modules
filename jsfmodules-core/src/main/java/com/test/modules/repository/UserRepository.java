package com.test.modules.repository;

import com.test.modules.model.User;

import java.io.Serializable;
import java.util.*;

public class UserRepository extends AbstractRepository<User> implements Serializable {

	private static final long serialVersionUID = 1057089732489651118L;
	
    {
        init(User.class);
    }
    
    public Optional<User> findByLogin(String login) {
        return getMap().values().stream().filter(
                u -> u.getLogin().equals(login)).findFirst();
    }

}
