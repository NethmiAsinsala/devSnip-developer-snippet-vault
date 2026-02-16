package org.devSnip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> tag_id;

    private List<String> tagNameList;

    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private String newTagName;
}