package db;


public class Schema {
    /*Table names*/
    private static final String TABLE_NAME_COMPANY = "company";
    private static final String TABLE_NAME_COUPON = "coupon";
    private static final String TABLE_NAME_CUSTOMER = "customer";
    private static final String TABLE_NAME_CUSTOMER_COUPON = "customer_coupon";

    /*Common columns*/
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_EMAIL = "email";
    public static final String COL_PASSWORD = "password";

    /*Coupon specific columns.*/
    public static final String COL_COMPANY_ID = "company_id";
    public static final String COL_CATEGORY = "category";
    public static final String COL_TITLE = "title";
    public static final String COL_START_DATE = "start_date";
    public static final String COL_END_DATE = "end_date";
    public static final String COL_AMOUNT = "amount";
    public static final String COL_DESC = "description";
    public static final String COL_PRICE = "price";
    public static final String COL_IMAGE = "image";
    /*customer specific columns*/
    public static final String COL_FIRST_NAME = "first_name";
    public static final String COL_LAST_NAME = "last_name";
    /*customer_coupon specific columns*/
    private static final String COL_COUPON_ID = "coupon_id";
    private static final String COL_CUSTOMER_ID = "customer_id";

    /*Queries*/

    //region Coupon Queries
    public static final String INSERT_COUPON = "insert into "
                                               + TABLE_NAME_COUPON
                                               + "("
                                               + COL_COMPANY_ID
                                               + ","
                                               + COL_CATEGORY
                                               + ","
                                               + COL_TITLE
                                               + ","
                                               + COL_START_DATE
                                               + ","
                                               + COL_END_DATE
                                               + ","
                                               + COL_AMOUNT
                                               + ","
                                               + COL_DESC
                                               + ","
                                               + COL_PRICE
                                               + ","
                                               + COL_IMAGE
                                               + ")"
                                               + " values (?,?,?,?,?,?,?,?,?)";

    public static final String SELECT_ALL_COUPONS = "select * from " + TABLE_NAME_COUPON;

    public static final String DELETE_COUPON = "delete from " + TABLE_NAME_COUPON + " where " + COL_ID + " = ?";

    public static final String UPDATE_COUPON = "update "
                                               + TABLE_NAME_COUPON
                                               + " set "
                                               + COL_COMPANY_ID
                                               + " = ?, "
                                               + COL_CATEGORY
                                               + " = ?, "
                                               + COL_TITLE
                                               + " = ?, "
                                               + COL_START_DATE
                                               + " = ?, "
                                               + COL_END_DATE
                                               + " = ?, "
                                               + COL_AMOUNT
                                               + " = ?, "
                                               + COL_DESC
                                               + " = ?, "
                                               + COL_PRICE
                                               + " = ?, "
                                               + COL_IMAGE
                                               + " = ? where "
                                               + COL_ID
                                               + " = ?";

    public static final String UPDATE_COUPON_AMOUNT = "update "
                                                      + TABLE_NAME_COUPON
                                                      + " set "
                                                      + COL_AMOUNT
                                                      + " = "
                                                      + COL_AMOUNT
                                                      + " -1 where "
                                                      + COL_ID + " = ? and "
                                                      + COL_AMOUNT
                                                      + " > 0";

    public static final String SELECT_COUPON_BY_ID = "select * from " + TABLE_NAME_COUPON + " where " + COL_ID + " = ?";

    public static final String SELECT_COUPON_BY_CATEGORY = "select * from "
                                                           + TABLE_NAME_COUPON
                                                           + " where "
                                                           + COL_CATEGORY
                                                           + " = ?";

    //endregion


