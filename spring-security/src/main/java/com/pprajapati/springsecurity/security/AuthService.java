package com.pprajapati.springsecurity.security;

import com.pprajapati.springsecurity.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service()
@Transactional
public class AuthService implements UserDetailsService {

  private final UserRepo userRepo;

  public AuthService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var user = userRepo.findByUserName(username);
    var userDetails = new AuthUser(user);
    return userDetails;
  }
}
