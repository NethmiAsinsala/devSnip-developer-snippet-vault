package org.devSnip.repository;

import org.devSnip.model.Folder;
import org.devSnip.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository {
    boolean addTag(Tag tag);
    boolean deleteTag(Integer id);
    boolean updateTag(Integer id, Tag tag);
    List<Tag> viewAllTags();
}
