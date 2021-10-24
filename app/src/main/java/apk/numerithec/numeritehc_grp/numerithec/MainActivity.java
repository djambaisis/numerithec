package apk.numerithec.numeritehc_grp.numerithec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import apk.numerithec.numeritehc_grp.numerithec.Controller.ServiceBackgroundTask;

public class MainActivity extends AppCompatActivity {

    private Button btn =null;
    private BroadcastReceiver receiver;
    class RReceveir extends ResultReceiver {
        public RReceveir(Handler handler)
        {
            super(handler);
        }

        public void onReceiveResult(int resultCode, Bundle intent) {
            //Fonction pour obtenir le resultat dpuis l bundle
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//l'activité d chargement
        //receiver=new RReceveir();
        Intent service=new Intent(this, ServiceBackgroundTask.class);
        //doit ajoutr les extras pour savoir si c'est un nouvel utilisatur (sans compte)
        //ou s'il existe deja son compte
        service.putExtra("receiver",new RReceveir(new Handler()));//on envoie le tunel de communication au service
        startService(service);
        //dans le cas ou c'est un nouvel utilisatur on affiche le formulaire
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn_con);
        //sinnon on demare automatiquement le HomeActivity

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(getApplicationContext(), HomeActivity.class);
               startActivity(i);
            }
        });
    }

    /*@Override
    protected void onResume()
    {
        super.onResume();
        //On déclare notre BroadcastReceiver
        IntentFilter filter=new IntentFilter();
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        //on desenregistre le receiver
        unregisterReceiver(receiver);
    }
    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.btn_con:
                //String log=findViewById(R.id.txt_lg).getText();
                //String mdp=findViewById(R.id.txt_mdp).getText();
                //Envoi du log et du mdp au serveur
                //En fonction de la presence du reseau et ou du retour serveur on lui redirige vers la bonne page ou on affiche le messages d'erreur
                Toast notif = Toast.makeText(MainActivity.this,R.string.sign_error,Toast.LENGTH_LONG);//Erreur doit être remplacé par les élements
                notif.setGravity(Gravity.BOTTOM,0,0);
                notif.show();

                //si tout c'est bien passé
                Intent acceuilActivity=new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(acceuilActivity);
                break;
        }
    }*/


}
