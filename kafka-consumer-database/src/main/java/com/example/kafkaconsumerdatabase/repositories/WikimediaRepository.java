package com.example.kafkaconsumerdatabase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkaconsumerdatabase.entity.WikimediaData;

@Repository
public interface WikimediaRepository extends JpaRepository<WikimediaData, Long> {

}
