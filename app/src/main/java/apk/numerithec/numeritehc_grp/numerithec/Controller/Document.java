package apk.numerithec.numeritehc_grp.numerithec.Controller;

import android.provider.DocumentsContract;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import apk.numerithec.numeritehc_grp.numerithec.R;

public class Document
{
    public static Integer Download()
    {
        URL url=null;
        HttpURLConnection urlConnection=null;
        DocumentsContract.Document bm=null;
        try {
            url=new URL("");
            urlConnection=(HttpURLConnection)url.openConnection();
            if(urlConnection.getResponseCode()!=HttpURLConnection.HTTP_OK)
            {
                return R.string.msg_erreur_Download;
            }
            InputStream in=new BufferedInputStream(urlConnection.getInputStream());
            //bm= BitmapFactory.decodeStream(in);
            FileOutputStream fos=new FileOutputStream("");
            //Doit écrire dans le flux
            in.close();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e){ e.printStackTrace();}
        finally {
            if (urlConnection!=null) urlConnection.disconnect();
        }
        return R.string.msg_download_succes;
    }
    public static JSONObject List()
    {
        JSONObject json=null;
        HttpURLConnection httpURLConnection=null;
        try
        {
            URL url=new URL("");
            httpURLConnection=(HttpURLConnection) url.openConnection();
            if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK)
            {
                InputStream in=httpURLConnection.getInputStream();
                json=new JSONObject(Controller_bd.readStreamJson(in));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(httpURLConnection!=null) httpURLConnection.disconnect();
        }
        return json;
    }
}
