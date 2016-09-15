/**
 * String�� ����ӵ��� ������ StringBuffer (�̱� ������ ��) StringBuilder(��Ƽ ������ ��)
 */
public class TestStringBuffer {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");// ���ڿ� ũ�� + ���� 16

		System.out.println(sb.length());// ���ڿ��� ����
		System.out.println(sb.capacity());// ���ڿ� ũ�� + ���� ũ��
		System.out.println(sb.charAt(2));
		System.out.println(sb.delete(1, 2));// ����, 1���� 2������
		System.out.println(sb);// ó���� ���� ����Ǿ������
		System.out.println(sb.insert(1, "helloworld"));
		System.out.println(sb);
		// ahelloWorldc
		// 012345678901
		System.out.println(sb.substring(4, 8));// ���� �ȵ�
		System.out.println(sb);
		System.out.println(sb.reverse());// �������� ���

		// ����
		String str = "HelloWorld";
		// �������� ����Ͻÿ�
		StringBuffer sb2 = new StringBuffer(str);// String=>StringBuffer
		sb2.reverse();
		System.out.println(sb2.toString());

	}// end of main
}// end of class
