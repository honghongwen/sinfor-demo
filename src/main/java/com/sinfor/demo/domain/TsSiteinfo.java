package com.sinfor.demo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author fengwen
 * @since 2022-05-10
 */
@Data
@TableName("TS_SITEINFO")
public class TsSiteinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String siteid;

    private String sitename;

    private String wbcode;

    private String pycode;

    private String paysite;

    private String paycenter;

    /**
     * 0：信丰总部
     * 1：网管财务中心
     * 2：分拔中心
     * 3：营业网点
     * 4：虚拟车线 7.呼叫中心
     */
    private BigDecimal typeid;

    /**
     * 信丰总部为0，其它一级级累加
     */
    private BigDecimal levelid;

    /**
     * tsUSER.UserID
     */
    private String enteruser;

    private LocalDateTime enterdate;

    /**
     * 0：未审核，1：已审核，默认值为0
     * 其它说明
     */
    private BigDecimal flag;

    /**
     * 0：未启用过;1：已启用过，默认值为0
     */
    private BigDecimal useflag;

    /**
     * tsUSER.UserID
     */
    private String checkuser;

    private LocalDateTime checkdate;

    private String managers;

    /**
     * 1：直营
     * 2：加盟
     * 3：其它
     */
    private BigDecimal busimode;

    private LocalDateTime adddate;

    private String phone;

    private String address;

    private String sendarea;

    private String ofsection;

    private String memotext;

    private String modifyuser;

    private LocalDateTime modifytime;

    private String province;

    private String city;

    private String county;

    private BigDecimal contmode;

    /**
     * 0:正常,1:暂停
     */
    private Integer ispause;

    private BigDecimal qday;

    /**
     * 暂停开始时间
     */
    private LocalDateTime pausetime;

    private String urladdr;

    private String oldid;

    private String shortid;

    /**
     * 所属网点
     */
    private String ofsite;

    /**
     * 业务报表是否显示;1:显示0:不显示
     */
    private BigDecimal reportflag;

    /**
     * 货款网银账户
     */
    private String goodsbankid;

    /**
     * 客服中心编号
     */
    private String custservid;

    /**
     * 网点、承包区所属上级 (总部、中心默认自己,原资料需要手工更新)
     */
    private String ofcenter;

    /**
     * 当TYPEID=8 创建网点承包区生效  ,同时LEVELID当TYPEID=8为空 ,兼容同步到平面网点承包区模式  (级别0开始)
     */
    private String conlevel;

    /**
     * 1网点模式(网点形式创建员工资料等等) 0平面模式(根据PAYSITE OFCENTER OFLEVL 同步记录到ts_Dept)
     */
    private BigDecimal sitemode;

    /**
     * 所属上级名称
     */
    private String ofcentername;

    private String ofmanagearea;

    private Long updversion;

}
