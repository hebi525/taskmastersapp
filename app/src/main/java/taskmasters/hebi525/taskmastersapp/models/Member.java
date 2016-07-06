package taskmasters.hebi525.taskmastersapp.models;

/**
 * Created by hebi525 on 07-Jul-16.
 */
public class Member {
    private String name;
    private String lastActivityTime;

    public Member(String name, String lastActivity){
        this.name = name;
        this.lastActivityTime = lastActivity;
    }

    public String getName() {
        return name;
    }

    public String getLastActivityTime() {
        return lastActivityTime;
    }
}
