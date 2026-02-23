package org.devSnip.repository.Impl;

import lombok.RequiredArgsConstructor;
import org.devSnip.model.Snippet;
import org.devSnip.repository.SnippetRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean updateSnippet(Integer id, Snippet snippet) {
        StringBuilder sql = new StringBuilder("UPDATE snippets SET ");
        List<Object> params = new ArrayList<>();
        boolean hasUpdate = false;

        if(snippet.getTitle()!=null){
            sql.append("title = ?, ");
            params.add(snippet.getTitle());
            hasUpdate = true;
        }
        if(snippet.getDescription()!=null){
            sql.append("description = ?, ");
            params.add(snippet.getDescription());
            hasUpdate = true;
        }
        if(snippet.getCode_content()!=null){
            sql.append("code_content = ?, ");
            params.add(snippet.getCode_content());
            hasUpdate = true;
        }
        if(snippet.getLanguage()!=null){
            sql.append("language = ?, ");
            params.add(snippet.getLanguage());
            hasUpdate = true;
        }

        if (!hasUpdate) return false;

        sql.setLength(sql.length()-2);
        sql.append(" WHERE id = ?");
        params.add(id);

        return jdbcTemplate.update(sql.toString(), params.toArray())>0;
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
