package com.citrusbits.hassan.icleanreloaded.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class iCleanDBOpenHelper extends SQLiteOpenHelper{

    private static final String LOGTAG = "iCleanUsers";

    private static final String DATABASE_NAME = "icleanreloaded.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USER = "user";
    public static final String COLUMN_USER_ID = "userId";
    public static final String COLUMN_USER_NAME = "username";
    public static final String COLUMN_USER_EMAIL = "email";
    public static final String COLUMN_USER_PHONE = "phone";
    public static final String COLUMN_USER_ZIP = "zip";
    public static final String COLUMN_USER_TYPE = "type";
    public static final String COLUMN_USER_PROMO = "promo";

    private static final String TABLE_CREATE_USER =
            "CREATE TABLE " + TABLE_USER + " (" +
                    COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USER_NAME + " TEXT, " +
                    COLUMN_USER_EMAIL + " TEXT, " +
                    COLUMN_USER_PHONE + " TEXT, " +
                    COLUMN_USER_ZIP + " TEXT, " +
                    COLUMN_USER_TYPE + " TEXT, " +
                    COLUMN_USER_PROMO + " TEXT" +
                    ")";

    public static final String TABLE_MY_LOCATION = "myLocation";
    public static final String COLUMN_MY_LOCATION_LOCATION_ID = "locationId";
    public static final String COLUMN_MY_LOCATION_USER_ID = "userId";
    public static final String COLUMN_MY_LOCATION_LOCATION_NAME = "locationName";
    public static final String COLUMN_MY_LOCATION_ADDRESS1 = "address1";
    public static final String COLUMN_MY_LOCATION_ADDRESS2 = "address2";
    public static final String COLUMN_MY_LOCATION_CITY = "city";
    public static final String COLUMN_MY_LOCATION_STATE = "state";
    public static final String COLUMN_MY_LOCATION_ZIP = "zip";

    private static final String TABLE_CREATE_MY_LOCATION =
            "CREATE TABLE " + TABLE_MY_LOCATION + " (" +
                    COLUMN_MY_LOCATION_LOCATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_MY_LOCATION_USER_ID + " INTEGER, " +
                    COLUMN_MY_LOCATION_LOCATION_NAME + " TEXT, " +
                    COLUMN_MY_LOCATION_ADDRESS1 + " TEXT, " +
                    COLUMN_MY_LOCATION_ADDRESS2 + " TEXT, " +
                    COLUMN_MY_LOCATION_CITY + " TEXT, " +
                    COLUMN_MY_LOCATION_STATE + " TEXT, " +
                    COLUMN_MY_LOCATION_ZIP + " TEXT" +
                    ")";

    public static final String TABLE_PLACE_ORDER = "placeOrder";
    public static final String COLUMN_PLACE_ORDER_ID = "Id";
    public static final String COLUMN_PLACE_ORDER_ORDER_ID = "orderId";
    public static final String COLUMN_PLACE_ORDER_USER_ID = "userId";
    public static final String COLUMN_PLACE_ORDER_PICKUP_DATE = "pickupDate";
    public static final String COLUMN_PLACE_ORDER_PICKUP_START_TIME = "pickupStartTime";
    public static final String COLUMN_PLACE_ORDER_PICKUP_END_TIME = "pickupEndTime";
    public static final String COLUMN_PLACE_ORDER_DROPOFF_DATE = "dropoffDate";
    public static final String COLUMN_PLACE_ORDER_DROPOFF_START_TIME = "dropoffStartTime";
    public static final String COLUMN_PLACE_ORDER_DROPOFF_END_TIME = "dropoffEndTime";
    public static final String COLUMN_PLACE_ORDER_OPTIONAL = "optional";
    public static final String COLUMN_PLACE_ORDER_PICKUP_ADDRESS_NAME = "pickupAddressName";
    public static final String COLUMN_PLACE_ORDER_PICKUP_ADDRESS = "pickupAddress";
    public static final String COLUMN_PLACE_ORDER_PICKUP_CITY = "pickupCity";
    public static final String COLUMN_PLACE_ORDER_PICKUP_STATE = "pickupState";
    public static final String COLUMN_PLACE_ORDER_PICKUP_ZIP = "pickupZip";
    public static final String COLUMN_PLACE_ORDER_PICKUP_ADDRESS_ID = "pickupAddressId";
    public static final String COLUMN_PLACE_ORDER_PICKUP_INSTRUCTION = "pickupInstructions";
    public static final String COLUMN_PLACE_ORDER_DROPOFF_ADDRESS_NAME = "dropoffAddressName";
    public static final String COLUMN_PLACE_ORDER_DROPOFF_ADDRESS = "dropoffAddress";
    public static final String COLUMN_PLACE_ORDER_DROPOFF_CITY = "dropoffCity";
    public static final String COLUMN_PLACE_ORDER_DROPOFF_STATE = "dropoffState";
    public static final String COLUMN_PLACE_ORDER_DROPOFF_ZIP = "dropoffZip";
    public static final String COLUMN_PLACE_ORDER_DROPOFF_ADDRESS_ID = "dropoffAddressId";
    public static final String COLUMN_PLACE_ORDER_DROPOFF_INSTRUCTIONS = "dropoffInstructions";
    public static final String COLUMN_PLACE_ORDER_PROMO = "promoCode";
    public static final String COLUMN_PLACE_ORDER_PICKUP_TIME_SLOT = "pickupTimeSlot";
    public static final String COLUMN_PLACE_ORDER_DROPOFF_TIME_SLOT = "dropoffTimeSlot";
    public static final String COLUMN_PLACE_ORDER_STATUS = "status";
    public static final String COLUMN_PLACE_ORDER_ETA = "eta";
    public static final String COLUMN_PLACE_ORDER_LEAVE_NOTES = "leaveNotes";
    public static final String COLUMN_PLACE_ORDER_IS_PAYMENT = "isPayment";


    private static final String TABLE_CREATE_PLACE_ORDER =
            "CREATE TABLE " + TABLE_PLACE_ORDER + " (" +
                    COLUMN_PLACE_ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PLACE_ORDER_ORDER_ID + " INTEGER, " +
                    COLUMN_PLACE_ORDER_USER_ID + " INTEGER, " +
                    COLUMN_PLACE_ORDER_PICKUP_DATE + " TEXT, " +
                    COLUMN_PLACE_ORDER_PICKUP_START_TIME + " TEXT, " +
                    COLUMN_PLACE_ORDER_PICKUP_END_TIME + " TEXT, " +
                    COLUMN_PLACE_ORDER_DROPOFF_DATE + " TEXT, " +
                    COLUMN_PLACE_ORDER_DROPOFF_START_TIME + " TEXT, " +
                    COLUMN_PLACE_ORDER_DROPOFF_END_TIME + " TEXT, " +
                    COLUMN_PLACE_ORDER_OPTIONAL + " TEXT, " +
                    COLUMN_PLACE_ORDER_PICKUP_ADDRESS_NAME + " TEXT, " +
                    COLUMN_PLACE_ORDER_PICKUP_ADDRESS + " TEXT, " +
                    COLUMN_PLACE_ORDER_PICKUP_CITY + " TEXT, " +
                    COLUMN_PLACE_ORDER_PICKUP_STATE + " TEXT, " +
                    COLUMN_PLACE_ORDER_PICKUP_ZIP + " TEXT, " +
                    COLUMN_PLACE_ORDER_PICKUP_ADDRESS_ID + " TEXT, " +
                    COLUMN_PLACE_ORDER_PICKUP_INSTRUCTION + " TEXT, " +
                    COLUMN_PLACE_ORDER_DROPOFF_ADDRESS_NAME + " TEXT, " +
                    COLUMN_PLACE_ORDER_DROPOFF_ADDRESS + " TEXT, " +
                    COLUMN_PLACE_ORDER_DROPOFF_CITY + " TEXT, " +
                    COLUMN_PLACE_ORDER_DROPOFF_STATE + " TEXT, " +
                    COLUMN_PLACE_ORDER_DROPOFF_ZIP + " TEXT, " +
                    COLUMN_PLACE_ORDER_DROPOFF_ADDRESS_ID + " TEXT, " +
                    COLUMN_PLACE_ORDER_DROPOFF_INSTRUCTIONS + " TEXT, " +
                    COLUMN_PLACE_ORDER_PROMO + " TEXT, " +
                    COLUMN_PLACE_ORDER_PICKUP_TIME_SLOT + " TEXT, " +
                    COLUMN_PLACE_ORDER_STATUS + " TEXT, " +
                    COLUMN_PLACE_ORDER_ETA + " TEXT, " +
                    COLUMN_PLACE_ORDER_LEAVE_NOTES + " TEXT, " +
                    COLUMN_PLACE_ORDER_IS_PAYMENT + " TEXT, " +
                    COLUMN_PLACE_ORDER_DROPOFF_TIME_SLOT + " TEXT" +
                    ")";


    public static final String TABLE_WASH_SETTINGS = "washSettings";
    public static final String COLUMN_WASH_SETTINGS_USER_ID = "userId";
    public static final String COLUMN_WASH_SETTINGS_WASH_TYPE = "washType";
    public static final String COLUMN_WASH_SETTINGS_FABRIC_SOFTNER = "fabric_softner";
    public static final String COLUMN_WASH_SETTINGS_UNSCENTED_DETERGENT = "unsented_detergent";
    public static final String COLUMN_WASH_SETTINGS_WASH = "wash";
    public static final String COLUMN_WASH_SETTINGS_DRY_OPTION = "dryOption";
    public static final String COLUMN_WASH_SETTINGS_INSTRUCTIONS = "instructions";
    public static final String COLUMN_WASH_SETTINGS_DETERGENT = "detergent";
    public static final String COLUMN_WASH_SETTINGS_STACH_LEVEL = "stachLevel";
    public static final String COLUMN_WASH_SETTINGS_PACKAGED = "packaged";
    public static final String COLUMN_WASH_SETTINGS_DRY_CLEAN = "dry_clean";

    private static final String TABLE_CREATE_WASH_SETTINGS =
            "CREATE TABLE " + TABLE_WASH_SETTINGS + " (" +
                    COLUMN_WASH_SETTINGS_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_WASH_SETTINGS_WASH_TYPE + " TEXT, " +
                    COLUMN_WASH_SETTINGS_FABRIC_SOFTNER + " TEXT, " +
                    COLUMN_WASH_SETTINGS_UNSCENTED_DETERGENT + " TEXT, " +
                    COLUMN_WASH_SETTINGS_WASH + " TEXT, " +
                    COLUMN_WASH_SETTINGS_DRY_OPTION + " TEXT, " +
                    COLUMN_WASH_SETTINGS_INSTRUCTIONS + " TEXT, " +
                    COLUMN_WASH_SETTINGS_DETERGENT + " TEXT, " +
                    COLUMN_WASH_SETTINGS_STACH_LEVEL + " TEXT, " +
                    COLUMN_WASH_SETTINGS_PACKAGED + " TEXT, " +
                    COLUMN_WASH_SETTINGS_DRY_CLEAN + " TEXT" +
                    ")";

    public static final String TABLE_DRIVER_ORDERS = "driverOrders";
    public static final String COLUMN_DRIVER_ORDERS_USER_ID = "userId";
    public static final String COLUMN_DRIVER_ORDERS_USER_NAME = "userName";
    public static final String COLUMN_DRIVER_ORDERS_USER_PHONE = "userPhone";
    public static final String COLUMN_DRIVER_ORDERS_ID = "Id";
    public static final String COLUMN_DRIVER_ORDERS_ORDER_ID = "orderId";
    public static final String COLUMN_DRIVER_ORDERS_PICKUP_DATE = "pickupDate";
    public static final String COLUMN_DRIVER_ORDERS_PICKUP_START_TIME = "pickupStartTime";
    public static final String COLUMN_DRIVER_ORDERS_PICKUP_END_TIME = "pickupEndTime";
    public static final String COLUMN_DRIVER_ORDERS_DROPOFF_DATE = "dropoffDate";
    public static final String COLUMN_DRIVER_ORDERS_DROPOFF_START_TIME = "dropoffStartTime";
    public static final String COLUMN_DRIVER_ORDERS_DROPOFF_END_TIME = "dropoffEndTime";
    public static final String COLUMN_DRIVER_ORDERS_OPTIONAL = "optional";
    public static final String COLUMN_DRIVER_ORDERS_PICKUP_INSTRUCTION = "pickupInstructions";
    public static final String COLUMN_DRIVER_ORDERS_DROPOFF_INSTRUCTIONS = "dropoffInstructions";
    public static final String COLUMN_DRIVER_ORDERS_STATUS = "status";
    public static final String COLUMN_DRIVER_ORDERS_PICKUP_ADDRESS_ID = "pickupAddressId";
    public static final String COLUMN_DRIVER_ORDERS_PICKUP_ADDRESS_NAME = "pickupAddressName";
    public static final String COLUMN_DRIVER_ORDERS_PICKUP_ADDRESS = "pickupAddress";
    public static final String COLUMN_DRIVER_ORDERS_PICKUP_CITY = "pickupCity";
    public static final String COLUMN_DRIVER_ORDERS_PICKUP_STATE = "pickupState";
    public static final String COLUMN_DRIVER_ORDERS_PICKUP_ZIP = "pickupZip";
    public static final String COLUMN_DRIVER_ORDERS_DROPOFF_ADDRESS_ID = "dropoffAddressId";
    public static final String COLUMN_DRIVER_ORDERS_DROPOFF_ADDRESS_NAME = "dropoffAddressName";
    public static final String COLUMN_DRIVER_ORDERS_DROPOFF_ADDRESS = "dropoffAddress";
    public static final String COLUMN_DRIVER_ORDERS_DROPOFF_CITY = "dropoffCity";
    public static final String COLUMN_DRIVER_ORDERS_DROPOFF_STATE = "dropoffState";
    public static final String COLUMN_DRIVER_ORDERS_DROPOFF_ZIP = "dropoffZip";
    public static final String COLUMN_DRIVER_ORDERS_TIME_SLOT = "timeSlot";

    private static final String TABLE_CREATE_DRIVER_ORDERS =
            "CREATE TABLE " + TABLE_DRIVER_ORDERS + " (" +
                    COLUMN_DRIVER_ORDERS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DRIVER_ORDERS_ORDER_ID + " INTEGER, " +
                    COLUMN_DRIVER_ORDERS_USER_ID + " INTEGER, " +
                    COLUMN_DRIVER_ORDERS_USER_NAME + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_USER_PHONE + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_PICKUP_DATE + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_PICKUP_START_TIME + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_PICKUP_END_TIME + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_DROPOFF_DATE + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_DROPOFF_START_TIME + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_DROPOFF_END_TIME + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_OPTIONAL + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_PICKUP_INSTRUCTION + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_DROPOFF_INSTRUCTIONS + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_PICKUP_ADDRESS_ID + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_PICKUP_ADDRESS_NAME + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_PICKUP_ADDRESS + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_PICKUP_CITY + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_PICKUP_STATE + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_PICKUP_ZIP + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_DROPOFF_ADDRESS_ID + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_DROPOFF_ADDRESS_NAME + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_DROPOFF_ADDRESS + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_DROPOFF_CITY + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_DROPOFF_STATE + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_DROPOFF_ZIP + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_TIME_SLOT + " TEXT, " +
                    COLUMN_DRIVER_ORDERS_STATUS + " TEXT" +
                    ")";

    public static final String TABLE_ORDERS_HISTORY = "orderHistory";
    public static final String COLUMN_ORDERS_HISTORY_USER_ID = "userId";
    public static final String COLUMN_ORDERS_HISTORY_USER_NAME = "userName";
    public static final String COLUMN_ORDERS_HISTORY_USER_PHONE = "userPhone";
    public static final String COLUMN_ORDERS_HISTORY_ID = "Id";
    public static final String COLUMN_ORDERS_HISTORY_ORDER_ID = "orderId";
    public static final String COLUMN_ORDERS_HISTORY_PICKUP_DATE = "pickupDate";
    public static final String COLUMN_ORDERS_HISTORY_PICKUP_START_TIME = "pickupStartTime";
    public static final String COLUMN_ORDERS_HISTORY_PICKUP_END_TIME = "pickupEndTime";
    public static final String COLUMN_ORDERS_HISTORY_DROPOFF_DATE = "dropoffDate";
    public static final String COLUMN_ORDERS_HISTORY_DROPOFF_START_TIME = "dropoffStartTime";
    public static final String COLUMN_ORDERS_HISTORY_DROPOFF_END_TIME = "dropoffEndTime";
    public static final String COLUMN_ORDERS_HISTORY_OPTIONAL = "optional";
    public static final String COLUMN_ORDERS_HISTORY_PICKUP_INSTRUCTION = "pickupInstructions";
    public static final String COLUMN_ORDERS_HISTORY_DROPOFF_INSTRUCTIONS = "dropoffInstructions";
    public static final String COLUMN_ORDERS_HISTORY_STATUS = "status";
    public static final String COLUMN_ORDERS_HISTORY_PICKUP_ADDRESS_ID = "pickupAddressId";
    public static final String COLUMN_ORDERS_HISTORY_PICKUP_ADDRESS_NAME = "pickupAddressName";
    public static final String COLUMN_ORDERS_HISTORY_PICKUP_ADDRESS = "pickupAddress";
    public static final String COLUMN_ORDERS_HISTORY_PICKUP_CITY = "pickupCity";
    public static final String COLUMN_ORDERS_HISTORY_PICKUP_STATE = "pickupState";
    public static final String COLUMN_ORDERS_HISTORY_PICKUP_ZIP = "pickupZip";
    public static final String COLUMN_ORDERS_HISTORY_DROPOFF_ADDRESS_ID = "dropoffAddressId";
    public static final String COLUMN_ORDERS_HISTORY_DROPOFF_ADDRESS_NAME = "dropoffAddressName";
    public static final String COLUMN_ORDERS_HISTORY_DROPOFF_ADDRESS = "dropoffAddress";
    public static final String COLUMN_ORDERS_HISTORY_DROPOFF_CITY = "dropoffCity";
    public static final String COLUMN_ORDERS_HISTORY_DROPOFF_STATE = "dropoffState";
    public static final String COLUMN_ORDERS_HISTORY_DROPOFF_ZIP = "dropoffZip";
    public static final String COLUMN_ORDERS_HISTORY_TIME_SLOT = "timeSlot";

    private static final String TABLE_CREATE_ORDERS_HISTORY =
            "CREATE TABLE " + TABLE_ORDERS_HISTORY + " (" +
                    COLUMN_ORDERS_HISTORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ORDERS_HISTORY_ORDER_ID + " INTEGER, " +
                    COLUMN_ORDERS_HISTORY_USER_ID + " INTEGER, " +
                    COLUMN_ORDERS_HISTORY_USER_NAME + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_USER_PHONE + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_PICKUP_DATE + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_PICKUP_START_TIME + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_PICKUP_END_TIME + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_DROPOFF_DATE + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_DROPOFF_START_TIME + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_DROPOFF_END_TIME + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_OPTIONAL + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_PICKUP_INSTRUCTION + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_DROPOFF_INSTRUCTIONS + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_PICKUP_ADDRESS_ID + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_PICKUP_ADDRESS_NAME + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_PICKUP_ADDRESS + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_PICKUP_CITY + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_PICKUP_STATE + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_PICKUP_ZIP + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_DROPOFF_ADDRESS_ID + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_DROPOFF_ADDRESS_NAME + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_DROPOFF_ADDRESS + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_DROPOFF_CITY + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_DROPOFF_STATE + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_DROPOFF_ZIP + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_TIME_SLOT + " TEXT, " +
                    COLUMN_ORDERS_HISTORY_STATUS + " TEXT" +
                    ")";

    public iCleanDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_USER);
        db.execSQL(TABLE_CREATE_MY_LOCATION);
        db.execSQL(TABLE_CREATE_PLACE_ORDER);
        db.execSQL(TABLE_CREATE_DRIVER_ORDERS);
        db.execSQL(TABLE_CREATE_WASH_SETTINGS);
        db.execSQL(TABLE_CREATE_ORDERS_HISTORY);
        Log.d(LOGTAG, "Tables created successfully!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MY_LOCATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLACE_ORDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WASH_SETTINGS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CREATE_ORDERS_HISTORY);
        onCreate(db);
    }

}
