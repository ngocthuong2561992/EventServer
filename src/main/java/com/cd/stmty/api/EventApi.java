package com.cd.stmty.api;

import com.cd.stmty.model.ApiResponse;
import com.cd.stmty.model.BaseListRequest;
import com.cd.stmty.model.Event;
import com.cd.stmty.util.UriParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping(value = UriParam.EVENT)
public interface EventApi {

    @RequestMapping(value = UriParam.LIST_EVENT, method = RequestMethod.GET)
    ApiResponse<Page<Event>> list(BaseListRequest request);

    @RequestMapping(value = UriParam.EVENT_GET_WITH_ID, method = RequestMethod.GET)
    ApiResponse<Event> getById(@PathVariable(value = UriParam.ID) Long id);

    @RequestMapping(value = UriParam.INSERT_EVENT, method = RequestMethod.POST)
    ApiResponse<Event> insert(@RequestBody Event event);

    @RequestMapping(value = UriParam.UPDATE_EVENT, method = RequestMethod.PUT)
    ApiResponse<Event> update(@RequestBody Event event);

    @RequestMapping(value = UriParam.DELETE_EVENT, method = RequestMethod.DELETE)
    ApiResponse<Boolean> delete(Long postId);
}
