package homelombok.lombokModels;

import lombok.Data;

@Data
public class UserDataUpdateResponseBody {
    private String name;
    private String job;
    private String updatedAt;
}
