package com.example.turnstile.services;

import com.example.turnstile.models.Card;
import com.example.turnstile.models.User;
import com.example.turnstile.repositories.CardRepository;
import com.example.turnstile.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private CardRepository cardRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CardRepository cardRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByLogin(String login) {
        Optional<User> userOptional = userRepository.findUserByLogin(login);
        if (!userOptional.isPresent()) {
            return null;
        }

        return userOptional.get();
    }

    @Override
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        Card card = new Card();
        card.setPassCount(10);
        long millis=System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        date.setTime(2000000000 + date.getTime());
        card.setExpirationDate(date);
        card.setPassCount(10);
        card.setUser(user);
        card = cardRepository.save(card);
        user.setCard(card);
        userRepository.save(user);
    }
}
