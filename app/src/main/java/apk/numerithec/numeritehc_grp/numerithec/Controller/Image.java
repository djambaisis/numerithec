package apk.numerithec.numeritehc_grp.numerithec.Controller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Image
{
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
                json=new JSONObject(Controlleur.readStreamJson(in));
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
    public static Bitmap Download()
    {
        URL url=null;
        HttpURLConnection urlConnection=null;
        Bitmap bm=null;
        try {
            url=new URL("");
            urlConnection=(HttpURLConnection)url.openConnection();
            InputStream in=new BufferedInputStream(urlConnection.getInputStream());
            bm= BitmapFactory.decodeStream(in);
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
        return bm;
    }
}
