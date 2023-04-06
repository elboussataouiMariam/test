package com.example.kyc.dto.payload;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ParentFormDto {

    private Long id;
    private String title;
    private String  description ;
    private List<ChildrenFormDto> childrenForms;
}
