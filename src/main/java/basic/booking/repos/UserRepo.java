package basic.booking.repos;

import basic.booking.domain.Role;
import basic.booking.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String login);

    List<User> findAllByRoles(Role role);

}
