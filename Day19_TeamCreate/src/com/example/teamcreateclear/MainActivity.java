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

	String arrName[] = { "�躴��", "�����", "������", "�ų���", "�嵿��", "������", "ȫ����", "Ȳ����" };
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

		final TextView tvNum = (TextView) findViewById(R.id.textView2);// ���ο���
		final EditText etNum = (EditText) findViewById(R.id.editText1);// ����
		final TextView tvNameList = (TextView) findViewById(R.id.tvNameList);
		final TextView tvTeamList = (TextView) findViewById(R.id.tvTeamList);
		Button b = (Button) findViewById(R.id.button1);

		class MyCCListener implements OnCheckedChangeListener {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// üũ�ڽ� ���� �� ȣ��Ǵ� �ݹ� �޼���
				String result = "";// üũ�� ���
				int num = 0;// üũ�� �ο���

				for (int i = 0; i < arrName.length; i++) {
					if (arrCB[i].isChecked()) {// üũ�� ����
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

		// �� ���� �����ϱ�
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int teamNum = 0;
				try {
					teamNum = Integer.valueOf(etNum.getText().toString());
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(), "������ ���ڷ� �Է��ϼ���", 1).show();
					return;// onClick�޼��带 ��������
				}

				if (teamNum <= 0) {
					Toast.makeText(getApplicationContext(), "0�� �Է��ϸ� �ȵſ�", 1).show();
					return;
				}

				int num = Integer.valueOf(tvNum.getText().toString());
				int checkIndex[] = new int[num];

				// üũ�� üũ�ڽ��� index�� �迭�� ������
				for (int i = 0, j = 0; i < arrName.length; i++) {
					if (arrCB[i].isChecked()) {// üũ�� ����
						checkIndex[j] = i;
						j++;
					}
				}

				// checkBox �迭�� ������ ���´�(����)
				Random ran = new Random();
				for (int i = 0; i < checkIndex.length * 2; i++) {
					int n1 = ran.nextInt(checkIndex.length);
					int n2 = ran.nextInt(checkIndex.length);

					// checkIndex[?]<->checkIndex[?]
					// �ڸ��ٲٱ� swap
					int temp = checkIndex[n1];
					checkIndex[n1] = checkIndex[n2];
					checkIndex[n2] = temp;
				}

				// �� �ۼ�
				String result = "�������� �� ����\n";
				int x = num / teamNum;// �� ���� �ο�=üũ�� �ο�/�� ��
				int rest = num % teamNum;// ������ �ο�

				// result�� ����� ���ڿ��� ���
				int count = 0;
				for (int i = 1; i <= teamNum; i++) {// ���� �ۼ�
					result += "\n" + i + "�� : ";
					for (int j = 0; j < x; j++) {// ������ �ο���ŭ �ݺ�
						result += arrName[checkIndex[count]] + ", ";
						count++;
					}
					if (rest > 0) {// ������ �ο��� ���� ������ 1���� �߰�
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
