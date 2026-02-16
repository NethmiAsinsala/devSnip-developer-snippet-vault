package org.devSnip.service;

import org.devSnip.dto.FolderDto;
import org.devSnip.entity.Folder;

import java.util.List;

public interface FolderService {
    void addFolder(FolderDto folderDto);
    Folder updateFolder(Integer id, FolderDto folderDto);
    FolderDto viewFolder(Integer id);
    List<FolderDto> viewAllFolder( );
    void deleteFolder(Integer id);
}
