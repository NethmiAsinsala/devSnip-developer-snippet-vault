package org.devSnip.service.impl;
import lombok.RequiredArgsConstructor;

import org.devSnip.model.Tag;
import org.devSnip.repository.TagRepository;
import org.devSnip.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public boolean addTag(Tag tag) {
        return tagRepository.addTag(tag);
    }

    @Override
    public List<Tag> viewAllTags() {
        return tagRepository.viewAllTags();
    }

    @Override
    public boolean updateTag(Integer id, Tag tag) {
        return tagRepository.updateTag(id, tag);
    }

    @Override
    public boolean deleteTag(Integer id) {
        return tagRepository.deleteTag(id);
    }
}
