package com.sucasasdj.app.repository;

import com.sucasasdj.app.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByLoginAndPassword(String login, String password);
}


