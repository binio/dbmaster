package com.binio.dbmaster.repository;

import com.binio.dbmaster.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends JpaRepository<Model, Byte> {
}
