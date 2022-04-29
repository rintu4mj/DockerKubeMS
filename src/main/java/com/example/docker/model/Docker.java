package com.example.docker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_docker")
public class Docker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectId;
	private String sector;

}
