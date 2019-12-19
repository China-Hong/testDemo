package com.example.dao;

import com.example.demo.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonESRepository extends ElasticsearchRepository<Person, Long> {
}
