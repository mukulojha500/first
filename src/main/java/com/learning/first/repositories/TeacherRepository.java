package com.learning.first.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.learning.first.models.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {
}