package com.example.turnstile.services;

import com.example.turnstile.models.Card;
import com.example.turnstile.models.User;

import java.sql.Date;

public interface TurnstileService {
    String checkCard(User user);
    Card getCardByUser(User user);
    void newUserCard(User user, Date expDate, int passCount);
}
