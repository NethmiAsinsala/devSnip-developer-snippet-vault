package org.devSnip.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.devSnip.model.Folder;
import org.devSnip.repository.FolderRepository;
import org.devSnip.service.FolderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;


    @Override
    public boolean addFolder(Folder folder) {
        return folderRepository.addFolder(folder);
    }

    @Override
    public List<Folder> viewAllFolder() {
        return folderRepository.viewAll();
    }

    @Override
    public boolean deleteFolder(Integer id) {
        return folderRepository.deleteFolder(id);
    }
}
