package com.csse.pms.util;

/**
 * This is the common constants file for Procurement Management System Project.
 */
public class CommonConstants {

    /** Constant for Star Cross Origin in Controller */
    public static final String STAR = "*";

    /** Constant for Request Mapping Path in Order Controller */
    public static final String ORDER_REQUEST_MAPPING = "/api/v1/order/";

    /** Constant for Request Mapping Path in Draft Order Controller */
    public static final String DRAFT_ORDER_REQUEST_MAPPING = "/api/v1/draft/";

    /** Constant for Request Mapping Path in Delivery Log Controller */
    public static final String DELIVERY_REQUEST_MAPPING = "/api/v1/delivery/";

    /** Constant for Request Mapping Path in Project Controller */
    public static final String PROJECT_REQUEST_MAPPING = "/api/v1/project/";

    /** Constant for Purchase - Mapping Path in Controller */
    public static final String POST_MAPPING_PURCHASE = "purchase";

    /** Constant for Save - Mapping Path in Controller */
    public static final String POST_MAPPING_SAVE = "save";

    /** Constant for Get - Mapping Path in Controller */
    public static final String GET_MAPPING_GET = "get";

    /** Constant for Get By ID - Mapping Path in Controller */
    public static final String GET_MAPPING_GET_BY_ID = "getById/{id}";

    /** Constant for Get By Status - Mapping Path in Controller */
    public static final String GET_MAPPING_GET_BY_STATUS = "getByStatus/{status}";

    /** Constant for Get By Site ID - Mapping Path in Controller */
    public static final String GET_MAPPING_GET_BY_SITE_ID = "getBySiteId/{id}";

    /** Constant for Get By Manager ID - Mapping Path in Controller */
    public static final String GET_MAPPING_GET_BY_MANAGER_ID = "getByManagerId/{id}";

    /** Constant for Get By Project ID - Mapping Path in Controller */
    public static final String GET_MAPPING_GET_BY_PROJECT_ID = "getByProjectId/{id}";

    /** Constant for Get By Reference No - Mapping Path in Controller */
    public static final String GET_MAPPING_GET_BY_REFERENCE_NO = "getByReferenceNo/{referenceNo}";

    /** Constant for Delete By ID - Mapping Path in Controller */
    public static final String DELETE_MAPPING_DELETE_BY_ID = "deleteById/{id}";

    /** Constant for Put Archive - Mapping Path in Controller */
    public static final String PUT_MAPPING_ARCHIVE = "archive";

    /** Constant for Put Update - Mapping Path in Controller */
    public static final String PUT_MAPPING_UPDATE = "update";

    /** Constant for Put Update Status - Mapping Path in Controller */
    public static final String PUT_MAPPING_UPDATE_STATUS = "updateStatus";

    /** Constant for Message - Order Purchase Successfully */
    public static final String ORDER_PURCHASE_SUCCESSFULLY = "Order Purchase Successfully";

    /** Constant for Message - Order Delete Successfully */
    public static final String ORDER_DELETE_SUCCESSFULLY = "Order Delete Successfully";

    /** Constant for Message - Draft Order Delete Successfully */
    public static final String ORDER_DRAFT_DELETE_SUCCESSFULLY = "Draft Order Delete Successfully";

    /** Constant for Message - Order Archive Successfully */
    public static final String ORDER_ARCHIVE_SUCCESSFULLY = "Order Archive Successfully";

    /** Constant for Message - Order Update Successfully */
    public static final String ORDER_UPDATE_SUCCESSFULLY = "Order Update Successfully";

    /** Constant for Message - Draft Order Update Successfully */
    public static final String ORDER_DRAFT_UPDATE_SUCCESSFULLY = "Draft Order Update Successfully";

    /** Constant for Message - Order Status Update Successfully */
    public static final String ORDER_STATUS_UPDATE_SUCCESSFULLY = "Order Status Update Successfully";

    /** Constant for Message - Order Save Successfully */
    public static final String ORDER_SAVE_SUCCESSFULLY = "Order Save Successfully";

    /** Constant for Message - Order Purchase Error */
    public static final String ORDER_PURCHASE_ERROR = "Order Purchase Error";

