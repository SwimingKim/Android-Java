import java.util.Arrays;

/**
 * String Ŭ������ Ȱ���ؼ� ���ڿ� ó���ϴ� ����� �˾ƺ���
 * */
public class TestString {
	public static void main(String[] args) {
// ã�����ϴ� ���ڿ��� "�̸�:" ���Ŀ� ���� �� ������
		String str1 = "�̸�:���α�";
//		System.out.println(str1.substring(3));
		
// ã�����ϴ� ���ڿ��� "�̸�:"�� "�ܰ�:"���̿� ���� �� ������
		String str2 = "�̸�:���αԴܰ�:9";
		int index = str2.indexOf("�ܰ�:");
		System.out.println(str2.substring(3, index));//���α�
//		System.out.println(str2.substring(str2.indexOf("�ܰ�:")+3));
		
// "�̸�/�ܰ�/����/�ּ�" �����ڸ� ���� ���س��� �������
		String str3 = "���α�/9/98/Bucheon";
		String arr[] = str3.split("/");
		System.out.println(Arrays.toString(arr));
		String name = arr[0];
		int step = Integer.parseInt(arr[1]);
		int point = Integer.parseInt(arr[2]);
		String address = arr[3];
		
		
		
		
	}//end of main
}//end of class
