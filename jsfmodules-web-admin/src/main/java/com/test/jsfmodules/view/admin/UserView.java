package com.test.jsfmodules.view.admin;

import com.test.modules.model.User;
import com.test.modules.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UserView implements Serializable {

	private static final long serialVersionUID = -3923519158948460677L;

	@Inject
    private UserRepository userRepository;

    private List<User> users;

    private User user;

    @PostConstruct
    public void init() {
        list();
        this.user = new User();
    }

    private void list() {
        this.users = userRepository.list();
    }

    public void newUser() {
        this.user = new User();
    }

    public void confirmNewUser() {
        userRepository.save(user);
        this.user = null;
        list();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
