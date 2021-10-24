package apk.numerithec.numeritehc_grp.numerithec;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class resourcelist extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resourcelist);


        ArrayList<ExampleCard> item1 = new ArrayList<>();
        item1.add(new ExampleCard(R.drawable.ic_audiotrack_black, "titre1", "autheur1", "3:54"));
        item1.add(new ExampleCard(R.drawable.ic_photo_black, "nomImage", "autheur2", "720 X 720"));
        item1.add(new ExampleCard(R.drawable.ic_audiotrack_black, "titre1", "autheur1", "3:54"));
        item1.add(new ExampleCard(R.drawable.ic_photo_black, "nomImage", "autheur2", "720 X 720"));
        item1.add(new ExampleCard(R.drawable.ic_audiotrack_black, "titre1", "autheur1", "3:54"));
        item1.add(new ExampleCard(R.drawable.ic_photo_black, "nomImage", "autheur2", "720 X 720"));
        item1.add(new ExampleCard(R.drawable.ic_audiotrack_black, "titre1", "autheur1", "3:54"));
        item1.add(new ExampleCard(R.drawable.ic_photo_black, "nomImage", "autheur2", "720 X 720"));
        item1.add(new ExampleCard(R.drawable.ic_audiotrack_black, "titre1", "autheur1", "3:54"));
        item1.add(new ExampleCard(R.drawable.ic_photo_black, "nomImage", "autheur2", "720 X 720"));
        item1.add(new ExampleCard(R.drawable.ic_audiotrack_black, "titre1", "autheur1", "3:54"));
        item1.add(new ExampleCard(R.drawable.ic_photo_black, "nomImage", "autheur2", "720 X 720"));
        item1.add(new ExampleCard(R.drawable.ic_audiotrack_black, "titre1", "autheur1", "3:54"));
        item1.add(new ExampleCard(R.drawable.ic_photo_black, "nomImage", "autheur2", "720 X 720"));
        item1.add(new ExampleCard(R.drawable.ic_audiotrack_black, "titre1", "autheur1", "3:54"));
        item1.add(new ExampleCard(R.drawable.ic_photo_black, "nomImage", "autheur2", "720 X 720"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(item1);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public static class ExampleCard {
        private int ImgResource;
        private String titre;
        private String autheur;
        private String taille;

        public ExampleCard() {
            ImgResource=0;
            titre="";
            autheur="";
            taille="";
        }

        public ExampleCard(int imgResource, String titre1, String autheur1, String taille1) {
            ImgResource=imgResource;
            titre=titre1;
            autheur=autheur1;
            taille=taille1;
        }

        public int getImgResource() {
            return ImgResource;
        }

        public String getTitre() {
            return titre;
        }

        public String getAutheur() {
            return autheur;
        }

        public String getTaille() {
            return taille;
        }
    }
}