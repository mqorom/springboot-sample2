package com.exalt.trainingproject.repository;

import com.exalt.trainingproject.model.Machine;
import com.exalt.trainingproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine, String> {

   List<Machine> findAllByUser(User user);

   @Transactional
   void deleteByUser(User user);
   // Read about the need of Transactional in this article https://www.wilfriedbarth.com/til/2018-03-31-spring-transactional-annotation/

}
