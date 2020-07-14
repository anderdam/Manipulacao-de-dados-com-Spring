package com.challenge.service;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;

import java.util.List;

public class ChallengeService implements ChallengeServiceInterface {
    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return null;
    }

    @Override
    public Challenge save(Challenge object) {
        return null;
    }
}
