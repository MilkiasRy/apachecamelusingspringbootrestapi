package com.mtg.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtg.model.ClaimEntity;

@Repository
public interface ClaimRepository extends JpaRepository<ClaimEntity,Long> {


}
