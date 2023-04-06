package com.example.kyc.service;
import com.example.kyc.dao.InfoRepository;
import com.example.kyc.dto.payload.ParentFormDto;
import com.example.kyc.entity.ParentForm;
import com.example.kyc.exception.ResourceNotFoundException;
import com.example.kyc.mapper.FormMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class FormServiceImpl implements FormService {
    private final InfoRepository inforepository;
    private final FormMapper formMapper;

    @Override
    public List<ParentFormDto> getAllInfos() {

        return formMapper.mapToDTOList(inforepository.findAll());
    }
    @Override
    public ParentFormDto getInfoById(Long id) {
        return inforepository.findById(id)
                .map(parentForm -> formMapper.mapToDTO(parentForm))
                .orElseThrow(() -> new ResourceNotFoundException("info not exist with id :" + id));
    }
    @Override
    public ParentFormDto createForm(ParentFormDto parentFormDto) {
        return formMapper.mapToDTO(inforepository.save(formMapper.dtoToParent(parentFormDto)));
    }
    @Override
    public  void deleteForm(Long id) {
        ParentForm parentForm = inforepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This object with the given id: "+ id+" does not exist"));
        inforepository.delete(parentForm);
    }
    @Override
    public ParentFormDto updateForm(Long id, ParentFormDto parentFormDto) {

        return formMapper.mapToDTO(
                inforepository.findById(id)
                                .map(existingForm -> inforepository.save(formMapper.updateFromDto(parentFormDto,existingForm)))
                                .orElseThrow(()->new ResourceNotFoundException("This object doesn't exist!"))
        );
    }
}
