package marvel.com.marvel.settings.security.jwt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.management.relation.Role;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import marvel.com.marvel.entities.Privilege;
import marvel.com.marvel.entities.UserEntity;
import marvel.com.marvel.exceptions.MarvelException;
import marvel.com.marvel.repositories.PrivilegeRepository;
import marvel.com.marvel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;
    private final UserRepository userRepository;
    private final Privilege roleRepository;
    private final PrivilegeRepository privilegeRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }
}