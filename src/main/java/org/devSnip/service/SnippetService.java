package org.devSnip.service;

import org.devSnip.model.Snippet;

import java.util.List;

public interface SnippetService {
    boolean addSnippet(Snippet snippet);
    List<Snippet> viewAllSnippet ();
    void updateSnippet(Integer id, Snippet snippet);
    boolean deleteSnippet(Integer id);


}
