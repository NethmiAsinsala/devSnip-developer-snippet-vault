package org.devSnip.model;

import lombok.*;

@Getter
@Setter
public class Snippet {

    private Integer id;
    private String title;
    private String description;
    private String code_content;
    private String language;

    private Integer folderId;

}
