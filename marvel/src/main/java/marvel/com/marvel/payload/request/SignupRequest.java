package marvel.com.marvel.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import marvel.com.marvel.entities.Privilege;

@Getter
@Setter
public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    private Privilege role;
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
