package org.devSnip.service;

import org.devSnip.model.Tag;

import java.util.List;

public interface TagService {
    boolean addTag(Tag tag);
    List<Tag> viewAllTags();
    boolean updateTag(Integer id, Tag tag);
    boolean deleteTag(Integer id);
}
