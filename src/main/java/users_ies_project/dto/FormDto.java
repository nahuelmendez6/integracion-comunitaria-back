package users_ies_project.dto;

public class FormDto {
    private Integer idForm;
    private String name;
    private String userCreateName;
    private String userUpdateName;

    public FormDto(Integer idForm, String name, String userCreateName, String userUpdateName) {
        this.idForm           = idForm;
        this.name             = name;
        this.userCreateName   = userCreateName;
        this.userUpdateName   = userUpdateName;
    }

    public Integer getIdForm()           { return idForm; }
    public String  getName()             { return name;   }
    public String  getUserCreateName()   { return userCreateName; }
    public String  getUserUpdateName()   { return userUpdateName; }
}