    /** Constant for Message - Order Delete Error */
    public static final String ORDER_DELETE_ERROR = "Order Delete Error";

    /** Constant for Message - Draft Order Delete Error */
    public static final String ORDER_DRAFT_DELETE_ERROR = "Draft Order Delete Error";

    /** Constant for Message - Order Archive Error */
    public static final String ORDER_ARCHIVE_ERROR = "Order Archive Error";

    /** Constant for Message - Order Update Error */
    public static final String ORDER_UPDATE_ERROR = "Order Update Error";

    /** Constant for Message - Draft Order Update Error */
    public static final String ORDER_DRAFT_UPDATE_ERROR = "Draft Order Update Error";

    /** Constant for Message - Order Status Update Error */
    public static final String ORDER_STATUS_UPDATE_ERROR = "Order Status Update Error";

    /** Constant for Message - Order Save Error */
    public static final String ORDER_SAVE_ERROR = "Order Save Error";

    /** Constant for Message - Order Doesn't Exist */
    public static final String ORDER_DOES_NOT_EXIST = "Order Does not Exist";

    /** Constant for Message - Delivery Status Save Successfully */
    public static final String DELIVERY_STATUS_SAVE_SUCCESSFULLY = "Delivery Status Save Successfully";

    /** Constant for Message - Delivery Status Delete Successfully */
    public static final String DELIVERY_STATUS_DELETE_SUCCESSFULLY = "Delivery Status Delete Successfully";

    /** Constant for Message - Delivery Status Update Successfully */
    public static final String DELIVERY_STATUS_UPDATE_SUCCESSFULLY = "Delivery Status Update Successfully";

    /** Constant for Message - Delivery Status Save Error */
    public static final String DELIVERY_STATUS_SAVE_ERROR = "Delivery Status Save Error";

    /** Constant for Message - Delivery Status Delete Error */
    public static final String DELIVERY_STATUS_DELETE_ERROR = "Delivery Status Delete Error";

    /** Constant for Message - Delivery Status Update Error */
    public static final String DELIVERY_STATUS_UPDATE_ERROR = "Delivery Status Update Error";

    /** Constant for Message - Delivery Status Doesn't Exist */
    public static final String DELIVERY_STATUS_DOES_NOT_EXIST = "Delivery Status Does not Exist";

    /** Constant for Message - Project Create Successfully */
    public static final String PROJECT_CREATE_SUCCESSFULLY = "Project Create Successfully";

    /** Constant for Message - Project Delete Successfully */
    public static final String PROJECT_DELETE_SUCCESSFULLY = "Project Delete Successfully";

    /** Constant for Message - Project Update Successfully */
    public static final String PROJECT_UPDATE_SUCCESSFULLY = "Project Update Successfully";

    /** Constant for Message - Project Create Error */
    public static final String PROJECT_CREATE_ERROR = "Project Create Error";

    /** Constant for Message - Project Update Error */
    public static final String PROJECT_DELETE_ERROR = "Project Delete Error";

    /** Constant for Message - Project Delete Error */
    public static final String PROJECT_UPDATE_ERROR = "Project Update Error";

    /** Constant for Message - Project Doesn't Exist */
    public static final String PROJECT_DOES_NOT_EXIST = "Project Does not Exist";

    /** Constant for Variable id */
    public static final String ID = "id";

    /** Constant for Variable status */
    public static final String STATUS = "status";

    /** Constant for Variable referenceNo */
    public static final String REFERENCE_NO = "referenceNo";

    /** Constant for Variable supplierId */
    public static final String SUPPLIER_ID= "supplierId";

    /** Constant for Variable itemList */
    public static final String ITEM_LIST= "itemList";

    /** Constant for Variable siteManagerId */
    public static final String SITE_MANAGER_ID= "siteManagerId";

    /** Constant for Variable managerId */
    public static final String MANAGER_ID= "managerId";

    /** Constant for Variable siteId */
    public static final String SITE_ID= "siteId";

    /** Constant for Variable projectId */
    public static final String PROJECT_ID= "projectId";

    /** Constant for Variable amount */
    public static final String AMOUNT= "amount";

