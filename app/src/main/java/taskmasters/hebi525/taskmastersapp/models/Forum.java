package taskmasters.hebi525.taskmastersapp.models;

/**
 * Created by hebi525 on 28-Jul-16.
 */
public class Forum {
    private String forumName;
    private String forumText;
    private String forumText1;

    public Forum(String forumName, String forumText, String forumText1){
        this.forumName = forumName;
        this.forumText = forumText;
        this.forumText1 = forumText1;
    }

    public String getForumName() {
        return forumName;
    }

    public String getForumText() {
        return forumText;
    }

    public String getForumText1() {
        return forumText1;
    }
}
