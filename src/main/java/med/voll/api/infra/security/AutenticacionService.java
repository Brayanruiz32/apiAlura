package med.voll.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import med.voll.api.domain.usuario.UsuarioRepository;

@Service
public class AutenticacionService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repositorio;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = repositorio.findByLogin(username);
        return user;
    }



}
