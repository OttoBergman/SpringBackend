package com.vis.repository;

import com.vis.domain.Event;
import com.vis.domain.MemberEvents;
import com.vis.keys.MemberEventsKey;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by otto on 2016-01-07.
 */
public interface MemberEventsRepository extends CrudRepository<MemberEvents, MemberEventsKey> {

}