    //region Customer Queries
    public static final String CUSTOMER_LOGIN = "select * from "
                                                + TABLE_NAME_CUSTOMER
                                                + " where "
                                                + COL_EMAIL
                                                + " = ? and "
                                                + COL_PASSWORD
                                                + " = ?";
    public static final String INSERT_CUSTOMER = "insert into "
                                                 + TABLE_NAME_CUSTOMER
                                                 + " ("
                                                 + COL_FIRST_NAME
                                                 + ", "
                                                 + COL_LAST_NAME
                                                 + ", "
                                                 + COL_EMAIL
                                                 + ", "
                                                 + COL_PASSWORD
                                                 + ") "
                                                 + "values (?,?,?,?)";

    public static final String DELETE_CUSTOMER = "delete from " + TABLE_NAME_CUSTOMER + " where " + COL_ID + " = ?";

    public static final String SELECT_ALL_CUSTOMERS = "select * from " + TABLE_NAME_CUSTOMER;

    public static final String UPDATE_CUSTOMER = "update "
                                                 + TABLE_NAME_CUSTOMER
                                                 + " set "
                                                 + COL_FIRST_NAME
                                                 + " = ?, "
                                                 + COL_LAST_NAME
                                                 + " = ?, "
                                                 + COL_EMAIL
                                                 + " = ?, "
                                                 + COL_PASSWORD
                                                 + " = ? where "
                                                 + COL_ID
                                                 + " = ?";
    public static final String SELECT_CUSTOMER_BY_ID = "select * from "
                                                       + TABLE_NAME_CUSTOMER
                                                       + " where "
                                                       + COL_ID
                                                       + " = ?";

    public static final String SELECT_CUSTOMER_COUPON_BY_ID = "select * from "
                                                              + TABLE_NAME_COUPON
                                                              + " t1 inner join "
                                                              + TABLE_NAME_CUSTOMER_COUPON
                                                              + " t2 "
                                                              + "on t1."
                                                              + COL_ID
                                                              + " = "
                                                              + "t2"
                                                              + "."
                                                              + COL_COUPON_ID
                                                              + " where t2"
                                                              + "."
                                                              + COL_CUSTOMER_ID
                                                              + " = ?";

    public static final String INSERT_CUSTOMER_COUPON = "insert into "
                                                        + TABLE_NAME_CUSTOMER_COUPON
                                                        + " ("
                                                        + COL_COUPON_ID
                                                        + ", "
                                                        + COL_CUSTOMER_ID
                                                        + ") values (?,?)";
//endregion


    //region Company Queries
    public static final String COMPANY_LOGIN = "select * from "
                                               + TABLE_NAME_COMPANY
                                               + " where "
                                               + COL_EMAIL
                                               + " = ? and "
                                               + COL_PASSWORD
                                               + " = ?";
    public static final String INSERT_COMPANY = "insert into "
                                                + TABLE_NAME_COMPANY
                                                + "("
                                                + COL_NAME
                                                + ","
                                                + COL_EMAIL
                                                + ","
                                                + COL_PASSWORD
                                                + ") "
                                                + "values (?,?,?)";

    public static final String DELETE_COMPANY = "delete from " + TABLE_NAME_COMPANY + " where " + COL_ID + " = ?";


    public static final String UPDATE_COMPANY = "update "
                                                + TABLE_NAME_COMPANY
                                                + " set "
                                                + COL_NAME
                                                + " = ?, "
                                                + COL_EMAIL
                                                + " = ?, "
                                                + COL_PASSWORD
                                                + " = ? where "
                                                + COL_ID
                                                + " = ?";

    public static final String SELECT_COMPANY_BY_ID = "select * from "
                                                      + TABLE_NAME_COMPANY
                                                      + " where "
                                                      + COL_ID
                                                      + " = ?";

    public static final String SELECT_ALL_COMPANIES = "select * from " + TABLE_NAME_COMPANY;

    public static final String SELECT_COUPONS_BY_COMPANY_ID = "select * from "
                                                              + TABLE_NAME_COUPON
                                                              + " where "
                                                              + COL_COMPANY_ID
                                                              + " = ?";
//endregion

}
