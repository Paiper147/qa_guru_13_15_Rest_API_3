package homelombok.lombokModels;

import lombok.Data;

@Data
public class CreateResponseBody {
    private String name;
    private String job;
    private String id;
    private String createdAt;
}
