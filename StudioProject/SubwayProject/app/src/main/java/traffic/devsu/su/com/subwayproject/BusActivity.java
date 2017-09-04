package traffic.devsu.su.com.subwayproject;

import android.app.Activity;
import android.os.Bundle;

import kr.go.seoul.trafficbus.TrafficBusButtonTypeA;
import kr.go.seoul.trafficbus.TrafficBusButtonTypeB;
import kr.go.seoul.trafficbus.TrafficBusButtonTypeN;
import kr.go.seoul.trafficbus.TrafficBusTypeMini;

/**
 * Created by suyoung on 2017. 9. 4..
 */

public class BusActivity extends Activity {

    private String busKey = "sample";

    private TrafficBusButtonTypeA busTypeA;
    private TrafficBusButtonTypeB busTypeB;
    private TrafficBusButtonTypeN busTypeN;

    private TrafficBusTypeMini busTypeMini;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus);

        busTypeA = (TrafficBusButtonTypeA) findViewById(R.id.bus_type_a);
        busTypeB = (TrafficBusButtonTypeB) findViewById(R.id.bus_type_b);
        busTypeN = (TrafficBusButtonTypeN) findViewById(R.id.bus_type_n);
        busTypeMini = (TrafficBusTypeMini) findViewById(R.id.bus_type_mini);

        busTypeA.setOpenAPIKey(busKey);
        busTypeB.setOpenAPIKey(busKey);
        busTypeN.setOpenAPIKey(busKey);
        busTypeMini.setOpenAPIKey(busKey);
    }
}
