package org.devSnip.service.impl;

import lombok.RequiredArgsConstructor;
import org.devSnip.model.Snippet;
import org.devSnip.repository.SnippetRepository;
import org.devSnip.service.SnippetService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SnippetServiceImpl implements SnippetService {

    private final SnippetRepository snippetRepository;


    @Override
    public boolean addSnippet(Snippet snippet) {
        return snippetRepository.addSnippet(snippet);
    }

    @Override
    public List<Snippet> viewAllSnippet() {
        return snippetRepository.viewAllSnippet();
    }

    @Override
    public void updateSnippet(Integer id, Snippet snippet) {
         snippetRepository.updateSnippet(id, snippet);
    }

    @Override
    public boolean deleteSnippet(Integer id) {
        return snippetRepository.deleteSnippet(id);
    }

    @Override
    public List<Snippet> getByFolder(Integer id) {
        return  snippetRepository.getByFolder(id);
    }
}
