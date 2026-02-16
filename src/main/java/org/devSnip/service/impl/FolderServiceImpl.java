package org.devSnip.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.devSnip.dto.FolderDto;
import org.devSnip.entity.Folder;
import org.devSnip.exception.ResourceNotFoundException;
import org.devSnip.repository.FolderRepository;
import org.devSnip.service.FolderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final ObjectMapper mapper;
    private final FolderRepository folderRepository;

    @Override
    @Transactional
    public void addFolder( FolderDto folderDto) {
        Folder folder = mapper.convertValue(folderDto, Folder.class);
        folderRepository.save(folder);
    }

    @Override
    @Transactional
    public Folder updateFolder(Integer id, FolderDto folderDto) {
        Folder folder = folderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Folder not found"));
        if (folderDto.getName()!=null){
            folder.setName(folderDto.getName());
        }
        return folderRepository.save(folder);
    }

    @Override
    public FolderDto viewFolder(Integer id) {
        Folder folder = folderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Folder not found"));
        FolderDto folderDto = mapper.convertValue(folder, FolderDto.class);
        return folderDto;
    }

    @Override
    public List<FolderDto> viewAllFolder() {
        List <Folder> folderList = folderRepository.findAll();
        List <FolderDto> folderDtoList = new ArrayList<>();

        folderList.forEach(entity -> {
            FolderDto folderDto = mapper.convertValue(entity, FolderDto.class);
            folderDtoList.add(folderDto);
        });
        return folderDtoList;
    }

    @Override
    @Transactional
    public void deleteFolder(Integer id) {
        folderRepository.deleteById(id);
    }
}
