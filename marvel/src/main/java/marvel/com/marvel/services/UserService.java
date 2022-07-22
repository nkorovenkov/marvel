package marvel.com.marvel.services;

import lombok.RequiredArgsConstructor;
import marvel.com.marvel.entities.UserEntity;
import marvel.com.marvel.exceptions.MarvelException;
import marvel.com.marvel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {

    private final UserRepository userRepository;

    public UserEntity getUserEntityByUsername(String username) {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new MarvelException(HttpStatus.NOT_FOUND, "Cannot find user with username = " + username));
    }

    public UserEntity getCurrentUser() {
        return getUserEntityByUsername(getCurrentUsername());
    }

    private String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            Object object = authentication.getPrincipal();
            if (object instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) object;
                if (userDetails.getUsername() != null) {
                    return userDetails.getUsername();
                }
            }
        }
        throw new MarvelException(HttpStatus.FORBIDDEN, "Can't find the current user");
    }
}
