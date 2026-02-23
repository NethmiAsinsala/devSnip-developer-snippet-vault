package org.devSnip.repository;

import org.devSnip.model.Folder;


import java.util.List;

public interface FolderRepository {
    boolean addFolder(Folder folder);
    boolean deleteFolder(Integer id);
    boolean updateFolder(Integer id, Folder folder);
    List<Folder> viewAll();
}
