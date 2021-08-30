package com.multiplication.multiplicationservicesmagin.repository;

import com.multiplication.multiplicationservicesmagin.model.MultUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MultUserRepository extends JpaRepository<MultUser, Long> {
    Optional<MultUser> findByAlias(final String alias);
}
