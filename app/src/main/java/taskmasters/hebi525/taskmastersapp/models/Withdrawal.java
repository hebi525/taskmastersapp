package taskmasters.hebi525.taskmastersapp.models;

/**
 * Created by hebi525 on 28-Jul-16.
 */
public class Withdrawal {
    private String date;
    private double amount;
    private int status; //0=pending 1=released

    public Withdrawal(String date, double amount, int status){
        this.date = date;
        this.amount = amount;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public int getStatus() {
        return status;
    }
}
