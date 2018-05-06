package com.test.jsfmodules.view;

import com.test.jsfmodules.session.UserSession;
import com.test.modules.model.User;

import javax.enterprise.inject.spi.CDI;

public abstract class BaseView {

    public User getUserSession() {
        UserSession userSession = CDI.current().select(UserSession.class).get();
        return userSession.getUser();
    }

}
