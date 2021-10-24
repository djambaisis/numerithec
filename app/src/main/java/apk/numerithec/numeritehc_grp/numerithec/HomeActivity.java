package apk.numerithec.numeritehc_grp.numerithec;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout draw;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private NavigationView navigationView_acc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.configureToolBar();
        this.configureDrawerLayout();
        this.configureNavigationView();

    }



    @Override
    public void onBackPressed()
    {
        if(this.draw.isDrawerOpen(GravityCompat.START))
        {
            this.draw.closeDrawer(GravityCompat.START);
        }
        else super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        //Le clic de chaque bouton lance une activité

        switch (item.getItemId())
        {
            case R.id.btn_modif_compte:
                this.draw.closeDrawer(GravityCompat.START);
                break;
            case R.id.btn_help:
                this.draw.closeDrawer(GravityCompat.START);
                break;
            case R.id.btn_logout:
                this.draw.closeDrawer(GravityCompat.START);
                break;
            //gestion des evenements du navigationview de l'acceuil
            case R.id.btn_acceuil_doc://btn de document
                Intent intent_doc=new Intent(HomeActivity.this, DocsActivity.class);
                startActivity(intent_doc);
                break;
            case R.id.btn_acceuil_img://btn image
                Intent intent_img=new Intent(HomeActivity.this, ImgActivity.class);
                startActivity(intent_img);
                break;
            case R.id.btn_accueil_music://btn audio et video
                Intent intent_sons=new Intent(HomeActivity.this, AudioVideoActivity.class);
                startActivity(intent_sons);
                break;
            default:
                break;
        }
        return true;
    }
    //ToolBar
    private void configureToolBar()
    {
        this.toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
    }

    //DrawerLayout
    private void configureDrawerLayout()
    {
        this.draw=findViewById(R.id.drawlayout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,draw,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        draw.addDrawerListener(toggle);
        toggle.syncState();
    }

    //NavigationView
    private void configureNavigationView()
    {
        //NavigationView des parametres
        this.navigationView=findViewById(R.id.nav_view_home);
        navigationView.setNavigationItemSelectedListener(this);

        //Le navigation view de l'acceuil
        this.navigationView_acc=findViewById(R.id.nav_view_home_acc);
        navigationView_acc.setNavigationItemSelectedListener(this);
    }

    //Le menu d'option alias le btn de recherche
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }


    //Les evenements de clic sur le menu: sur le btn de recherche
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.btn_search:
                //gestion du clic sur le btn de recherche
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
