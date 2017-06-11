package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by vagrant on 6/9/17.
 */

public interface RunningInformationService {
    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations);

    void deleteAll();

    Page<RunningInformation> findByRunningId(String runningId, Pageable pageable);

    Page<RunningInformation> findByUserInfoUsername(String userInfo, Pageable pageable);

    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);


    // delete by running id
    void deleteByRunningId(String runningId);

}
