package uni.sta.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubjectDto {
	
	int sub_cd; //�����ڵ�
	String dept_cd; //�а��ڵ�
	String sub_nm; //���Ǹ�
	String buil_no; //�ǹ���
	String subroom_nm; //���ǽǸ�
	int prof_cd; //������ȣ
	String prof_nm; //�����̸�
	String isu; //�̼�����
	int credit;  //����
	int attend_mem; //��û�ο�
	int max_mem; //�ִ��ο�
	String sub_path; //���ǰ�ȹ�� ���
	int lec_1; //����1
	int lec_2; //����2
	int lec_3;	//����3
	String sem; //�б�
	String sub_state; //���ǿ��� 
	int years; //��������
	String noclass_dt; // �ް���û��¥
	String noclass_state; //�ް�ó������
	String can_dt; //�ް�����
	String sup_dt; //��������
	String can_iu; //�ް�����
	String lec; //���ǽð�

	public void setLec(	int lec_1,int lec_2,int lec_3) {
		
		String lec1="",lec2="",lec3 ="";
		
		if(lec_1/10 ==0) {
			lec1="��"+lec_1%10;
		}
		if(lec_1/10 ==1) {
			lec1="ȭ"+lec_1%10;
		}
		if(lec_1/10 ==2) {
			lec1="��"+lec_1%10;
		}
		if(lec_1/10 ==3) {
			lec1="��"+lec_1%10;
		}
		if(lec_1/10 ==4) {
			lec1="��"+lec_1%10;
		}
		
		if(lec_2/10 ==0) {
			lec2="��"+lec_2%10;
		}
		if(lec_2/10 ==1) {
			lec2="ȭ"+lec_2%10;
		}
		if(lec_2/10 ==2) {
			lec2="��"+lec_2%10;
		}
		if(lec_2/10 ==3) {
			lec2="��"+lec_2%10;
		}
		if(lec_2/10 ==4) {
			lec2="��"+lec_2%10;
		}
		
		if(lec_3/10 ==0) {
			lec3="��"+lec_3%10;
		}
		if(lec_3/10 ==1) {
			lec3="ȭ"+lec_3%10;
		}
		if(lec_3/10 ==2) {
			lec3="��"+lec_3%10;
		}
		if(lec_3/10 ==3) {
			lec3="��"+lec_3%10;
		}
		if(lec_3/10 ==4) {
			lec3="��"+lec_3%10;
		}	
		
		this.lec = lec1+","+lec2+","+lec3;		
	}
}
