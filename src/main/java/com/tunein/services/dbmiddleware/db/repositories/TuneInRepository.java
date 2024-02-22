package com.tunein.services.dbmiddleware.db.repositories;

import com.tunein.services.dbmiddleware.db.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuneInRepository extends JpaRepository<User, Integer>{
//    User findById(String id);
//    User save(User user);
}
