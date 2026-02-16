package org.devSnip.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.devSnip.dto.SnippetDto;
import org.devSnip.entity.Snippet;
import org.devSnip.entity.Tag;
import org.devSnip.entity.User;
import org.devSnip.exception.ResourceNotFoundException;
import org.devSnip.repository.SnippetRepository;
import org.devSnip.repository.TagRepository;
import org.devSnip.repository.UserRepository;
import org.devSnip.service.SnippetService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SnippetServiceImpl implements SnippetService {

    private final SnippetRepository snippetRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final ObjectMapper mapper;

    @Override
    @Transactional
    public void addSnippet(SnippetDto snippetDto) {

        User user = userRepository.findById(snippetDto.getUser_id())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Snippet snippet = mapper.convertValue(snippetDto, Snippet.class);
        snippet.setUser(user);

        List<Tag> tags = (snippetDto.getTag_id() == null || snippetDto.getTag_id().isEmpty())
                ? new ArrayList<>()
                : tagRepository.findAllById(snippetDto.getTag_id());

        snippet.setTagList(tags);

        snippetRepository.save(snippet);
    }

    @Override
    public List<SnippetDto> viewAllSnippet() {

        List<Snippet> snippetList = snippetRepository.findAll();
        List<SnippetDto> snippetDtoList = new ArrayList<>();

        for (Snippet snippet : snippetList) {

            SnippetDto snippetDto = new SnippetDto();
            snippetDto.setId(snippet.getId());
            snippetDto.setTitle(snippet.getTitle());
            snippetDto.setDescription(snippet.getDescription());
            snippetDto.setCode_content(snippet.getCode_content());
            snippetDto.setLanguage(snippet.getLanguage());

            if(snippet.getUser() != null){
                snippetDto.setUser_id(snippet.getUser().getUser_id());
            }
            snippetDtoList.add(snippetDto);

            List<String> tagNameList = new ArrayList<>();

            for (Tag tag : snippet.getTagList()){
                tagNameList.add(tag.getName());
            }
            snippetDto.setTagNameList(tagNameList);
        }

        return snippetDtoList;
    }


    @Override
    public SnippetDto viewSnippetById(Integer id) {
        Snippet snippet = snippetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Snippet Not Found"));

        SnippetDto snippetDto = new SnippetDto();
        snippetDto.setId(snippet.getId());
        snippetDto.setTitle(snippet.getTitle());
        snippetDto.setDescription(snippet.getDescription());
        snippetDto.setCode_content(snippet.getCode_content());
        snippetDto.setLanguage(snippet.getLanguage());

        if (snippet.getUser()!=null){
            snippetDto.setUser_id(snippet.getUser().getUser_id());
        }

        List<String> tagNameList = new ArrayList<>();

        for (Tag tag : snippet.getTagList()){
            tagNameList.add(tag.getName());
        }
        snippetDto.setTagNameList(tagNameList);

        return snippetDto;
    }

    @Override
    public Snippet updateSnippet(Integer id, SnippetDto snippetDto) {
        Snippet snippet = snippetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Snippet Not Found"));

        if (snippetDto.getCode_content()!= null) snippet.setCode_content(snippetDto.getCode_content());
        if (snippetDto.getTitle()!=null) snippet.setTitle(snippetDto.getTitle());
        if (snippetDto.getDescription()!=null) snippet.setDescription(snippetDto.getDescription());
        if (snippetDto.getLanguage()!=null) snippet.setLanguage(snippetDto.getLanguage());
        if (snippetDto.getNewTagName() != null &&
                !snippetDto.getNewTagName().trim().isEmpty()) {

            if (snippet.getTagList() == null) {
                snippet.setTagList(new ArrayList<>());
            }

            String tagName = snippetDto.getNewTagName().trim();

            Tag tag = tagRepository.findByName(tagName)
                    .orElseGet(() -> {
                        Tag newTag = new Tag();
                        newTag.setName(tagName);
                        return tagRepository.save(newTag);
                    });

            boolean alreadyExists = snippet.getTagList().stream()
                    .anyMatch(t -> t.getName().equalsIgnoreCase(tagName));

            if (!alreadyExists) {
                snippet.getTagList().add(tag);
            }
        }
        return snippetRepository.save(snippet);
    }

    @Override
    public void deleteSnippet(Integer id) {
        snippetRepository.deleteById(id);
    }

}
