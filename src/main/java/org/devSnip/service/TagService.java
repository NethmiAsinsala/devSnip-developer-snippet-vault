package org.devSnip.service;

import org.devSnip.dto.TagDto;
import org.devSnip.model.Tag;

import java.util.List;

public interface TagService {
    void addTag(TagDto tagDto);
    List<TagDto> viewAllTags();
    TagDto viewTagById(Integer id);
    Tag updateTag(Integer id, TagDto tagDto);
    void deleteTag(Integer id);
}
