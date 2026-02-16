package org.devSnip.repository;

import org.devSnip.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder,Integer> {
}
