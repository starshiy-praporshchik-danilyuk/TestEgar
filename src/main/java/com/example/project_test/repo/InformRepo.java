package com.example.project_test.repo;

import com.example.project_test.models.Inform;
import com.example.project_test.models.InformPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformRepo extends JpaRepository<Inform, InformPK> {
}
