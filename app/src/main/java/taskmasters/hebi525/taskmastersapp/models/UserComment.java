package taskmasters.hebi525.taskmastersapp.models;

/**
 * Created by hebi525 on 6/20/2016.
 */
public class UserComment {
    private int imageRes;
    private String username;
    private String commentText;
    private String timeStamp;
    private int type;

    public UserComment(int imageRes, String username, String commentText, String timeStamp, int type){
        this.imageRes = imageRes;
        this.username = username;
        this.commentText = commentText;
        this.timeStamp = timeStamp;
        this.type = type;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getUsername() {
        return username;
    }

    public String getCommentText() {
        return commentText;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
