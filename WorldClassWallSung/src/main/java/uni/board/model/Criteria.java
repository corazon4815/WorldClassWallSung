package uni.board.model;

public class Criteria {
	int page; // ������ ��ȣ
	int perPageNum; // �������� �Խñ� ����
	int rowStart; // ������ �� ���� ù��° �Խù� rowNum
	int rowEnd; // ������ �� ���� ������ �Խù� rowNum
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	public int getPage() {
		return page;
	}
	public int getPageStart() {
		// ���������� * ���� ������ �� �Խñ� ���� ���� 
		return (this.page - 1) * perPageNum;
	}
	public int getPerPageNum() {
		return this.perPageNum;
	}
	public int getRowStart() {
		rowStart = ((page-1)*perPageNum)+1;
		return rowStart;
	}
	public int getRowEnd() {
		rowEnd = rowStart + perPageNum - 1;
		return rowEnd;
	}
}
