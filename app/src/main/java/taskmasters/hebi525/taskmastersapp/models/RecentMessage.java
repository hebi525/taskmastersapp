package taskmasters.hebi525.taskmastersapp.models;

/**
 * Created by hebi525 on 25-Jul-16.
 */
public class RecentMessage {
    private String contactName;
    private String text;

    public RecentMessage(String contactName, String text){
        this.contactName = contactName;
        this.text = text;
    }

    public String getContactName() {
        return contactName;
    }

    public String getText() {
        return text;
    }
}
