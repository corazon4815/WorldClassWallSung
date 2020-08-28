package uni.stu.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelScheduleDto {
	private int stu_no; // �л���ȣ
	private String stu_name; // �л��̸�
	private int sub_cd; // �����ڵ�
	private String sub_nm; // ���Ǹ�
	private int lec_1;
	private int lec_2;
	private int lec_3;
	private int prof_cd;
	private String prof_nm;
	private String subroom_nm; // ���ǽǸ�
	private String dept_cd;
	private String dept_nm;
	private String buil_no; // �ǹ���
}