package taskmasters.hebi525.taskmastersapp.models;

/**
 * Created by hebi525 on 19-Jul-16.
 */
public class Contact {
    private int imageRes;
    private String contactName;
    private int status; //online=0, offline=1

    public Contact(int imageRes, String contactName){
        this.imageRes = imageRes;
        this.contactName = contactName;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getContactName() {
        return contactName;
    }

    public int getStatus() {
        return status;
    }
}
