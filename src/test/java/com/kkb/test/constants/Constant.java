package com.kkb.test.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Constant {
	public static String GXB = "gaoxiaobang";
	public static String GCU = "gcu";//华南理工大学|广州学院


	public static Map<String, String> MAP = new HashMap<String, String>();
	public static ArrayList<String> suites = new ArrayList<String>();
	/**
	 * productInfo
	 */
	public static String TEST_PRODUCT_B2B_NAME = "小跃赠品勿动070803";
	public static String TEST_PRODUCT_B2B_ID = "2718226655043059";
	public static String TEST_PRODUCT_B2C_NAME = "小跃赠品勿动070803";
	public static String TEST_PRODUCT_B2C_ID = "2718226655043059";
	
	public static String SIT_PRODUCT_B2B_NAME = "德国 Lausitzer Häusel 德国老房子";
	public static String SIT_PRODUCT_B2B_ID = "2364640301915193";
	public static String SIT_PRODUCT_B2C_NAME = "德国 Lausitzer Häusel 德国老房子";
	public static String SIT_PRODUCT_B2C_ID = "2364640301915193";
	/**
	 * system
	 */
	public static String SUPPLIER = "supplier";
	public static String RETAILER = "retailer";
	public static String DEALER = "dealer";
	public static String PLATFORM = "platform";
	public static String CATEGORY = "category";
	public static String WAP = "wap";
	public final static String TESTNGLISTENER = "TestNGListener";

	/**
	 * wofe
	 */
	public static final String TEST_PLARFORM_CREATE_ACTIVITY_FAIL ="wofe创建活动测试用例失败";
	public static final String TEST_PLATFORM_SINGLEHE__FIAL = "wofo合单的测试用例执行 失败 ！";
	public static final String TEST_PLATFORM_SINGLE__FIAL = "wofo分单的测试用例执行 失败 ！";
	public static final String TEST_PLARFORM_PLATFORM_TEST_FAIL = "wofe催缴余款测试用例失败！";
	public static final String TEST_PLATFORM_BRAND_AUDIT__FIAL = "wofe -- 用户中心 -- 审核管理 -- 品牌审核测试用例失败！";
	public static final String TEST_PLARFORM_ADD_WAREHOUSE_FAIL = "wofe-商品管理-仓库管理-新加仓库测试用例失败！";
	public static final String TEST_PLARFORM_UPDATE_WAREHOUSE_FAIL = "wofe-商品管理-仓库管理-修改仓库测试用例失败！";
	public static final String TEST_PLARFORM_UPDATE_STOCK_FAIL = "wofe-商品管理-库存管理-修改库存测试用例失败！";
	public static final String TEST_PLARFORM_LOCK_STOCK_FAIL = "wofe-商品管理-库存管理-锁定库存测试用例失败！";
	public static final String TEST_PLARFORM_ADD_FREIGHT_TEMPLATE_FAIL = "wofe--物流管理--平台运费模板--创建运费模板测试用例失败！";
	public static final String TEST_PLARFORM_ADD_LOGISTCS_FREIGHT_TEMPLATE_FAIL = "wofe--物流管理--物流商管理--创建运费模板测试用例失败！";
	public static final String TEST_PLARFORM_UPDATE_LOGISTCS_FREIGHT_TEMPLATE_FAIL = "wofe--物流管理--物流商管理--修改运费模板测试用例失败！";
	public static final String TEST_PLARFORM_UPDATE_FREIGHT_TEMPLATE_FAIL = "wofe--物流管理--平台运费模板--修改运费模板测试用例失败！";
	public static final String TEST_PLARFORM_ADD_CASH_COUPON_FAIL = "wofe-促销管理-创建优惠券中的现金卷测试用例失败！";
	/**
	 * retailer
	 */
	public static final String TEST_SUBMITORDER_SEARCH__FIAL = "搜索商品正常下单并提交到收银台失败";
	public static final String TEST_RETAILER_REGIST_RETAILER__FIAL = "零售商注册用户失败！";
	public static final String TEST_RETAILER_BLANCE_PAYMENT_TEST_FAIL = "pc retailer 零售商支付余款用例失败！";
	public static final String TEST_RETAILER_CANCEL_ORDER_FAIL = "pc retailer 我的鑫网-我的订单-取消订单用例失败！";
	public static final String TEST_RETAILER_CONTACT_CUSTOMER_FAIL = "pc 我的鑫网-客户服务-联系客服用例失败！";
	public static final String TEST_RETAILER_ADD_NEW_ROLE_FAIL = "我的鑫网-我的订单-账户中心-新增角色用例失败！";
	public static final String TEST_RETAILER_DEL_ROLE_FAIL = "我的鑫网-我的订单-账户中心-删除角色用例失败！";
	public static final String TEST_RETAILER_UPDATE_ROLE_FAIL = "我的鑫网-我的订单-账户中心-修改角色用例失败！";
	public static final String TEST_RETAILER_ADD_PRIVILEGE_FOR_ROLE_FAIL = "我的鑫网-我的订单-账户中心-为角色分配权限用例失败！";
	public static final String TEST_RETAILER_ADD_USER_FAIL = "我的鑫网-我的订单-账户中心-用户管理-新增用户用例失败！";
	public static final String TEST_RETAILER_DEL_USER_FAIL = "我的鑫网-我的订单-账户中心-用户管理-删除用户用例失败！";
	public static final String TEST_RETAILER_UPDATE_USER_FAIL = "我的鑫网-我的订单-账户中心-用户管理-修改用户用例失败！";
	public static final String TEST_RETAILER_UPDATE_BUSINESS_INFO_FAIL = "我的鑫网-我的订单-账户中心-修改商户信息用例失败！";
	public static final String TEST_RETAILER_ADD_SHOPPING_CART_FAIL = "零售商--下单-加入购物车测试用例执行失败！";
	public static final String TEST_RETAILER_ADD_FUTURE_SHOPPING_CART_FAIL = "零售商--期货下单-加入购物车测试用例执行失败！";
	public static final String TEST_RETAILER_DELETE_ORDER_FROM_SHOPPING_CART_FAIL = "零售商-购物车订单删除测试用例执行失败！";
	public static final String TEST_RETAILER_USE_AND_VIEW_COUPON_FAIL = "零售商-我的订单-我的资产优惠券-查看现金卷及使用现金卷测试用例执行失败 ！";
	public static final String TEST_RETAILER_USE_COUPON_FAIL = "pc零售商-我的资产优惠券-使用优惠券测试用例执行失败 ！";
	/**
	 * dealer
	 */
	public static final String TEST_DEALER_PLACE_ORDER__FIAL = "经销商下单填写合同测试失败 ！";
	public static final String TEST_DEALER_CONFIRM_CONTRACT_ORDER_FAIL = "经销商确认合同测试失败！";
	public static final String TEST_DEALER_RECEIPT__FIAL = "dealer reveiving 测试用例执行失败 ！";
	
	/**
	 * supplier
	 */
	public static final String TEST_SUPPLIER_PLACE_ORDER_FAIL =	"pc supplier 填写合同测试失败！";
	public static final String TEST_SUPPLIER_CONFIRM_CONTRACT_ORDER_FAIL =	"pc supplier 确认合同测试失败！";
	public static final String TEST_DEALER_SEND_GOODS_ORDER_FAIL =	"供应商发货测试失败！";
	public static final String TEST_SUPPLIER_NEW_BRAND_FAIL =	"supplier 品牌管理-新建品牌测试用例失败！";
	public static final String TEST_SUPPLIER_DEL_BRAND_FAIL =	"supplier 品牌管理-删除品牌测试用例失败！";
	public static final String TEST_SUPPLIER_UPDATE_BRAND_FAIL =	"supplier 品牌管理-修改测试用例失败！";
	public static final String TEST_SUPPLIER_SEARCH_WAITING_CONFIRM_FAIL =	"test pc supplier 已卖出的物品--所有订单测试用例执行失败！";
	public static final String TEST_SUPPLIER_WAITING_SHIP_FAIL =	"test pc supplier 已卖出的物品--等待发货测试用例执行失败！";
	public static final String TEST_SUPPLIER_SHIPED_GOODS_FAIL =	"test pc supplier 已卖出的物品--已发货测试用例执行失败！";
	public static final String TEST_SUPPLIER_COMPLETED_GOODS_FAIL =	"test pc supplier 已卖出的物品--已完成测试用例执行失败！";
	public static final String TEST_SUPPLIER_UPDATE_BASE_INFO_FAIL = "test pc supplier 用户中心--信息管理--基本信息管理--修改基本信息测试用例执行失败！";
}
