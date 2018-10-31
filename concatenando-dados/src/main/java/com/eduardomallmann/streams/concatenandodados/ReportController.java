package com.eduardomallmann.streams.concatenandodados;

import com.eduardomallmann.streams.concatenandodados.models.ClientRepository;
import com.eduardomallmann.streams.concatenandodados.models.EmployeeRepository;
import com.eduardomallmann.streams.concatenandodados.models.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

		// recuperar todos os clientes

		// concatenar as listas

		// filtrar por idade


		return null;
	}
}
