package com.isge.avis.repository;

import com.isge.avis.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    // Recherche un utilisateur par son nom d'utilisateur
    Optional<User> findByUsername(String username);

    // Recherche un utilisateur par son adresse e-mail
    Optional<User> findByEmail(String email);
}
