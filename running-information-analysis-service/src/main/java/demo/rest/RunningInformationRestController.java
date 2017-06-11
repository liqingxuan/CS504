package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/9/17.
 */
@RestController
public class RunningInformationRestController {

    private RunningInformationService runningInformationService;

    @Autowired
    public RunningInformationRestController(RunningInformationService runningInformationService){
        this.runningInformationService = runningInformationService;
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    public void upload(@RequestBody List<RunningInformation> runningInformations){
        this.runningInformationService.saveRunningInformation(runningInformations);
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    public Page<RunningInformation> findAllByOrderByHeartRateDesc(@RequestParam(name = "page") int page){
        return this.runningInformationService.findAllByOrderByHeartRateDesc(new PageRequest(page,2));
    }

    @RequestMapping(value = "/runningInfo/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable String runningId){
        this.runningInformationService.deleteByRunningId(runningId);
    }

}
