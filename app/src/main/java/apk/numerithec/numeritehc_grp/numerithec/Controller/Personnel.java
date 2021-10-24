package apk.numerithec.numeritehc_grp.numerithec.Controller;


import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Personnel
{
    private String nom;
    private String prenom;
    private boolean Authentification;

    public boolean isAuthentification() {
        return Authentification;
    }

    public void setAuthentification(boolean authentification) {
        Authentification = authentification;
    }

    public Personnel(String nom, String prenom, String login, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    private String login;
    private String mdp;
    public static boolean Authentification_online()
    {
        Boolean ret = false;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL("");
            httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = httpURLConnection.getInputStream();
                ret = new Boolean(Controlleur.readStreamJson(in));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) httpURLConnection.disconnect();
        }
        return ret;
    }
    public static JSONObject NewCompte()
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
}
