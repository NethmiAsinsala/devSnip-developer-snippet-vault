package org.devSnip.service;

import org.devSnip.model.Folder;

import java.util.List;

public interface FolderService {
    boolean addFolder(Folder folder);
    boolean updateFolder(Integer id, Folder folder);
    List<Folder> viewAllFolder( );
    boolean deleteFolder(Integer id);
}
