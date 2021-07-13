package pl.ts.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.ts.model.User;

import java.net.UnknownServiceException;

@Component
@SessionScope
public class SessionObject {
    private User user = null;
    private String info = null;

    public SessionObject() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void logoutUser(){
        this.user = null;
    }

    public boolean isLogged(){
        return this.user != null;
    }

    public String getInfo() {
        String temp = this.info;
        this.info = null;
        return temp;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
