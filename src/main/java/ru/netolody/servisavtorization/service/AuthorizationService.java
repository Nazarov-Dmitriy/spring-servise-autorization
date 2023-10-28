package ru.netolody.servisavtorization.service;

import ru.netolody.servisavtorization.advice.InvalidCredentials;
import ru.netolody.servisavtorization.advice.UnauthorizedUser;
import ru.netolody.servisavtorization.repository.Authorities;
import ru.netolody.servisavtorization.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    UserRepository userRepository = new UserRepository();

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
