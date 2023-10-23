package br.edu.utfpr.pb.pw25s.server.service;

import br.edu.utfpr.pb.pw25s.server.model.User;
import br.edu.utfpr.pb.pw25s.server.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }

        return user;
    }

    public UserDetails loadUserByUsernameAndToken(String email, String token) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmailAndToken(email, token);

        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }

        return user;
    }

    @Transactional
    public void updateUserToken(Long userId, String token) {
        userRepository.updateUserTokenById(userId, token);
    }
}
