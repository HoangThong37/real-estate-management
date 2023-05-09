package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.impl.UserRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepositoryImpl userRepository;

    public UserDTO convertToDto (UserEntity entity){
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }

    public List<StaffResponseDTO> convertToDtoResponse(List<UserEntity> listUserEntity){
        List<StaffResponseDTO> result = new ArrayList<>();
        for (UserEntity staffAll : userRepository.getAllStaff()) { // For example: id=1 -> in ra 3 building: b,c,d
            int i = 0;
            for (UserEntity userList : listUserEntity) {  // 2 tòa nhà b,c
                if (staffAll.getId() == userList.getId()) {
                   i++;
                }
            }
            StaffResponseDTO listStaff = modelMapper.map(staffAll, StaffResponseDTO.class);
            if (i > 0) {
                listStaff.setChecked("checked");
                result.add(listStaff);
            }
        }
        return result;
    }

    public UserEntity convertToEntity (UserDTO dto){
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;
    }
}
