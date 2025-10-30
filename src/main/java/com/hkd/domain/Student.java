<<<<<<< HEAD
package com.skc.mybatis.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
=======
package com.hkd.domain;

import java.time.LocalDateTime;

>>>>>>> develop
import lombok.Data;

@Data
public class Student {
<<<<<<< HEAD

	private Long id;
	@NotBlank(message = "이름은 필수항목")
	private String name;
	@Email(message = "이메일 형식@ 입력필수")
	private String email;
	@Min(value = 1, message = "나이는 1세 이상")
	private Integer age;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

=======
	private long id;
	private String name;
	private String email;
	private int age;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
>>>>>>> develop
}
