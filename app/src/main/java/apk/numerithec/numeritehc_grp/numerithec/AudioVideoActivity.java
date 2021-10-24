package apk.numerithec.numeritehc_grp.numerithec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;

import apk.numerithec.numeritehc_grp.numerithec.ExampleAdapter;
import apk.numerithec.numeritehc_grp.numerithec.R;
import apk.numerithec.numeritehc_grp.numerithec.resourcelist;

public class AudioVideoActivity extends AppCompatActivity {

    //private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resourcelist);
        //this.configureToolBar();

        Toolbar tool2 = findViewById(R.id.maToolbar);
        setSupportActionBar(tool2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<resourcelist.ExampleCard> item1 = new ArrayList<>();
        item1.add(new resourcelist.ExampleCard(R.drawable.ic_audiotrack_black, "titre1", "autheur1", "3:54"));
        item1.add(new resourcelist.ExampleCard(R.drawable.ic_photo_black, "nomImage", "autheur2", "720 X 720"));
        item1.add(new resourcelist.ExampleCard(R.drawable.ic_audiotrack_black, "titre1", "autheur1", "3:54"));
        item1.add(new resourcelist.ExampleCard(R.drawable.ic_photo_black, "nomImage", "autheur2", "720 X 720"));
        item1.add(new resourcelist.ExampleCard(R.drawable.ic_audiotrack_black, "titre1", "autheur1", "3:54"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(item1);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    //Le menu d'option alias le btn de recherche
    /*public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    private void configureToolBar()
    {
        this.toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
    }*/
}
