package com.example.Library.Management.repository;

import com.example.Library.Management.entity.LendRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LendRecordRepository extends MongoRepository<LendRecord, String> {
}