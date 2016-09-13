package db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;

import entity.TelclassInfo;
import entity.TelnumberInfo;
import utils.LogUtil;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class DBReader {
    public static File telFile;
    static {
        String dbFileDir="data/data/com.feicui.cn/";
        File fileDir=new File(dbFileDir);
        fileDir.mkdirs();
        telFile=new File(dbFileDir,"commonnum.db");
        LogUtil.d("DBReader","telFile dir path:"+dbFileDir);
    }

    public static boolean isExistsTeldbFile(){
        File toFile=DBReader.telFile;
        if(!toFile.exists()||toFile.length()<=0){
            return false;
        }
        return true;
    }

    public static ArrayList<TelclassInfo> readTeldbClasslist() throws Exception{
        ArrayList<TelclassInfo> classListInfos=new ArrayList<TelclassInfo>();
        SQLiteDatabase db=null;
        Cursor cursor=null;
        try{
            db=SQLiteDatabase.openOrCreateDatabase(telFile,null);
            cursor=db.rawQuery("select * from classlist",null);
            LogUtil.d("DBRead","read teldb classlist size:"+cursor.getCount());
            if (cursor.moveToFirst()){
                do {
                    String name=cursor.getString(cursor.getColumnIndex("name"));
                    int idx=cursor.getInt(cursor.getColumnIndex("idx"));
                    TelclassInfo classListInfo=new TelclassInfo(name,idx);
                    classListInfos.add(classListInfo);
                }while (cursor.moveToNext());
            }
        }catch (Exception e){
            throw e;
        }
        finally {
            try {
                cursor.close();
                db.close();
            }catch (Exception e2){
                throw e2;
            }
            LogUtil.d("DBReader","read teldb classlist end [list size]:"+classListInfos.size());
        }
        return classListInfos;
    }

    public static ArrayList<TelnumberInfo> readTeldbTable(int idx) throws Exception{
        ArrayList<TelnumberInfo> numberInfos=new ArrayList<TelnumberInfo>();
        String sql="select * from table"+idx;
        SQLiteDatabase db=null;
        Cursor cursor=null;
        try {
            db=SQLiteDatabase.openOrCreateDatabase(telFile,null);
            cursor=db.rawQuery(sql,null);
            LogUtil.d("DBRead","read teldb number table size:"+cursor.getCount());
            if(cursor.moveToFirst()){
                do{
                    String name=cursor.getString(cursor.getColumnIndex("name"));
                    String number=cursor.getString(cursor.getColumnIndex("number"));
                    TelnumberInfo numberInfo=new TelnumberInfo(name,number);
                    numberInfos.add(numberInfo);
                }while (cursor.moveToNext());
            }
        }catch (Exception e){
            throw e;
        }finally {
            try {
                cursor.close();
                db.close();
            }catch (Exception e2){
                throw e2;
            }
            LogUtil.d("DBRead","read teldb number table end[list size]:"+numberInfos.size());
        }
        return numberInfos;
    }

}
