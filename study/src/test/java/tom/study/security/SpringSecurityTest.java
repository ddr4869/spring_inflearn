package tom.study.security;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import tom.study.common.config.security.UserDetailsServiceImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@Slf4j
public class SpringSecurityTest {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @Test
    public void securityTest1() {
        UserDetails userDetails = userDetailsService.loadUserByUsername("richard");
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        log.info("authorities: {}", authorities.toString());
        if (authorities.stream().anyMatch(authority -> authority.getAuthority().equals("SUPER"))) {
            log.info("현재 사용자 {}는 'SUPER' 권한이 있습니다.", userDetails.getUsername());
        } else {
            log.info("현재 사용자 {}는 'SUPER' 권한이 없습니다.", userDetails.getUsername());
        }
    }

    @Test
    public void securityTest2() {
        Authentication authToken = new UsernamePasswordAuthenticationToken("tom2", "1234");
        SecurityContextHolder.getContext().setAuthentication(authToken);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        log.info("authorities: {}", authorities.toString());
        if (authorities.stream().anyMatch(authority -> authority.getAuthority().equals("SUPER"))) {
            log.info("현재 사용자 {}는 'SUPER' 권한이 있습니다.", authentication.getName());
        } else {
            log.info("현재 사용자 {}는 'SUPER' 권한이 없습니다.", authentication.getName());
        }
    }
}
