package ru.netolody.servisavtorization.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<Authorities> userRights = new ArrayList<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        String bdPassword = "admin";
        String bdUser = "admin";

        if (user.equals(bdUser) && password.equals(bdPassword)) {
            userRights.add(Authorities.READ);
            userRights.add(Authorities.WRITE);
            userRights.add(Authorities.DELETE);
        }
        return userRights;
    }
}