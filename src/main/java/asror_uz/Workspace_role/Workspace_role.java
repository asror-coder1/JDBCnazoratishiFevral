package asror_uz.Workspace_role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workspace_role {
    private Long id;
    private Long worksapce_id;
    private String name;
    private String extends_role;
}
