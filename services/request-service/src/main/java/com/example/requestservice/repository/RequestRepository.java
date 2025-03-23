package com.example.requestservice.repository;

import com.example.requestservice.model.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, String> {
}
