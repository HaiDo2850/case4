package com.example.demo.repository;

import com.example.demo.model.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamDetailRepository extends JpaRepository<TeamDetail, Long> {
    @Query("select t from TeamDetail t where t.role = :role order by t.user.id")
    List<TeamDetail> findUserByRole(String role);

    @Query("select t from TeamDetail t where t.user.id = :id and t.role = :role ")
    List<TeamDetail> findTeamByUser(Long id , String role);

}
