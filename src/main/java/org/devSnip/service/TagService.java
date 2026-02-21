package org.devSnip.service;

import org.devSnip.model.Tag;

import java.util.List;

public interface TagService {
    boolean addTag(Tag tag);
    List<Tag> viewAllTags();
//    TagDto viewTagById(Integer id);
//    Tag updateTag(Integer id, TagDto tagDto);
    boolean deleteTag(Integer id);
}