    /** Constant for Variable contactDetails */
    public static final String CONTACT_DETAILS= "contactDetails";

    /** Constant for Variable comment */
    public static final String COMMENT= "comment";

    /** Constant for Variable dateTime */
    public static final String DATE_TIME= "dateTime";  

    /** Constant for Variable remark */
    public static final String REMARK= "remark";

    /** Constant for Variable projectName */
    public static final String PROJECT_NAME= "projectName";

    /** Constant for Variable description */
    public static final String DESCRIPTION= "description";

    /** Constant for Variable budget */
    public static final String BUDGET= "budget";

    /** Constant for Variable createDateTime */
    public static final String CREATE_DATE_TIME= "createDateTime";
  
    //inventory common constants    
    /** Constant for countable item base URI */
    public static final String COUNTABLE_ITEMS_BASE_PATH = "/api/inventory/countable/";
    
    /** Constant for uncountable item base URI */
    public static final String UNCOUNTABLE_ITEMS_BASE_PATH = "/api/inventory/uncountable/";
          
	  /* Constants for site */
    /* Constant for site base URI */
    public static final String SITE_BASE_PATH = "/api/site/";

    /******  Supplier Common Constants  ******/ 
    
    /** Constant for Request Mapping Path in Supplier Controller */
    public static final String SUPPLIER_REQUEST_MAPPING = "/api/v1/supplier/";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_POST_MAPPING_REGISTER = "register";
    
    /** Constant for variable response message */
    public static final String SUPPLIER_REGISTRATION_SUCCESS_MSG = "You have successfully registered!";
    
    /** Constant for variable response message */
    public static final String SUPPLIER_EMAIL_REGISTRATION_ERROR_MSG = "This mail is already taken!";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_POST_MAPPING_LOGIN = "login";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_GET_ALL = "get-all-supplier";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_GET_BY_STATUS = "get-supplier-by-status/{status}";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_STATUS = "status";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_STAUS_UPDATE_SUCCESSFULLY = "Status update successfully!";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_DOESNT_EXIST = "Supplier doesn't exist!";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_STAUS_UPDATE_ERROR = "Supplier status update error!";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_PUT_MAPPING_STATUS_UPDATE = "update-status";
    
    
    
    
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_POST_MAPPING_ADD_ITEM = "add-item";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_ADD_ITEM_SUCCESS_MSG = "Item added successfully!";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_GET_MAPPING_BY_SUPPLIER_ID = "get-item-by-supplier-id/{id}";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_DELETE_ITEM_SUCCESS_MSG = "Item deleted successfully!";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_DELETE_ITEM_ERROR_MSG = "Something went wrong!";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_DELETE_ITEM_NOT_EXIST_ERROR_MSG = "This item is not exist!";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_DELETE_MAPPING_BY_ITEM_ID = "delete-item-by-id/{id}";

    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_GET_MAPPING_BY_ITEM_ID = "get-item-by-item-id/{id}";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String ITEM_UPDATE_SUCCESSFULLY = "Item update successfully!";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String ITEM_DOESNT_EXITS = "Item not exist!";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String ITEM_UPDATE_ERROR = "Item update erro!";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String ITEM_PUT_MAPPING_BY_ITEM_ID = "edit-item";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String SUPPLIER_GET_BY_ITEM_ID = "get-item-by-id/{id}";
    
    
    
    
    
    /******  Internal user Common Constants  ******/ 
    
    /** Constant for Request Mapping Path in Supplier Controller */
    public static final String INTERNEL_USER_REQUEST_MAPPING = "/api/v1/internel-user/";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String INTERNEL_USER_POST_MAPPING_REGISTER = "register";
    
    /** Constant for variable response message */
    public static final String INTERNEL_USER_REGISTRATION_SUCCESS_MSG = "You have successfully registered!";
    
    /** Constant for variable response message */
    public static final String INTERNEL_USER_EMAIL_REGISTRATION_ERROR_MSG = "This mail is already taken!";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String INTERNEL_USER_POST_MAPPING_LOGIN = "login";
    
    /** Constant for supplier register Path in Supplier Controller */
    public static final String INTERNAL_USER_GET_ALL = "get-all-internal-users";
    
}
