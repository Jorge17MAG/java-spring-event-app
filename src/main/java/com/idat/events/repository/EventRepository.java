package com.idat.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.events.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
    
}
