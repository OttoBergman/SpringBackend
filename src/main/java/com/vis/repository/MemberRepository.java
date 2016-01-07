package com.vis.repository;

import com.vis.domain.Member;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by otto on 2016-01-07.
 */
public interface MemberRepository extends CrudRepository<Member, Long> {

}
