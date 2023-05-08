package com.laptrinhjavaweb.dto.response;

import com.laptrinhjavaweb.dto.UserDTO;

public class StaffResponseDTO extends UserDTO {

    private String checked;

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }


}
