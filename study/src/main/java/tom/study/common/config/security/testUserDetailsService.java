package tom.study.common.config.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class testUserDetailsService implements UserDetailsService {

    private final List<User> userList;

    public testUserDetailsService(List<User> userList) {
        this.userList = userList;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userList.stream().filter(user -> user.getUsername().equals(username))
                .findFirst().orElseThrow(() -> new UsernameNotFoundException("User not found Exception"));
    }
}
