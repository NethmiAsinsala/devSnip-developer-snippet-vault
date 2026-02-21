package org.devSnip.repository.Impl;

import lombok.RequiredArgsConstructor;
import org.devSnip.model.Folder;
import org.devSnip.repository.FolderRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FolderRepositoryImpl implements FolderRepository {
    final private JdbcTemplate jdbcTemplate;


    @Override
    public boolean addFolder(Folder folder) {
        String sql = """
                        INSERT INTO folders(name) VALUES(?)""";

        return jdbcTemplate.update(sql,
                folder.getName()
        )>0;
    }

    @Override
    public boolean deleteFolder(Integer id) {
        String sql = "DELETE FROM folders WHERE FolderId =?";

        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public List<Folder> viewAll() {
        String sql ="SELECT * FROM folders";

        List<Folder> folderList = jdbcTemplate.query(sql,(rs,rowNum)->{
            Folder folder = new Folder();
            folder.setFolderId(rs.getInt(1));
            folder.setName(rs.getString(2));

            return folder;
        });
        return folderList;
    }
}
