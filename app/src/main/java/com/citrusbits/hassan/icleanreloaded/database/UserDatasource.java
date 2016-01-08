package com.citrusbits.hassan.icleanreloaded.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.citrusbits.hassan.icleanreloaded.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDatasource {

    private static final String LOGTAG = "UserDatasource";

    SQLiteOpenHelper helper;
    SQLiteDatabase database;
    Context context;

    private static final String[] allColumns = {
            iCleanDBOpenHelper.COLUMN_USER_ID,
            iCleanDBOpenHelper.COLUMN_USER_NAME,
            iCleanDBOpenHelper.COLUMN_USER_EMAIL,
            iCleanDBOpenHelper.COLUMN_USER_PHONE,
            iCleanDBOpenHelper.COLUMN_USER_ZIP,
            iCleanDBOpenHelper.COLUMN_USER_TYPE,
            iCleanDBOpenHelper.COLUMN_USER_PROMO};

    public UserDatasource(Context context){
        helper = new iCleanDBOpenHelper(context);
        this.context = context;
    }
    public void open(){
        database = helper.getWritableDatabase();
        Log.d(LOGTAG, "Database Open!");
    }

    public void close(){
        helper.close();
        Log.d(LOGTAG, "Database Close!");
    }

    public User add(User user){

        ContentValues values = new ContentValues();
        values.put(iCleanDBOpenHelper.COLUMN_USER_ID, user.getId());
        values.put(iCleanDBOpenHelper.COLUMN_USER_NAME, user.getUsername());
        values.put(iCleanDBOpenHelper.COLUMN_USER_EMAIL, user.getEmail());
        values.put(iCleanDBOpenHelper.COLUMN_USER_PHONE, user.getPhone());
        values.put(iCleanDBOpenHelper.COLUMN_USER_ZIP, user.getZip());
        values.put(iCleanDBOpenHelper.COLUMN_USER_TYPE, user.getType());
        values.put(iCleanDBOpenHelper.COLUMN_USER_PROMO, user.getPromo());

        long id = database.insert(iCleanDBOpenHelper.TABLE_USER, null, values);
        user.setId(id);

        return user;
    }
    public List<User> findAll(){
        Log.i("zubair", "inside find all method");

        List<User> users = new ArrayList<User>();
        Log.i("zubair", "before query");
        Cursor c = database.query(iCleanDBOpenHelper.TABLE_USER, allColumns, null, null, null, null, null);

        Log.i("zubair", "after query");

        if(c.getCount() > 0){
            Log.i("zubair", "Inside if");
            while(c.moveToNext()){
                User user = new User();

                user.setId(c.getLong(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_ID)));
                user.setUsername(c.getString(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_NAME)));
                user.setEmail(c.getString(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_EMAIL)));
                user.setPhone(c.getString(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_PHONE)));
                user.setZip(c.getString(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_ZIP)));
                user.setType(c.getString(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_TYPE)));
                user.setPromo(c.getString(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_PROMO)));

                users.add(user);
            }
        }

        return users;
    }

    public User findUser(String userId) {
        Log.i("Why Zubair?", "inside find method");
        Log.i("Why Zubair?", "before query");
        User user = new User();

        String where = iCleanDBOpenHelper.COLUMN_USER_ID + "='" + userId + "'";
        Log.i("where caluse ", "where clause :" + where);
        Cursor c = database.query(iCleanDBOpenHelper.TABLE_USER, allColumns, where, null, null, null, null);

        Log.i("zubair", "after query");

        if(c.getCount() > 0){
            while(c.moveToNext()){

                user.setId(c.getLong(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_ID)));
                user.setUsername(c.getString(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_NAME)));
                user.setEmail(c.getString(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_EMAIL)));
                user.setPhone(c.getString(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_PHONE)));
                user.setZip(c.getString(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_ZIP)));
                user.setType(c.getString(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_TYPE)));
                user.setPromo(c.getString(c.getColumnIndex(iCleanDBOpenHelper.COLUMN_USER_PROMO)));
            }
        }

        return (user != null ? user : null ) ;
    }

    public boolean remove(User user){
        String where = iCleanDBOpenHelper .COLUMN_USER_ID + "='" + user.getId() + "'";

        int result = database.delete(iCleanDBOpenHelper.TABLE_USER, where, null);

        return (result == 1);
    }


    public boolean update(User user){
        ContentValues values = new ContentValues();
        values.put(iCleanDBOpenHelper.COLUMN_USER_ID, user.getId());
        values.put(iCleanDBOpenHelper.COLUMN_USER_NAME, user.getUsername());
        values.put(iCleanDBOpenHelper.COLUMN_USER_EMAIL, user.getEmail());
        values.put(iCleanDBOpenHelper.COLUMN_USER_PHONE, user.getPhone());
        values.put(iCleanDBOpenHelper.COLUMN_USER_ZIP, user.getZip());
        values.put(iCleanDBOpenHelper.COLUMN_USER_TYPE, user.getType());
        values.put(iCleanDBOpenHelper.COLUMN_USER_PROMO, user.getPromo());

        String where = iCleanDBOpenHelper.COLUMN_USER_ID + "='" + user.getId() + "'";
        //		String where = "id=?";
        //		String[] whereArgs = new String[] {String.valueOf(meeting.getId())};

        int result = database.update(iCleanDBOpenHelper.TABLE_USER, values, where, null);

        return (result == 1);
    }

    public boolean removeAllUsers(){
        database.execSQL("delete from "+ iCleanDBOpenHelper.TABLE_USER);

        return true;
    }
}
