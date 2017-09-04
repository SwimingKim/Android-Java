package traffic.devsu.su.com.subwayproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.btnSubway)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnBus)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent = null;

        switch (view.getId()) {
            case R.id.btnSubway :
                intent = new Intent(getApplicationContext(), BusActivity.class);
                break;
            case R.id.btnBus :
                intent = new Intent(getApplicationContext(), SubwayActivity.class);
                break;
        }

        startActivity(intent);

    }
}
