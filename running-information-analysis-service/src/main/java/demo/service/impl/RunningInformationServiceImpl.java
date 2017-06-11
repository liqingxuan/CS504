package demo.service.impl;

import com.sun.scenario.effect.impl.prism.ps.PPSBlend_ADDPeer;
import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vagrant on 6/9/17.
 */

@Service
@Transactional
public class RunningInformationServiceImpl implements RunningInformationService{

    private RunningInformationRepository runningInformationRepository;

    @Autowired
    public RunningInformationServiceImpl(RunningInformationRepository runningInformationRepository){
        this.runningInformationRepository = runningInformationRepository;
    }

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations) {
        return runningInformationRepository.save(runningInformations);
    }

    @Override
    public void deleteAll() {
        runningInformationRepository.deleteAll();
    }

    @Override
    public Page<RunningInformation> findByRunningId(String runningId, Pageable pageable) {
        return runningInformationRepository.findByRunningId(runningId, pageable);
    }

    @Override
    public Page<RunningInformation> findByUserInfoUsername(String userInfo, Pageable pageable) {
        return runningInformationRepository.findByUserInfoUsername(userInfo, pageable);
    }

    @Override
    public Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable) {
        return runningInformationRepository.findAllByOrderByHeartRateDesc(pageable);
    }

    @Override
    public void deleteByRunningId(String runningId) {
        runningInformationRepository.deleteRunningInformationsByRunningId(runningId);
    }


}
