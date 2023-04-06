package com.example.kyc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "setting")
    private Question questionn;
    private String fieldType;
    private String placeholder;
    private Integer maxSelectedChoice;
    private Integer fileSize;
    private Integer textLength;
    private String errMsg;




}
