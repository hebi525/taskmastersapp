package taskmasters.hebi525.taskmastersapp.models;

/**
 * Created by hebi525 on 05-Jul-16.
 */
public class Project {
    private String projectName;
    private String projectPrice;
    private String projectStatus;

    public Project(String projectName, String projectPrice, String projectStatus){
        this.projectName = projectName;
        this.projectPrice = projectPrice;
        this.projectStatus = projectStatus;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectPrice() {
        return projectPrice;
    }

    public String getProjectStatus() {
        return projectStatus;
    }
}
