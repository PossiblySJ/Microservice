package com.samjain.project.CrudOperations.Repo;
import com.samjain.project.CrudOperations.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
