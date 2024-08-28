/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entities.Department;
import entities.Eglise;
import entities.Member;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;
import java.util.List;

/**
 *
 * @author steph18
 */

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {

    @Query("WHERE m.eglise = :eglise AND m.person.department = :department")
    List<Member> getByEgliseDepartment(Eglise eglise, Department department);

}
