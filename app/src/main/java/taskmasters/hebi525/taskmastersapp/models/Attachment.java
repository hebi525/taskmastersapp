package taskmasters.hebi525.taskmastersapp.models;

/**
 * Created by hebi525 on 12-Jul-16.
 */
public class Attachment {
    private String username;
    private String fileName;
    private String timeStamp;

    public Attachment(String username, String fileName, String timeStamp){
        this.username = username;
        this.fileName = fileName;
        this.timeStamp = timeStamp;
    }

    public String getUsername() {
        return username;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
