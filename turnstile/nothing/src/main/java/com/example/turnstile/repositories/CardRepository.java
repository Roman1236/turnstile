package com.example.turnstile.repositories;

import com.example.turnstile.models.Card;
import com.example.turnstile.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    Optional<Card> findByUser(User user);
}
