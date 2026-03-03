package org.devSnip.controller;

import lombok.RequiredArgsConstructor;
import org.devSnip.model.Folder;
import org.devSnip.model.Tag;
import org.devSnip.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
@RequiredArgsConstructor
@RequestMapping ("api/tags")
public class TagController {
    private final TagService tagService;

    @PostMapping("/add")
    public  boolean addtag(Tag tag){
        return tagService.addTag(tag);
    }

    @GetMapping("/get-all")
    public List<Tag> viewAllTag(){
        return tagService.viewAllTags();
    }

    @PatchMapping ("/update/{id}")
    public void updateTahg(@PathVariable Integer id , Tag tag){
        tagService.updateTag(id, tag);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean deleteTag(@PathVariable Integer id){
        return tagService.deleteTag(id);
    }



}
