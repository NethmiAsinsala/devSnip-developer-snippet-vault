package org.devSnip.service;

import org.devSnip.dto.SnippetDto;
import org.devSnip.entity.Snippet;

import java.util.List;

public interface SnippetService {
    void addSnippet(SnippetDto snippetDto);
    List<SnippetDto> viewAllSnippet ();
    SnippetDto viewSnippetById(Integer id);
    Snippet updateSnippet(Integer id, SnippetDto snippetDto);
    void deleteSnippet(Integer id);

}
