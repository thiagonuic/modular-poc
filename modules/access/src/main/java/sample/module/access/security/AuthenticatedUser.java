package sample.module.access.security;

import com.vaadin.flow.spring.security.AuthenticationContext;
import sample.module.access.data.User;
import sample.module.access.data.UserRepository;
import java.util.Optional;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AuthenticatedUser {

    private final UserRepository userRepository;
    private final AuthenticationContext authenticationContext;

    public AuthenticatedUser(AuthenticationContext authenticationContext, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.authenticationContext = authenticationContext;
    }

    @Transactional
    public Optional<User> get() {
        return authenticationContext
                .getAuthenticatedUser(Jwt.class)
                .map(userDetails -> userRepository.findByUsername(userDetails.getSubject()));
    }

    public void logout() {
        authenticationContext.logout();
    }
}
