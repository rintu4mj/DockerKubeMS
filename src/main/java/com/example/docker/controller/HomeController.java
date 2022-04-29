package com.example.docker.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.docker.model.Docker;
import com.example.docker.model.DockerDTO;
import com.example.docker.repository.DockerRepository;

@RestController
@RequestMapping("/main")
public class HomeController {

	@Autowired
	private DockerRepository dockerRepository;

	@Autowired
	public RestTemplate restTemplate;
	

	@GetMapping("/")
	public String main() {

		return "Welcome to Docker and Kubernetes";
	}

	@PostMapping("/docker")
	public Docker dockerpost(@RequestBody DockerDTO dockerDTO) {

		Docker docker = new Docker();

		BeanUtils.copyProperties(dockerDTO, docker);
		dockerRepository.save(docker);

		return docker;
	}

	@GetMapping("/docker")
	public List<Docker> dockerget() {

		return dockerRepository.findAll();

	}

	@GetMapping("/test")
	@ResponseBody
	public String test() {

		try {
			return restTemplate.getForObject("http://docker-mysql-microservice-svc.default.svc.cluster.local:8085/fetch/test", String.class);
		} catch (Exception e) {
			 
			return e.getMessage();
		}

	}

}
