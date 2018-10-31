package com.eduardomallmann.streams.concatenandodados;

import com.eduardomallmann.streams.concatenandodados.models.Client;
import com.eduardomallmann.streams.concatenandodados.models.ClientRepository;
import com.eduardomallmann.streams.concatenandodados.models.Employee;
import com.eduardomallmann.streams.concatenandodados.models.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dataset")
public class DataController {

	private EmployeeRepository employeeRepository;
	private ClientRepository clientRepository;

	public DataController(EmployeeRepository employeeRepository,
							ClientRepository clientRepository) {
		this.employeeRepository = employeeRepository;
		this.clientRepository = clientRepository;
	}

	@PostMapping("/employee")
	public ResponseEntity<List<Employee>> createEmployees(@RequestBody List<Employee> employees) {
		return ResponseEntity.ok(employeeRepository.saveAll(employees));
	}

	@PostMapping("/client")
	public ResponseEntity<List<Client>> createClients(@RequestBody List<Client> clients) {
		return ResponseEntity.ok(clientRepository.saveAll(clients));
	}

}
