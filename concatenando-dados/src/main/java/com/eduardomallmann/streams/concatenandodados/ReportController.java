package com.eduardomallmann.streams.concatenandodados;

import com.eduardomallmann.streams.concatenandodados.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/report")
public class ReportController {

	private static final Integer MINIMUM_AGE = 25;

	private EmployeeRepository employeeRepository;
	private ClientRepository clientRepository;

	public ReportController(EmployeeRepository employeeRepository,
							ClientRepository clientRepository) {
		this.employeeRepository = employeeRepository;
		this.clientRepository = clientRepository;
	}

	@GetMapping
	public ResponseEntity<List<Person>> getReportList() {

		// recuperar todos os funcionários
		List<Employee> employees = employeeRepository.findAll();
		// recuperar todos os clientes
		List<Client> clients = clientRepository.findAll();
		// concatenar as listas
		Stream<Person> persons = Stream.concat(employees.stream(), clients.stream());

		// filtrar por idade
		List<Person> responseList = persons.filter(person -> person.getAge() >= MINIMUM_AGE).collect(Collectors.toList());


		return ResponseEntity.ok(responseList);
	}
}
