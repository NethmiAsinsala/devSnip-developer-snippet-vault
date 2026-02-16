package org.devSnip.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "snippets")
public class Snippet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private String code_content;
    private String language;

    @ManyToOne
    @JoinColumn (name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToMany
    @JoinTable (name = "snippet_tag",
                joinColumns = @JoinColumn(name = "snippet_id"),
                inverseJoinColumns = @JoinColumn (name = "tag_id"))
    private List<Tag> tagList;


}
