package com.hglsys.nodues.Dto.departmentDto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest {

    @NotBlank(message = "Enter department name.")
    @Size(max = 40, message = "Must not exceed 40 characters")
    private String departmentName;


    @NotBlank(message = "Enter description")
    @Size(max = 200)
    private String description;

    @Size(min = 3, max = 6, message = "Short code should be least 3 and max 6 characters long.")
    private String departmentCode;

}
