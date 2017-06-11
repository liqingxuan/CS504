package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * Created by vagrant on 6/9/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
public class UserInfo {

    private String username;
    private String address;

    public UserInfo(){
        this.username = "";
    }

    public UserInfo(String username){
        this.username = username;
    }

    public UserInfo(String username, String address){
        this.username = username;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }
}

