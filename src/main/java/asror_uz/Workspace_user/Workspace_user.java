package asror_uz.Workspace_user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workspace_user {

    private Long id;
    private Long workspace_id;
    private Long user_id;
    private Long workspace_role_id;
    private String date_invited;
    private String date_joined;
}