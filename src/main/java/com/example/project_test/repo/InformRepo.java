package com.example.project_test.repo;

import com.example.project_test.domain.Inform;
import com.example.project_test.domain.InformPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface InformRepo extends JpaRepository<Inform, InformPK> {
}
