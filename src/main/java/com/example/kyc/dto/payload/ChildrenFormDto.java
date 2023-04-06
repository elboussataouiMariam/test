package com.example.kyc.dto.payload;
import lombok.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ChildrenFormDto {

    private Long id;

    private String documentName;
    private String documentDescription;

    private List<QuestionDto> questions;



}
