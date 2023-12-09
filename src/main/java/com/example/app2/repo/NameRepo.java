package com.example.app2.repo;

import com.example.app2.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepo extends JpaRepository<Name, String> {
}
