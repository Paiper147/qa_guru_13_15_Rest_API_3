package homelombok.lombokModels;

import lombok.Data;

@Data
public class RegisterRequestBody {
    private String email;
    private String password;
}
