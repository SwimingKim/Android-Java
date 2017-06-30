package drink.dev.su.com.drinkproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by suyoung on 2017. 6. 30..
 */

public class ScoreActivity extends AppCompatActivity {

    String[] drinks = {"소주", "맥주", "막걸리", "과일 소주", "와인", "양주"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);


        GridView gv = (GridView)findViewById(R.id.gv);
        GridAdapter ga = new GridAdapter(getApplicationContext(), drinks, R.layout.grid_row);
        gv.setAdapter(ga);


    }

    class GridAdapter extends BaseAdapter {

        String[] drinks;
        int layout;
        LayoutInflater lif;

        public GridAdapter(Context context, String[] drinks, int layout) {
            this.drinks = drinks;
            this.layout = layout;
            this.lif = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return drinks.length;
        }

        @Override
        public Object getItem(int i) {
            return drinks[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view == null) {
                view = lif.inflate(layout, null);
            }

            TextView tv = view.findViewById(R.id.name);
            tv.setText(drinks[i]);

            return view;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View actionbar = inflater.inflate(R.layout.custom_actionbar, null);
        ((TextView)actionbar.findViewById(R.id.title)).setText("을~매나 마셨게요?");
        actionBar.setCustomView(actionbar);

        Toolbar parent = (Toolbar) actionbar.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        return true;
    }
}
