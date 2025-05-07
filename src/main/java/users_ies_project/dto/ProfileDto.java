package users_ies_project.dto;

public class ProfileDto {
    private Integer idProfile;
    private String name;
    private Boolean admin;
    private String userCreateName;
    private String userUpdateName;

    public ProfileDto(
        Integer idProfile,
        String name,
        Boolean admin,
        String userCreateName,
        String userUpdateName
    ) {
        this.idProfile        = idProfile;
        this.name             = name;
        this.admin            = admin;
        this.userCreateName   = userCreateName;
        this.userUpdateName   = userUpdateName;
    }

    public Integer getIdProfile()         { return idProfile; }
    public String  getName()              { return name;      }
    public Boolean getAdmin()             { return admin;     }
    public String  getUserCreateName()    { return userCreateName; }
    public String  getUserUpdateName()    { return userUpdateName; }
}
