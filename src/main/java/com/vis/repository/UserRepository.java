package com.vis.repository;

import com.vis.domain.Member;
import com.vis.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by otto on 2016-01-07.
 */
public interface UserRepository extends CrudRepository<User, String> {

}
