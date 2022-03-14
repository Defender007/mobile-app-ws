package com.tryspringboot.app.ws;


import com.tryspringboot.app.ws.io.entity.UserEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Remove @RepositoryRestResource below to disable auto REST api:
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
    UserEntity findByEmail(String email);
}