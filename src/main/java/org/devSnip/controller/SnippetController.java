package org.devSnip.controller;

import lombok.RequiredArgsConstructor;
import org.devSnip.dto.SnippetDto;
import org.devSnip.service.SnippetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping ("api/snippets")
public class SnippetController {

    private final SnippetService snippetService;

    @PostMapping ("/add")
    public void addSnippet(@RequestBody  SnippetDto snippetDto){
        snippetService.addSnippet(snippetDto);
    }

    @GetMapping ("/get-all")
    public List<SnippetDto> viewAllSnippet(){
        return snippetService.viewAllSnippet();
    }

    @GetMapping ("/view/{id}")
    public SnippetDto viewSnippetById(@PathVariable Integer id){
        return snippetService.viewSnippetById(id);
    }

    @PutMapping ("/update/{id}")
    public void updateSnippet(@PathVariable Integer id, @RequestBody SnippetDto snippetDto ){
        snippetService.updateSnippet(id, snippetDto);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteSnippet(@PathVariable Integer id){
        snippetService.deleteSnippet(id);
    }
}
