package com.tracktrade.trackntrade.repo;

import com.tracktrade.trackntrade.model.Liability;
import com.tracktrade.trackntrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LiabilityRepository extends JpaRepository<Liability, UUID> {
    List<Liability> findAllByUser(User user);
}
