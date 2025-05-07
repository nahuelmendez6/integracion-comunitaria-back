package users_ies_project.dto;

public class SecurityModuleUserDto {
    private Integer idSecurityModuleUser;
    private String state;
    private String formName;
    private String userName;
    private String userCreateName;
    private String userUpdateName;

    public SecurityModuleUserDto(
        Integer idSecurityModuleUser,
        String state,
        String formName,
        String userName,
        String userCreateName,
        String userUpdateName
    ) {
        this.idSecurityModuleUser = idSecurityModuleUser;
        this.state                = state;
        this.formName             = formName;
        this.userName             = userName;
        this.userCreateName       = userCreateName;
        this.userUpdateName       = userUpdateName;
    }

    public Integer getIdSecurityModuleUser() { return idSecurityModuleUser; }
    public String  getState()                { return state;                }
    public String  getFormName()             { return formName;             }
    public String  getUserName()             { return userName;             }
    public String  getUserCreateName()       { return userCreateName;       }
    public String  getUserUpdateName()       { return userUpdateName;       }
}
