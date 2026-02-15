package org.devSnip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SnippetDto {
    private Integer id;
    private String title;
    private String description;
    private String code_content;
    private String language;

    private Integer user_id;

    private List<Integer> tag_id;
}