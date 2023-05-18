package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;
import com.laptrinhjavaweb.entity.AssignBuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
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
    private UserRepository userRepository;

    public UserDTO convertToDto (UserEntity entity){
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }

    public List<StaffResponseDTO> convertToDtoResponse(List<AssignBuildingEntity> listAssignUser){
        List<StaffResponseDTO> result = new ArrayList<>();
        for (UserEntity staffAll : userRepository.getAllStaff()) {
            StaffResponseDTO listStaff = modelMapper.map(staffAll, StaffResponseDTO.class);

            for (AssignBuildingEntity userList : listAssignUser) {//  list staff quản lí building x
                if (staffAll.getId() == userList.getUser().getId()) {
                    listStaff.setChecked("checked");
                }
            }
            result.add(listStaff);
        }
        return result;
    }

    public UserEntity convertToEntity (UserDTO dto){
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;
    }
}