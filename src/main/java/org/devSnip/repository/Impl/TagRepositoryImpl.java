package org.devSnip.repository.Impl;

import lombok.RequiredArgsConstructor;
import org.devSnip.model.Tag;
import org.devSnip.repository.TagRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TagRepositoryImpl implements TagRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addTag(Tag tag) {
        String sql = """
                        INSERT INTO tags (name) VALUES(?)""";

        return jdbcTemplate.update(sql,
                tag.getName()
        )>0;
    }

    @Override
    public boolean deleteTag(Integer id) {
        String sql = "DELETE FROM tags WHERE id =?";

        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public List<Tag> viewAllTags() {
        String sql ="SELECT * FROM tags";

        List<Tag> tagList = jdbcTemplate.query(sql,(rs, rowNum)->{
            Tag tag = new Tag();
            tag.setId(rs.getInt(1));
            tag.setName(rs.getString(2));


            return tag;
        });
        return tagList;
    }
}
