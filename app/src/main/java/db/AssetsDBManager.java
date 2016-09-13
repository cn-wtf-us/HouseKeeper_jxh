package db;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import utils.LogUtil;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class AssetsDBManager {
    public static void copyAssetsFileToFile(Context context, String path, File toFile) throws IOException {

        LogUtil.d("AssetsDBManager","copyAssetsFileToFile start");
        LogUtil.d("AssetsDBManager","file path:"+path);
        LogUtil.d("AssetsDBManager","file path:"+toFile.getAbsolutePath());
        InputStream inStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try{
            inStream=context.getAssets().open(path);
            bufferedInputStream=new BufferedInputStream(inStream);
            bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(toFile,false));
            int len=0;
            byte [] buff=new byte[2*1024];
            while ((len=bufferedInputStream.read(buff))!=-1){
                bufferedOutputStream.write(buff,0,len);
            }
            bufferedOutputStream.flush();
        }catch (IOException e){
            throw e;
        }finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();
            inStream.close();
            LogUtil.d("AssetsDBManager","copyAssetsFileToFile end");
        }

    }
}
