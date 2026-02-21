package org.devSnip.repository.Impl;

import lombok.RequiredArgsConstructor;
import org.devSnip.model.Snippet;
import org.devSnip.repository.SnippetRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SnippetRepositoryImpl implements SnippetRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addSnippet(Snippet snippet) {
        String sql = """
                        INSERT INTO snippets (code_content,description,language,title) VALUES(?,?,?,?)""";

        return jdbcTemplate.update(sql,
                snippet.getCode_content(),
                snippet.getDescription(),
                snippet.getLanguage(),
                snippet.getTitle()

        )>0;
    }

    @Override
    public boolean deleteSnippet(Integer id) {
        String sql = "DELETE FROM snippets WHERE id =?";

        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public List<Snippet> viewAllSnippet() {
        String sql ="SELECT * FROM snippets";

        List<Snippet> snippetList = jdbcTemplate.query(sql,(rs, rowNum)->{
            Snippet snippet = new Snippet();
            snippet.setId(rs.getInt("id"));
            snippet.setCode_content(rs.getString("code_content"));
            snippet.setDescription(rs.getString("description"));
            snippet.setLanguage(rs.getString("language"));
            snippet.setTitle(rs.getString("title"));

            return snippet;
        });
        return snippetList;
    }
}
