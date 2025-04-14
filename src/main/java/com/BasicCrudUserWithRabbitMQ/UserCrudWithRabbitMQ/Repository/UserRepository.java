package com.BasicCrudUserWithRabbitMQ.UserCrudWithRabbitMQ.Repository;

import com.BasicCrudUserWithRabbitMQ.UserCrudWithRabbitMQ.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
