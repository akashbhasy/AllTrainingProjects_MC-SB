package com.ust.kafka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ust.kafka.model.KafkaSsgModel;

@Repository
public interface KafkaRepository  extends CrudRepository<KafkaSsgModel, Integer> {

}
