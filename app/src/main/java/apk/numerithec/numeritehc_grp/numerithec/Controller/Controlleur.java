package apk.numerithec.numeritehc_grp.numerithec.Controller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.Context.CONNECTIVITY_SERVICE;
import static android.support.v4.content.ContextCompat.getSystemService;

public abstract class Controlleur
{
    public static int WIFI=0;
    public static int MOBILE=1;
    public static int NO_CONNEXION=-1;
    protected boolean authentificated=false;

   public boolean Authentification()
   {
    //fonction d'authentification
       return true;
   }
    protected InputStream get(String lien, String method) throws IOException
    {
        InputStream input=null;
        try
        {
            URL url=new URL(lien);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(method);
            input=httpURLConnection.getInputStream();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return input;
    }
    public static String readStreamJson(InputStream in)  throws IOException
    {
        StringBuilder sb=new StringBuilder();
        BufferedReader r=new BufferedReader(new InputStreamReader(in),1000);
        for (String line=r.readLine();line!=null;line=r.readLine())
        {
            sb.append(line);
        }
        in.close();
        return  sb.toString();
    }

   public boolean isAucthentificated()
   {
       return authentificated;//veirifie si authentifier
   }
   public static boolean networkConnected()//Test de connectivité internet sur un reseau wifi ou mobile
   {
       ConnectivityManager con=getSystemService(Context.CONNECTIVITY_SERVICE);
       NetworkInfo networkInfo =con.getActiveNetworkInfo();
       if(networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) return  true;
       return false;
   }
   public int typeOfConnexion()//type de connexion etatbli: wifi ou mobile
   {
       /*NetworkInfo networkInfo =(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE).getActiveNetworkInfo();
       if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI) return Controlleur.WIFI;
       else if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) return  Controlleur.MOBILE;
       else return Controlleur.NO_CONNEXION;*/
       return 0;
   }

}
