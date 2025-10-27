package com.hkd.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Student {
	private long id;
	private String name;
	private String email;
	private int age;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
