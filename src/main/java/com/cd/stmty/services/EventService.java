package com.cd.stmty.services;

import com.cd.stmty.model.BaseListRequest;
import com.cd.stmty.model.Event;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface EventService {

    Page<Event> getAll(BaseListRequest request);

    Event insert(Event event);

    Event update(Event event);

    void delete(Long id);

    Event getById(Long id);
}
