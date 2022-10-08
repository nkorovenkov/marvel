package marvel.com.marvel.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Privilege implements GrantedAuthority {
    ROLE_USER,
    ROLE_MODERATOR,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return null;
    }
}
