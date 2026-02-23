package org.devSnip.repository.Impl;

import lombok.RequiredArgsConstructor;
import org.devSnip.model.User;
import org.devSnip.repository.UserRepository;
import org.devSnip.util.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addUser(User user) {
        String sql = """
                     INSERT INTO users (name,email,password,role) VALUES(?,?,?,?)""";

        return jdbcTemplate.update(sql,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().name()

        )>0;
    }

    @Override
    public boolean deleteUser(Integer id) {
        String sql = "DELETE FROM users WHERE id =?";

        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public boolean updateUser(Integer id, User user) {
        StringBuilder sql = new StringBuilder("UPDATE users SET ");
        List<Object> params = new ArrayList<>();
        boolean hasUpdate = false;

        if(user.getName()!=null){
            sql.append("name = ?, ");
            params.add(user.getName());
            hasUpdate = true;
        }
        if(user.getEmail()!=null){
            sql.append("email = ?, ");
            params.add(user.getEmail());
            hasUpdate = true;
        }
        if(user.getPassword()!=null){
            sql.append("password = ?, ");
            params.add(user.getPassword());
            hasUpdate = true;
        }
        if(user.getRole()!=null){
            sql.append("language = ?, ");
            params.add(user.getRole());
            hasUpdate = true;
        }

        if (!hasUpdate) return false;

        sql.setLength(sql.length()-2);
        sql.append(" WHERE user_id = ?");
        params.add(id);

        return jdbcTemplate.update(sql.toString(), params.toArray())>0;
    }

    @Override
    public List<User> viewAllUsers() {
        String sql ="SELECT user_id,email,name,password,role FROM users";

        List<User> userList = jdbcTemplate.query(sql,(rs, rowNum)->{
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            String roleDb = rs.getString("role");
            user.setRole(roleDb == null ? null : Role.valueOf(roleDb.trim().toUpperCase()));

            return user;
        });
        return userList;
    }
}
