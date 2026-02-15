package org.devSnip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDto{
    private Integer tag_id;
    private String name;

    private List<Integer> snippet_id;
}