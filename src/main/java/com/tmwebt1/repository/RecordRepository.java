package com.tmwebt1.repository;

import com.tmwebt1.model.RecordTelemed;
import com.tmwebt1.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends CrudRepository<RecordTelemed, Long> {
    List<RecordTelemed> findByUser (User user);
}