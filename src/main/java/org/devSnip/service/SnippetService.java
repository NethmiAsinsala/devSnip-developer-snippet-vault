package org.devSnip.service;

import org.devSnip.model.Snippet;

import java.util.List;

public interface SnippetService {
    boolean addSnippet(Snippet snippet);
    List<Snippet> viewAllSnippet ();
//    SnippetDto viewSnippetById(Integer id);
//    Snippet updateSnippet(Integer id, SnippetDto snippetDto);
    boolean deleteSnippet(Integer id);


}
