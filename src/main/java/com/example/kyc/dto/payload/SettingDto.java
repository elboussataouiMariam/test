package com.example.kyc.dto.payload;

import com.example.kyc.entity.Question;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SettingDto {
    private String fieldType;
    private String placeholder;
    private Integer maxSelectedChoice;
    private  Integer fileSize;
    private Integer textLength;
    private String errMsg;
}
