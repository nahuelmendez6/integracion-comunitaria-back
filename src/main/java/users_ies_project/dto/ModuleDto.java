package users_ies_project.dto;

public class ModuleDto {
    private Integer idModule;
    private String name;
    private String description;
    private String security;
    private String administration;
    private String commercial;
    private String marketing;
    private String userCreateName;
    private String userUpdateName;

    public ModuleDto(
        Integer idModule,
        String name,
        String description,
        String security,
        String administration,
        String commercial,
        String marketing,
        String userCreateName,
        String userUpdateName
    ) {
        this.idModule         = idModule;
        this.name             = name;
        this.description      = description;
        this.security         = security;
        this.administration   = administration;
        this.commercial       = commercial;
        this.marketing        = marketing;
        this.userCreateName   = userCreateName;
        this.userUpdateName   = userUpdateName;
    }

    public Integer getIdModule()           { return idModule; }
    public String  getName()               { return name;       }
    public String  getDescription()        { return description;}
    public String  getSecurity()           { return security;   }
    public String  getAdministration()     { return administration; }
    public String  getCommercial()         { return commercial; }
    public String  getMarketing()          { return marketing;  }
    public String  getUserCreateName()     { return userCreateName; }
    public String  getUserUpdateName()     { return userUpdateName; }
}
