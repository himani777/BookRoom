package com.example.gangwars.bookroom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.security.PublicKey;

/**
 * Created by gangwars on 26-04-2016.
 */
public class MyDbAdapter {
    MyDb a;

    public MyDbAdapter(Context context) {
        a = new MyDb(context);
    }

    public long insertData(String name, String password) {
        SQLiteDatabase db = a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDb.Name, name);
        contentValues.put(MyDb.Password, password);
        long id = db.insert(MyDb.Table_Name, null, contentValues);
        return id;
    }
    public boolean deletedata(int rowId) {
        SQLiteDatabase db = a.getWritableDatabase();
        return db.delete(MyDb.Table_Name, MyDb.Uid + "=" + rowId, null) > 0;
    }

    public void updateData(int i,String name, String password) {
        SQLiteDatabase db = a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDb.Name, name);
        contentValues.put(MyDb.Password, password);
      db.update(MyDb.Table_Name, contentValues,MyDb.Uid +  "=" + i, null);

    }

    public long insertRoomdata(Integer id, String user) {
        SQLiteDatabase db = a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDb.Roomid, id);
        contentValues.put(MyDb.UserRoom, user);
        long g = db.insert(MyDb.Table_Room, null, contentValues);
        return g;
    }


    public String searchroombooked(int nm) {
        String p;
        int u;
        SQLiteDatabase db = a.getWritableDatabase();
        String col[] = {MyDb.Roomid,MyDb.UserRoom};
        Cursor c = db.query(MyDb.Table_Room, col, null, null, null, null, null);
        p = "not found";
        while (c.moveToNext()) {

            u = c.getInt(0);
            if (nm==u) {
                p = c.getString(1);
                break;
            }
        }

        return p;
    }
    public int searchroomid(String nm) { //enetr user name
        String u;
        int p;
        SQLiteDatabase db = a.getWritableDatabase();
        String col[] = {MyDb.Roomid, MyDb.UserRoom};
        Cursor c = db.query(MyDb.Table_Room, col, null, null, null, null, null);
        p = 0;
        while (c.moveToNext()) {

            u = c.getString(1);
            if (nm.equals(u)) {
                p = Integer.parseInt(c.getString(2));
                break;
            }
        }

        return p;
    }

    public String getAllData() {
        StringBuffer b = new StringBuffer();
        SQLiteDatabase db = a.getWritableDatabase();
        String col[] = {MyDb.Uid, MyDb.Name, MyDb.Password};
        Cursor c = db.query(MyDb.Table_Name, col, null, null, null, null, null);
        while (c.moveToNext()) {
            int cid = c.getInt(0);
            String n = c.getString(1);
            String p = c.getString(2);
            b.append(cid + ' ' + n + "\n");
        }
        return b.toString();
    }

    public String getData(String zx) {

        SQLiteDatabase db = a.getWritableDatabase();
        String col[] = {MyDb.Password};
        Cursor c = db.query(MyDb.Table_Name, col, MyDb.Name + " = '" + zx + "'", null, null, null, null);
        while (c.moveToNext()) {
            return c.getString(c.getColumnIndex(MyDb.Password));
        }


        return "Data Not Found";
    }

    public String searchpass(String nm) {
        String u, p;
        SQLiteDatabase db = a.getWritableDatabase();
        String col[] = {MyDb.Name,MyDb.Password};
        Cursor c = db.query(MyDb.Table_Name, col, null, null, null, null, null);
        p = "not found";
        while (c.moveToNext()) {

            u = c.getString(0);
            Log.e("1" ,"" + u);
            if (nm.equals(u))
            {

                p = c.getString(1);
                Log.e("2" ,"" + p);
                Log.e("1" ,"" + nm + u);
                break;
            }
        }

        return p;
    }

    public int getlockfromdatabase()
    {int l;
        SQLiteDatabase db = a.getWritableDatabase();
        String col[] = {MyDb.Lock};
        Cursor c = db.query(MyDb.Table_Lock, col, null, null, null, null, null);
        c.moveToFirst();
        l=c.getInt(0);
        return l;
    }

    public void updatelockdatabase(int lock)
    {
        SQLiteDatabase db = a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDb.Lock, lock);

        db.update(MyDb.Table_Lock, contentValues,MyDb.LockID +  "=" + 1, null);

    }



    static public class MyDb extends SQLiteOpenHelper {
        private static final String Db_Name = "MyDb";
        private static final String Table_Name = "MyTable";
        private static final String Uid = "_id";
        private static final String Name = "Name";
        private static final String Password = "Password";
        private static final String Create_Table = "CREATE TABLE " + Table_Name + " (" + Uid + " INTEGER PRIMARY KEY AUTOINCREMENT , " + Name + " VARCHAR(255) , " + Password + " VARCHAR(255));";

        private static final int Db_Version = 1;


        private static final String Table_Room = "room";
        private static final String Roomid = "roomid";
        private static final String UserRoom = "user";

        private static final String Table_Lock = "lock";
        private static final String LockID = "id";
        private static final String Lock = "status";
        private static final String Create_Table_Lock = "CREATE TABLE " + Table_Lock + " ("+ LockID + " INTEGER  , " + Lock + " INTEGER );" ;
private static  final String insertlck="INSERT INTO "+ Table_Lock+" values (1,0);";

        private static final String Create_Table_Room = "CREATE TABLE " + Table_Room + " (" + Roomid + " INTEGER PRIMARY KEY  ,  " + UserRoom + " VARCHAR(255) );" ;

        private Context context;


        public MyDb(Context context) {
            super(context, Db_Name, null, Db_Version);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL(Create_Table);
            sqLiteDatabase.execSQL(Create_Table_Room);
            sqLiteDatabase.execSQL(Create_Table_Lock);
            sqLiteDatabase.execSQL(insertlck);


        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

        }


    }
}