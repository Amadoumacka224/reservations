package be.iccbxl.pid.reservationsspringboot.config;

import be.iccbxl.pid.reservationsspringboot.model.User;
import be.iccbxl.pid.reservationsspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import be.iccbxl.pid.reservationsspringboot.model.Role;
import be.iccbxl.pid.reservationsspringboot.model.User;
import be.iccbxl.pid.reservationsspringboot.repository.UserRepository;
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec le login: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
<<<<<<< HEAD
                username,
                user.getPassword(),
                getGrantedAuthorities(user.getRole().toString()));
=======
                user.getLogin(),
                user.getPassword(),
                getGrantedAuthorities(user.getRoles()));
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
<<<<<<< HEAD
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        return authorities;
    }

}
=======

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }

        return authorities;
    }
}
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
