package users_ies_project.dto;

public class TransactionDto {
    private Integer idTransaction;
    private String queryType;
    private String oldValue;
    private String newValue;
    private String userName;
    private String moduleName;
    private String formName;
    private String userCreateName;
    private String userUpdateName;

    public TransactionDto(
        Integer idTransaction,
        String queryType,
        String oldValue,
        String newValue,
        String userName,
        String moduleName,
        String formName,
        String userCreateName,
        String userUpdateName
    ) {
        this.idTransaction    = idTransaction;
        this.queryType        = queryType;
        this.oldValue         = oldValue;
        this.newValue         = newValue;
        this.userName         = userName;
        this.moduleName       = moduleName;
        this.formName         = formName;
        this.userCreateName   = userCreateName;
        this.userUpdateName   = userUpdateName;
    }

    public Integer getIdTransaction()     { return idTransaction;   }
    public String  getQueryType()         { return queryType;       }
    public String  getOldValue()          { return oldValue;        }
    public String  getNewValue()          { return newValue;        }
    public String  getUserName()          { return userName;        }
    public String  getModuleName()        { return moduleName;      }
    public String  getFormName()          { return formName;        }
    public String  getUserCreateName()    { return userCreateName;  }
    public String  getUserUpdateName()    { return userUpdateName;  }
}
