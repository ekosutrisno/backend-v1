package app.xsis.repository;

import app.xsis.models.master.TipeJadwalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipeJadwalRepositrory extends JpaRepository<TipeJadwalEntity,Long> {
}
