package br.edu.utfpr.pb.pw25s.server.repository;

import br.edu.utfpr.pb.pw25s.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    User findUserByEmailAndToken(String email, String token);

    boolean existsByEmail(String email);

    @Modifying
    @Query("update User set token=?2 where id=?1")
    int updateUserTokenById(Long id, String token);

}
