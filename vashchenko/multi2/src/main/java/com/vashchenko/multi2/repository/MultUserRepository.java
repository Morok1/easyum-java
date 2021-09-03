package com.vashchenko.multi2.repository;

import com.vashchenko.multi2.model.MultUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MultUserRepository extends JpaRepository<MultUser, Long> {
    Optional<MultUser> findByAlias(final String alias);
}
