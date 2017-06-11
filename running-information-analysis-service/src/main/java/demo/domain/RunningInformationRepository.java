package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by vagrant on 6/9/17.
 */
// write JPA query here.
public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long> {
    Page<RunningInformation> findByRunningId(@Param("runningId") String runningId, Pageable pageable);

    Page<RunningInformation> findByUserInfoUsername(@Param("username") String username, Pageable pageable);

    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);

    //void deleteByRunningId (@Param("runningId") String runningId);

    @Transactional
    void deleteRunningInformationsByRunningId (@Param("runningId") String runningId);
}
