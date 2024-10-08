package server.database;

import commons.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, String>{
    boolean existsByInviteCode(String inviteCode);
    Optional<Event> findByInviteCode(String inviteCode);
    void deleteByInviteCode(String inviteCode);
}
