package apk.numerithec.numeritehc_grp.numerithec.Controller;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;


public class ServiceBackgroundTask extends IntentService
{
    public static int ImageRessource=0;
    public static int VideoRessource=1;
    public static int DocsRessource=2;
    ResultReceiver resultReceiver;

    public ServiceBackgroundTask()
    {
        super("ServiceBackgroundTask.net");
        //initialisation du service
    }

    public void list(int ressourceType,int debut,int fin)
    {
        if(ressourceType==ServiceBackgroundTask.ImageRessource)
        {

            //Lancement de la requete vers le serveur pour affiché la liste de certain élément en fonction de l'url
        }
        else if(ressourceType==ServiceBackgroundTask.DocsRessource)
        {

        }
        else if(ressourceType==ServiceBackgroundTask.VideoRessource)
        {

        }

    }
    public void Download(int ressourceType,int debut,int fin)
    {
        if(ressourceType==ServiceBackgroundTask.ImageRessource)
        {

        }
        else if(ressourceType==ServiceBackgroundTask.DocsRessource)
        {

        }
        else if(ressourceType==ServiceBackgroundTask.VideoRessource)
        {

        }
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        resultReceiver=intent.getParcelableExtra("receiver");
        Bundle b=new Bundle();
        //la fonction putX() permet de renvoyer des elements
        //on recupere les argument a l'intent
        //en fonction des argument on fait l'action appropié
        //Pour le resultat de l'opération
        resultReceiver.send();//pour envoyer des trucs
    }


}
