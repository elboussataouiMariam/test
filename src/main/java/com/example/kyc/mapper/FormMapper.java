package com.example.kyc.mapper;

import com.example.kyc.dto.payload.*;
import com.example.kyc.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Lazy;

import java.util.Iterator;
import java.util.List;

@Lazy
@Mapper(config = SpringMappingConfig.class,
        uses = SharedMapper.class,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface FormMapper{

    FormMapper INSTANCE = Mappers.getMapper(FormMapper.class);

    @Named("mapToDTO")
    ParentFormDto mapToDTO(ParentForm entity);
    @IterableMapping(qualifiedByName = "mapToDTO")
    List<ParentFormDto> mapToDTOList(List<ParentForm> entities);

    //List<ChildrenFormDto> map(Iterator<ChildrenForm> value);



    //@IterableMapping(qualifiedByName = "updateChidlren")
    ParentForm updateFromDto(ParentFormDto parentFormDto, @MappingTarget ParentForm parentForm);


    @Named("updateChidlren")
    ChildrenForm updateChidlrenDTO(ChildrenFormDto childrenFormDto, @MappingTarget ChildrenForm childrenForm);
    @Named("mapToDTOIterable")
    @IterableMapping(qualifiedByName = "mapToDTO")
    Iterable<ParentFormDto> toDTOIterable(Iterable<ParentForm> entities);


  // ParentFormDto parentToDto(ParentForm parentForm);
   // List<ParentFormDto> parentToparentAllDtos(List<ParentForm> parentForms);
    ParentForm  dtoToParent(ParentFormDto parentFormDto);

    @Named("mapToChildrenDto")
    ChildrenFormDto childrenToDto(ChildrenForm childrenForm);

    @IterableMapping(qualifiedByName = "mapToChildrenDto")
    List<ChildrenFormDto> childrenTchildrenAllDtos(List<ChildrenForm> childrenForms);
    ChildrenForm dtoToChildren(ChildrenFormDto childrenFormDto);
    Option dtoToOption(OptionDto optionDto);
    OptionDto optionToDto(Option option);
    QuestionDto questionToDto(Question question);
    Question dtoToQuestion(QuestionDto questionDto);
    List<QuestionDto> questionsToquestionAllDtos(List<Question> authors);

    List<ExtrasDto> extrasToextraAllDtos(List<Extras> extras);
    List<OptionDto>  optionTooptionAllDtos(List<Option> options);
    Extras dtoToExtras(ExtrasDto extrasDto);
    ExtrasDto extraToDto(Extras extras);


}
