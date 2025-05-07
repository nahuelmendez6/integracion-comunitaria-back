package users_ies_project.dto;

public class SecurityProfileGroupDto {
    private Integer idSecurityProfileGroup;
    private String name;
    private String profileName;
    private String moduleName;
    private String userCreateName;
    private String userUpdateName;

    public SecurityProfileGroupDto(
        Integer idSecurityProfileGroup,
        String name,
        String profileName,
        String moduleName,
        String userCreateName,
        String userUpdateName
    ) {
        this.idSecurityProfileGroup = idSecurityProfileGroup;
        this.name                   = name;
        this.profileName            = profileName;
        this.moduleName             = moduleName;
        this.userCreateName         = userCreateName;
        this.userUpdateName         = userUpdateName;
    }

    public Integer getIdSecurityProfileGroup() { return idSecurityProfileGroup; }
    public String  getName()                   { return name;                   }
    public String  getProfileName()            { return profileName;            }
    public String  getModuleName()             { return moduleName;             }
    public String  getUserCreateName()         { return userCreateName;         }
    public String  getUserUpdateName()         { return userUpdateName;         }
}
