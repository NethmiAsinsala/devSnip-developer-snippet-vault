package org.devSnip.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.devSnip.dto.TagDto;
import org.devSnip.entity.Snippet;
import org.devSnip.entity.Tag;
import org.devSnip.exception.ResourceNotFoundException;
import org.devSnip.repository.TagRepository;
import org.devSnip.service.TagService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final ObjectMapper mapper;

    @Override
    public void addTag(TagDto tagDto) {
        Tag tag = mapper.convertValue(tagDto, Tag.class);
        tagRepository.save(tag);
    }

    @Override
    public List<TagDto> viewAllTags() {
        List<Tag> tagList = tagRepository.findAll();
        List<TagDto> tagDtoList = new ArrayList<>();

        tagList.forEach(entity ->{
            TagDto tagDto = mapper.convertValue(entity,TagDto.class);
            tagDtoList.add(tagDto);
        });

        List<Snippet> snippetList = new ArrayList<>();

        for (Snippet snippet :){

        }

        return tagDtoList;
    }

    @Override
    public TagDto viewTagById(Integer id) {
       Tag tag = tagRepository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("Tag Not Found"));
       TagDto tagDto = mapper.convertValue(tag, TagDto.class);
        return tagDto;
    }

    @Override
    public Tag updateTag(Integer id, TagDto tagDto) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Tag Not Found"));
        if (tagDto.getName()!=null) tag.setName(tagDto.getName());

        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Integer id) {
        tagRepository.deleteById(id);
    }
}
