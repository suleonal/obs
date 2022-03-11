package tr.com.argela.obs.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoggedUser extends User {

    private long entityId;
    private String entityName;

}
