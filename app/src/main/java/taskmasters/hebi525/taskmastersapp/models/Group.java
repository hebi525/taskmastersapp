package taskmasters.hebi525.taskmastersapp.models;

import taskmasters.hebi525.taskmastersapp.R;

/**
 * Created by hebi525 on 03-Jul-16.
 */
public class Group {
    private int imageRes;
    private String groupName;
    private int onlineCount;
    private String lastActivityTime;

    public Group(String groupName){
        this.imageRes = R.mipmap.ic_launcher;
        this.groupName = groupName;
        this.onlineCount = 25;
        this.lastActivityTime = "3:45";
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public String getLastActivityTime() {
        return lastActivityTime;
    }
}
