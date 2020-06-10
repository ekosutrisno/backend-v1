package app.xsis.repository;

import app.xsis.models.master.StatusPernikahanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusPernikahanRepository extends JpaRepository<StatusPernikahanEntity,Long> {
}
