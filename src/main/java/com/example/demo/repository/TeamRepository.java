package com.example.demo.repository;

import com.example.demo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Long> {
    @Query("select t from Team t join TeamDetail td on t.id = td.team.id join User u on td.user.id = u.id where u.id= :idUser")
    List<Team> findTeamByUser(Long idUser);


}
