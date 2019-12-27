package com.example.turnstile.services;

import com.example.turnstile.models.Card;
import com.example.turnstile.models.User;
import com.example.turnstile.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class TurnstileServiceImpl implements TurnstileService {
    private final CardRepository cardRepository;

    @Autowired
    public TurnstileServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public String checkCard(User user) {
        Card card = getCardByUser(user);
        if (card == null) {
            return "Restricted";
        }
        long millis=System.currentTimeMillis();
        java.sql.Date curdate = new java.sql.Date(millis);
        if (card.getExpirationDate().after(curdate) && card.getPassCount() > 0) {
            card.setPassCount(card.getPassCount() - 1);
            cardRepository.save(card);
            return "Allowed";
        }
        return "Restricted";
    }

    @Override
    public Card getCardByUser(User user) {
        Optional<Card> optionalCard = cardRepository.findByUser(user);
        if (optionalCard.isPresent()) {
            return optionalCard.get();
        }
        return null;
    }

    @Override
    public void newUserCard(User user, Date expDate, int passCount) {
        Card card = getCardByUser(user);
        if (card == null) return;
        card.setPassCount(passCount);
        card.setExpirationDate(expDate);
        cardRepository.save(card);
    }
}
