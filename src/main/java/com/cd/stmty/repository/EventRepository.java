package com.cd.stmty.repository;

import com.cd.stmty.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EventRepository extends JpaRepository<Event, Long> {

	Event findEventById(Long id);
}
