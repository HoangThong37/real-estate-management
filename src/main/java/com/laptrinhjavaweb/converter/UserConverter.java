package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
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


    public UserEntity convertToEntity (UserDTO dto){
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;
    }

/*    public UserDTO convertToDto (UserEntity entity){
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }*/

    public List<StaffResponseDTO> convertToStaffResponse(List<UserEntity> userEntities) {
        List<StaffResponseDTO> listStaffResponse = new ArrayList<>();

        for (UserEntity allStaff : userRepository.getAllStaff()) {
            StaffResponseDTO staffResponseDTO = modelMapper.map(allStaff, StaffResponseDTO.class);

            for (UserEntity staff : userEntities) {
                if (allStaff.getId() == staff.getId()) {
                    staffResponseDTO.setChecked("checked");
                }
            }
            listStaffResponse.add(staffResponseDTO);
        }
        return listStaffResponse;
    }
}