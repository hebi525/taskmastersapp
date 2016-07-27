package taskmasters.hebi525.taskmastersapp.models;

import android.view.GestureDetector;

/**
 * Created by hebi525 on 28-Jul-16.
 */
public class GroupMember {
    private String groupMemberName;
    private String groupMemberRankText;

    public GroupMember(String groupMemberName, String groupMemberRankText){
        this.groupMemberName = groupMemberName;
        this.groupMemberRankText = groupMemberRankText;
    }

    public String getGroupMemberName() {
        return groupMemberName;
    }

    public String getGroupMemberRankText() {
        return groupMemberRankText;
    }
}
