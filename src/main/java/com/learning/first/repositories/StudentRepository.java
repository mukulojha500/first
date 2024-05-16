package com.learning.first.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.learning.first.models.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{
}