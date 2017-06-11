package demo.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

/**
 * Created by vagrant on 6/9/17.
 */
@Entity //map to RunningInformation table
@Table(name = "RUNNING_ANALYSIS")
@Data
public class RunningInformation {

    public enum HealthWarningLevel{
        LOW, NORMAL, HIGH
    }

    @Id
    @GeneratedValue
    private Long id; //really need id here? can use runningId instead?

    private String runningId;
    @JsonIgnore
    private double latitude;
    @JsonIgnore
    private double longitude;
    @JsonIgnore
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate;
    @JsonIgnore
    private Date timestamp = new Date();
    private HealthWarningLevel healthWarningLevel;


    public int getHeartRate(){
        // Generate a random number between 60 and 200
        Random r = new Random();
        int lo = 60;
        int hi = 201;
        this.heartRate = r.nextInt(hi-lo) + lo;
        return this.heartRate;
    }



    public HealthWarningLevel getHealthWarningLevel() {
        if(heartRate >= 60 && heartRate <= 75){
            return HealthWarningLevel.LOW;
        }else if(heartRate > 75 && heartRate <= 120){
            return HealthWarningLevel.NORMAL;
        }else{
            return HealthWarningLevel.HIGH;
        }
    }


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "userInfo_username")),
            @AttributeOverride(name = "address", column = @Column(name = "userInfo_address"))
    })
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserInfo userInfo;

    public RunningInformation(){

    }

    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId){
        this.runningId = runningId;
    }

    public RunningInformation(UserInfo userInfo){
        this.userInfo = userInfo;
    }

    public String getUsername(){
        return this.userInfo == null ? null : this.userInfo.getUsername();
    }

    public String getAddress() {
        return this.userInfo == null ? null : this.userInfo.getAddress();
    }


}