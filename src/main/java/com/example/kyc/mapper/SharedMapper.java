package com.example.kyc.mapper;

import com.example.kyc.entity.ChildrenForm;
import com.example.kyc.entity.ParentForm;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;

import java.util.Iterator;
import java.util.List;


@Lazy
@FieldDefaults(level = AccessLevel.PRIVATE)
@Mapper(
       config = SpringMappingConfig.class
)
@RequiredArgsConstructor
public class SharedMapper {
    private ParentForm parentForm;
    private List<ChildrenForm> childrenForms;



    @AfterMapping
    @Async
    public void setParentForm(@MappingTarget ParentForm parentForm) {

      /*  for (int i=0;i<parentForm.getChildrenForms().size();i++){
            for (ChildrenForm childrenForm : parentForm.getChildrenForms()) {
                childrenForm.setParentForm(parentForm);
            }
        }*/

        for (ChildrenForm childrenForm : parentForm.getChildrenForms()) {
            childrenForm.setParentForm(parentForm);
        }


       /* for (Iterator<ChildrenForm> it = parentForm.getChildrenForms(); it.hasNext(); ) {
            Iterator<ChildrenForm> childrenForm = it.next();
            // childrenForm.setParentForm(parentForm);
        }


*/
    }



}
