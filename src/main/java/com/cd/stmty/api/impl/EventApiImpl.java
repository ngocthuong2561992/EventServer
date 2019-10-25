package com.cd.stmty.api.impl;

import com.cd.stmty.api.EventApi;
import com.cd.stmty.exception.StmtyException;
import com.cd.stmty.model.ApiResponse;
import com.cd.stmty.model.BaseListRequest;
import com.cd.stmty.model.Event;
import com.cd.stmty.services.EventService;
import com.cd.stmty.util.Const;
import com.cd.stmty.util.ObjectUtil;
import com.cd.stmty.util.UriParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class EventApiImpl implements EventApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventApiImpl.class);

    @Autowired
    private EventService eventService;

    @Override
    public ApiResponse<Page<Event>> list(BaseListRequest request) {
        try {
            LOGGER.info(Const.LOG_BEGIN_API + UriParam.LIST);
            Page<Event> posts = eventService.getAll(request);
            return new ApiResponse<>(posts);
        } finally {
            LOGGER.info(Const.LOG_END_API + UriParam.LIST);
        }
    }

    @Override
    public ApiResponse<Event> insert(@RequestBody Event event) {
        try {
            LOGGER.info(Const.LOG_BEGIN_API + UriParam.INSERT_EVENT);
            Event result = eventService.insert(event);
            return new ApiResponse<>(result);
        } finally {
            LOGGER.info(Const.LOG_END_API + UriParam.INSERT_EVENT);
        }
    }

    @Override
    public ApiResponse<Event> update(@RequestBody Event event) {
        try {
            LOGGER.info(Const.LOG_BEGIN_API + UriParam.UPDATE_EVENT);
            Event result = eventService.update(event);
            return new ApiResponse<>(result);
        } finally {
            LOGGER.info(Const.LOG_END_API + UriParam.UPDATE_EVENT);
        }
    }

    @Override
    public ApiResponse<Boolean> delete(Long eventId) {
        try {
            LOGGER.info(Const.LOG_BEGIN_API + UriParam.DELETE);
            eventService.delete(eventId);
            return new ApiResponse<>(true);
        } finally {
            LOGGER.info(Const.LOG_END_API + UriParam.DELETE);
        }
    }

    @Override
    public ApiResponse<Event> getById(@PathVariable(value = UriParam.ID) Long id) {
        try {
            LOGGER.info(Const.LOG_BEGIN_API + UriParam.EVENT_GET_WITH_ID);
            if (ObjectUtil.isEmpty(id)) {
                throw new StmtyException("Id not empty");
            }
            Event result = eventService.getById(id);
            return new ApiResponse<>(result);
        } finally {
            LOGGER.info(Const.LOG_END_API + UriParam.EVENT_GET_WITH_ID);
        }
    }
}
