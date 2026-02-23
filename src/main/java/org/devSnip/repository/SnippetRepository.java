package org.devSnip.repository;

import org.devSnip.model.Folder;
import org.devSnip.model.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnippetRepository {
    boolean addSnippet(Snippet snippet);
    boolean deleteSnippet(Integer id);
    boolean updateSnippet(Integer id, Snippet snippet);
    List<Snippet> viewAllSnippet();
}
