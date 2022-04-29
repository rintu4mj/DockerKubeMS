package com.example.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.docker.model.Docker;

@Repository
public interface DockerRepository extends JpaRepository<Docker, Long> {
}
