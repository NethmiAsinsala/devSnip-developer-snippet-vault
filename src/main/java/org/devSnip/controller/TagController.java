package org.devSnip.controller;

import lombok.RequiredArgsConstructor;
import org.devSnip.dto.TagDto;
import org.devSnip.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping ("api/tags")
public class TagController {

    private final TagService tagService;

    @PostMapping ("/add")
    public void addTag(TagDto tagDto){
        tagService.addTag(tagDto);
    }

    @GetMapping ("/get-all")
    public List<TagDto> viewAllTags(){
        return tagService.viewAllTags();
    }

    @GetMapping ("/view/{id}")
    public TagDto viewTagById(@PathVariable Integer id){
        return tagService.viewTagById(id);
    }

    @PutMapping ("/update/{id}")
    public void updateTag(@PathVariable Integer id, TagDto tagDto){
        tagService.updateTag(id, tagDto);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteTag(@PathVariable Integer id){
        tagService.deleteTag(id);
    }
}
