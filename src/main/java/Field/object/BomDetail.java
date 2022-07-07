package Field.object;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @className: BomDetailDO
 * @author: ChenLun
 * @date: 2022/4/21 17:47
 * @description: Bom详情对象
 */
@Data
public class BomDetail {

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("编码")
    private String code;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("规格")
    private String specs;

    @ApiModelProperty("子物料列表")
    @Field("children_material")
    private List<BomDetail> childrenMaterial;

    @ApiModelProperty("推介厂商（供应商）")
    @Field("price_infos")
    private List<PriceInfo> priceInfos;

    @ApiModelProperty("一级行业分类")
    @Field("industry_category")
    private String industryCategory;

    @ApiModelProperty("二级行业分类")
    @Field("industry_specific")
    private String industrySpecific;

    @ApiModelProperty("三级行业分类")
    @Field("industry_trade")
    private String industryTrade;

    @ApiModelProperty("四级行业分类")
    @Field("industry_subclass")
    private String industrySubclass;
}
