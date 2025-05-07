package users_ies_project.dto;

public class UserDto {
    private Integer idUser;
    private String name;
    private String email;

    public UserDto(Integer idUser, String name, String email) {
        this.idUser  = idUser;
        this.name     = name;
        this.email    = email;
    }
    public Integer getIdUser() { return idUser; }
    public String  getName()   { return name;   }
    public String  getEmail()  { return email;  }
}
