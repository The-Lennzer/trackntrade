package com.tracktrade.trackntrade.service;

import com.tracktrade.trackntrade.model.Liability;
import com.tracktrade.trackntrade.model.User;
import com.tracktrade.trackntrade.repo.LiabilityRepository;
import com.tracktrade.trackntrade.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LiabilityService {

    private final LiabilityRepository liabilityRepository;
    private final UserRepository userRepository;

    public Liability createLiability(UUID userId, String name, Double value) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Liability liability = new Liability();
        liability.setUser(user);
        liability.setName(name);
        liability.setValue(value);

        return liabilityRepository.save(liability);
    }

    public Liability editLiability(UUID id, String name, Double value) {
        Liability liability = liabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Liability not found"));

        if (name != null) liability.setName(name);
        if (value != null) liability.setValue(value);

        return liabilityRepository.save(liability);
    }

    public void deleteLiability(UUID id) {
        liabilityRepository.deleteById(id);
    }

    public List<Liability> getAllByUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return liabilityRepository.findAllByUser(user);
    }
}
