package org.devSnip.repository;

import org.devSnip.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository <Tag,Integer> {
    Optional<Tag> findByName (String name);
}
