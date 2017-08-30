package com.servifact.app.service;

import com.servifact.app.dao.EmisorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by __Adrian__ on 24/8/2017.
 */

@Service
public class EmisorService implements UserDetailsService {
//   @Autowired
//   private EmisorDao emisorDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
//        user = emisorDao.buscarEmisor(username);
//
        if (s != null) {
//            Set<UsuarioRol> usuarioRoles = usuarioRolDao.listaRolesUsuario(user.getIdUsuario());
        List<GrantedAuthority> authorities = buildUserAuthority();
//
    return buildUserForAuthentication(authorities);
    } else {
            throw new UsernameNotFoundException("NO HAY");

     }

    }
    private List<GrantedAuthority> buildUserAuthority() {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

            setAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));


        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }
    private UserDetails buildUserForAuthentication( List<GrantedAuthority> authorities) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordencoder = passwordEncoder.encode("abcde");

        return new User("adrian",passwordencoder, true, true, true, true, authorities);
    }

}
