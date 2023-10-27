package JsonParse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: AddConsumables
 * @author: ChenLun
 * @date: 2023/2/20 18:29
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddConsumables {

    private String materialId;

    private Integer quantity;
}
