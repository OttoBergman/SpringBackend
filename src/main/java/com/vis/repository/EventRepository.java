package com.vis.repository;

import com.vis.domain.Event;
import com.vis.domain.Member;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by otto on 2016-01-07.
 */
public interface EventRepository extends CrudRepository<Event, Long> {

}