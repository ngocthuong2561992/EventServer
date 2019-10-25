package com.cd.stmty.services.impl;

import com.cd.stmty.exception.StmtyException;
import com.cd.stmty.model.BaseListRequest;
import com.cd.stmty.model.Event;
import com.cd.stmty.repository.EventRepository;
import com.cd.stmty.services.EventService;
import com.cd.stmty.util.Const;
import com.cd.stmty.util.ObjectUtil;
import com.cd.stmty.util.StringUtil;
import com.cd.stmty.util.UriParam;
import com.cd.stmty.util.UtilBase64Image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EventServiceImpl implements EventService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Page<Event> getAll(BaseListRequest request) {
        try {
            LOGGER.info(Const.LOG_BEGIN_SERVICE + UriParam.LIST_EVENT);
            PageRequest pageRequest = request.createPageRequest(UriParam.ID);
            Page<Event> events = eventRepository.findAll(pageRequest);
            LOGGER.debug(events.toString());
            return events;
        } finally {
            LOGGER.info(Const.LOG_END_SERVICE + UriParam.LIST_EVENT);
        }
    }

    @Override
    public Event getById(Long id) {
        try {
            LOGGER.info(Const.LOG_BEGIN_SERVICE + UriParam.EVENT_GET_WITH_ID);
            Event event = null;
            if (ObjectUtil.isNotEmpty(id)){
                event = eventRepository.findEventById(id);
                if (ObjectUtil.isEmpty(event)) {
                    throw new StmtyException("No data");
                }
            }
            return event;
        } finally {
            LOGGER.info(Const.LOG_END_SERVICE + UriParam.EVENT_GET_WITH_ID);
        }
    }

    @Override
    public Event insert(Event event) {
        try {
            LOGGER.info(Const.LOG_BEGIN_SERVICE + UriParam.INSERT_EVENT);
            if (!StringUtil.isEmpty(event.getImage())) {
                event.setImage(UtilBase64Image.encoder(event.getImage()));
            }
            event.setDate(new Date());
            Event result = eventRepository.save(event);
            LOGGER.debug(result.toString());
            return result;
        } finally {
            LOGGER.info(Const.LOG_END_SERVICE + UriParam.INSERT_EVENT);
        }
    }

    @Override
    public Event update(Event event) {
        try {
            LOGGER.info(Const.LOG_BEGIN_SERVICE + UriParam.UPDATE_EVENT);
            if (ObjectUtil.isEmpty(event.getId())) {
                throw new StmtyException("Id is not empty");
            }
            Event eventUpdated = eventRepository.findEventById(event.getId());
            eventUpdated.setDescription(event.getDescription());
            if (!StringUtil.isEmpty(event.getImage())) {
                eventUpdated.setImage(UtilBase64Image.encoder(event.getImage()));
            }
            eventUpdated.setDate(new Date());
            Event result = eventRepository.save(eventUpdated);
            LOGGER.debug(result.toString());
            return result;
        } finally {
            LOGGER.info(Const.LOG_END_SERVICE + UriParam.UPDATE_EVENT);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            LOGGER.info(Const.LOG_BEGIN_SERVICE + UriParam.DELETE_EVENT);
            if (ObjectUtil.isNotEmpty(id)){
                eventRepository.deleteById(id);
            }
        } finally {
            LOGGER.info(Const.LOG_END_SERVICE + UriParam.DELETE_EVENT);
        }
    }
}
