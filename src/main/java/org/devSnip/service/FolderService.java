package org.devSnip.service;

import org.devSnip.model.Folder;

import java.util.List;

public interface FolderService {
    boolean addFolder(Folder folder);
//    Folder updateFolder(Integer id, FolderDto folderDto);
//    FolderDto viewFolder(Integer id);
    List<Folder> viewAllFolder( );
    boolean deleteFolder(Integer id);
}
