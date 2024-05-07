package sample.module.access.services;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import sample.module.access.data.User;
import sample.module.access.security.AuthenticatedUser;

import java.util.Optional;

@BrowserCallable
@AnonymousAllowed
public class UserEndpoint {

    private final AuthenticatedUser authenticatedUser;

    public UserEndpoint(AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }

    public Optional<User> getAuthenticatedUser() {
        return authenticatedUser.get();
    }
}
