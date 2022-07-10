package com.ezms.project.repositories;

import com.ezms.project.models.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @NonNull User save(@NonNull User userBody);
    @NonNull ArrayList<User> findAll();
    @NonNull Optional<User> findById(@NonNull UUID id);
    void deleteById(@NonNull UUID id);
}
