package com.sinfor.demo.constant;

/**
 * @author fengwen
 * @date 2022/5/10
 * @description TODO
 **/
public class ConstSiteType {

    /**
     * 总部
     */
    public static int XF_HQ = 0;

    /**
     * 财务中心
     */
    public static int XF_PAY_CENTER = 1;

    /**
     * 分拔中心
     */
    public static int XF_SCAN_CENTER = 2;

    /**
     * 财务网点
     */
    public static int XF_PAY_SITE = 3;

    /**
     * 虚拟网点
     */
    public static int XF_INVENTED_SITE = 4;

    /**
     * 虚拟车线1
     */
    public static int XF_INVENTED_CAR1 = 5;

    /**
     * 虚拟车线2
     */
    public static int XF_INVENTED_CAR2 = 6;

    /**
     * 呼叫中心
     */
    public static int XF_CALL_CENTER = 7;

    /**
     * 承包区
     */
    public static int XF_CONTRACT_AREA = 8;
    /**
     * 总部权限
     */
    public static int XF_HQ_RIGHTS = 1;
    /**
     * 财务中心
     */
    public static int XF_PAY_CENTER_RIGHTS = XF_HQ_RIGHTS * 2;
    /**
     * 分拔中心
     */
    public static int XF_SCAN_CENTER_RIGHTS = XF_PAY_CENTER_RIGHTS * 2;
    /**
     * 财务网点
     */
    public static int XF_PAY_SITE_RIGHTS = XF_SCAN_CENTER_RIGHTS * 2;
    /**
     * 虚拟网点
     */
    public static int XF_INVENTED_SITE_RIGHTS = XF_PAY_SITE_RIGHTS * 2;
    /**
     * 虚拟车线1
     */
    public static int XF_INVENTED_CAR1_RIGHTS = XF_INVENTED_SITE_RIGHTS * 2;
    /**
     * 虚拟车线2
     */
    public static int XF_INVENTED_CAR2_RIGHTS = XF_INVENTED_CAR1_RIGHTS * 2;
    /**
     * 呼叫中心
     */
    public static int XF_CALL_CENTER_RIGHTS = XF_INVENTED_CAR2_RIGHTS * 2;
    /**
     * 承包区
     */
    public static int XF_CONTRACT_AREA_RIGHTS = XF_CALL_CENTER_RIGHTS * 2;
    /**
     * 所有用户都有权限
     */
    public static int XF_ALL_RIGHTS = 511;
}
