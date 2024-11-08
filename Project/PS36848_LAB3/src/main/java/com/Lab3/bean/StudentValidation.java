package com.Lab3.bean;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class StudentValidation {
	@NotBlank(message="NotBlank.sv.email")
	@Email(message="Không đúng định dạng email")
	String email;
	@NotBlank(message="Không được để trống họ và tên")
	String fullname;
	@NotNull(message="điểm không được để trống")
	@PositiveOrZero(message="Điểm phải lớn hơn hoặc bằng 0")
	@Max(value=10,message="Điểm phải nhỏ hơn hoặc bằng 10")
	Double marks;
	@NotNull(message="Chọn giới tính")
	Boolean gender;
	@NotBlank(message="Chưa chọn quốc tịch")
	String country;
}
