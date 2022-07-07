package Field.object;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @className: ProductDO
 * @author: ChenLun
 * @date: 2022/4/21 18:03
 * @description: 产品对象
 */
@Data
public class ProductDO {

    private String id;

    @ApiModelProperty("产品名称")
    private String name;

    @ApiModelProperty("元数据ID")
    @Field("template_id")
    private String templateId;

    @ApiModelProperty("产品版本")
    @Field("model_version_id")
    private String modelVersionId;

    @ApiModelProperty("产品描述")
    private String description;

    @ApiModelProperty("产品规格")
    private String specs;

    @ApiModelProperty("库存")
    private Long inventory;

    @ApiModelProperty("单价")
    private Double price;

    @ApiModelProperty("币种")
    private String currency;

    @ApiModelProperty("物料列表")
    private List<BomDetail> boms;

    @ApiModelProperty("产品参数")
    private List<ProductAttr> items;

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
