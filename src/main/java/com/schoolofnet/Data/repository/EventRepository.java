package com.schoolofnet.Data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.Data.models.Event;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long>{

}
