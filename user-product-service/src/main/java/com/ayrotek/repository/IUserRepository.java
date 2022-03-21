package com.ayrotek.repository;

import com.ayrotek.repository.entity.Product;
import com.ayrotek.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
