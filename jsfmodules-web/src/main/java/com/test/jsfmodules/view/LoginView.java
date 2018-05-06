package com.test.jsfmodules.view;

import com.test.jsfmodules.session.UserSession;
import com.test.modules.model.User;
import com.test.modules.repository.UserRepository;

import javax.enterprise.inject.spi.CDI;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Optional;

@Named
@ViewScoped
public class LoginView extends BaseView implements Serializable {

	private static final long serialVersionUID = 8833158716417428583L;

	private String login;
    private String password;

    @Inject
    private UserRepository userRepository;

    public String authenticate() {
        Optional<User> user = userRepository.findByLogin(this.login);

        if (user.isPresent()) {

            UserSession userSession = CDI.current().select(UserSession.class).get();
            userSession.setUser(user.get());

            return "/pages/home.xhtml";
        }

        return null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
