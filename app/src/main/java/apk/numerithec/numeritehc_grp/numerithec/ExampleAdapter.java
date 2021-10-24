package apk.numerithec.numeritehc_grp.numerithec;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleView> {
    private ArrayList<resourcelist.ExampleCard> exampleCard1;

    public static class ExampleView extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;

        public ExampleView(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.txtTitre);
            textView2 = itemView.findViewById(R.id.txtAutheur);
            textView3 = itemView.findViewById(R.id.txtTaille);
        }
    }

    public ExampleAdapter(ArrayList<resourcelist.ExampleCard> exList) {
        exampleCard1 = exList;
    }

    @Override
    public ExampleView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_example_card, viewGroup, false);
        ExampleView exView = new ExampleView(v);
        return exView;
    }

    @Override
    public void onBindViewHolder(ExampleView exampleView, int i) {
        resourcelist.ExampleCard currentItem = exampleCard1.get(i);

        exampleView.imageView.setImageResource(currentItem.getImgResource());
        exampleView.textView1.setText(currentItem.getTitre());
        exampleView.textView2.setText(currentItem.getAutheur());
        exampleView.textView3.setText(currentItem.getTaille());
    }

    @Override
    public int getItemCount() {
        return exampleCard1.size();
    }
}
