package com.example.kyc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class ParentForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String  description ;

    @OneToMany( cascade = { CascadeType.ALL },
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            mappedBy = "parentForm"
    )
    private List<ChildrenForm> childrenForms;
}
