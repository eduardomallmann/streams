package com.eduardomallmann.streams.concatenandodados.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	private String name;
	private String email;
	private String gender;
	private String city;
	private String country;
	private LocalDate birthDay;

}
