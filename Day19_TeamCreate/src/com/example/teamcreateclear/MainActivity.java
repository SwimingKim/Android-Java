package com.example.teamcreateclear;

import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	String arrName[] = { "김병일", "김수영", "문새미", "신나은", "장동진", "주희진", "홍정택", "황보람" };
	CheckBox arrCB[] = new CheckBox[arrName.length];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		arrCB[0] = (CheckBox) findViewById(R.id.checkBox1);
		arrCB[1] = (CheckBox) findViewById(R.id.checkBox2);
		arrCB[2] = (CheckBox) findViewById(R.id.checkBox3);
		arrCB[3] = (CheckBox) findViewById(R.id.checkBox4);
		arrCB[4] = (CheckBox) findViewById(R.id.checkBox5);
		arrCB[5] = (CheckBox) findViewById(R.id.checkBox6);
		arrCB[6] = (CheckBox) findViewById(R.id.checkBox7);
		arrCB[7] = (CheckBox) findViewById(R.id.checkBox8);

		for (int i = 0; i < arrName.length; i++) {
			arrCB[i].setText(arrName[i]);
		}

		final TextView tvNum = (TextView) findViewById(R.id.textView2);// 총인원수
		final EditText etNum = (EditText) findViewById(R.id.editText1);// 팀수
		final TextView tvNameList = (TextView) findViewById(R.id.tvNameList);
		final TextView tvTeamList = (TextView) findViewById(R.id.tvTeamList);
		Button b = (Button) findViewById(R.id.button1);

		class MyCCListener implements OnCheckedChangeListener {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// 체크박스 변경 시 호출되는 콜백 메세드
				String result = "";// 체크된 명단
				int num = 0;// 체크된 인원수

				for (int i = 0; i < arrName.length; i++) {
					if (arrCB[i].isChecked()) {// 체크된 상태
						num++;
						result += arrCB[i].getText().toString() + ", ";
					}
				}
				tvNum.setText(num + "");
				tvNameList.setText(result);
			}
		}
		MyCCListener nccl = new MyCCListener();

		for (int i = 0; i < arrCB.length; i++) {
			arrCB[i].setOnCheckedChangeListener(nccl);
		}

		// 팀 랜덤 생성하기
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int teamNum = 0;
				try {
					teamNum = Integer.valueOf(etNum.getText().toString());
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(), "팀수를 숫자로 입력하세요", 1).show();
					return;// onClick메서드를 빠져나감
				}

				if (teamNum <= 0) {
					Toast.makeText(getApplicationContext(), "0을 입력하면 안돼요", 1).show();
					return;
				}

				int num = Integer.valueOf(tvNum.getText().toString());
				int checkIndex[] = new int[num];

				// 체크된 체크박스의 index만 배열에 저장함
				for (int i = 0, j = 0; i < arrName.length; i++) {
					if (arrCB[i].isChecked()) {// 체크된 상태
						checkIndex[j] = i;
						j++;
					}
				}

				// checkBox 배열의 순서를 섞는다(셔플)
				Random ran = new Random();
				for (int i = 0; i < checkIndex.length * 2; i++) {
					int n1 = ran.nextInt(checkIndex.length);
					int n2 = ran.nextInt(checkIndex.length);

					// checkIndex[?]<->checkIndex[?]
					// 자리바꾸기 swap
					int temp = checkIndex[n1];
					checkIndex[n1] = checkIndex[n2];
					checkIndex[n2] = temp;
				}

				// 팀 작성
				String result = "랜덤으로 팀 구성\n";
				int x = num / teamNum;// 한 팀의 인원=체크된 인원/팀 수
				int rest = num % teamNum;// 떨거지 인원

				// result에 출력할 문자열을 담기
				int count = 0;
				for (int i = 1; i <= teamNum; i++) {// 한팀 작성
					result += "\n" + i + "팀 : ";
					for (int j = 0; j < x; j++) {// 한팀의 인원만큼 반복
						result += arrName[checkIndex[count]] + ", ";
						count++;
					}
					if (rest > 0) {// 떨거지 인원이 남아 있으면 1명을 추가
						result += arrName[checkIndex[count]] + ", ";
						count++;
						rest--;
					}
				}
				tvTeamList.setText(result);

			}
		});

	}// end of onCreate
}// end of class
