package uni.board.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 5;
	private Criteria cri;
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	
	public Criteria getCri() {
		return cri;
	}
	// ����¡ ó���� ����ϴ� �޼ҵ�
	private void calcData() {
		// 1~10 �������� endPage�� 10���� �����ǰ� 11~20 �������� endPage�� 20���� �����Ǵ� ���
		endPage = (int) (Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		// startPage�� �� ù��° ������
		startPage = (endPage - displayPageNum) + 1;
	  
		int tempEndPage = (int) (Math.ceil(totalCount / (double)cri.getPerPageNum()));
		if (endPage > tempEndPage) {
			// ������ �Խù��� �ִ� �������� endPage�� �ٽ� �Ҵ����ش�.
			endPage = tempEndPage;
		}
		// ù��° �������� 1�̸� false�� ��ȯ�Ͽ� ������ư�� ������� �Ѵ�.
		prev = startPage == 1 ? false : true;
		// �������������� �Խñ��� 10�� ���ϸ� false�� ��ȯ.
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
						    .queryParam("page", page)
							.queryParam("perPageNum", cri.getPerPageNum())
							.build();
		   
		return uriComponents.toUriString();
	}
	public String makeSearch(int page) {
		// ���ϴ� �������� ������ �������� �����ش�.
		UriComponents uriComponents = 
			UriComponentsBuilder.newInstance().queryParam("page", page) // page��ȣ�� �Ķ���Ͱ����� �����ش�.
			.queryParam("perPageNum", cri.getPerPageNum()) // page�� �Խñ� ������ �Ķ���Ͱ����� �����ش�.
			.queryParam("searchType", ((SearchCriteria)cri).getSearchType()) // �˻� �� Ÿ���� �Ķ���Ͱ����� �����ش�.
			.queryParam("keyword", encoding(((SearchCriteria)cri).getKeyword())) // �˻��� ������ �Ķ���Ͱ����� �����ش�.
			.build();
		return uriComponents.toUriString();
	}
	private String encoding(String keyword) {
		if(keyword == null || keyword.trim().length() == 0) {
			return "";
		}
		try {
			return URLEncoder.encode(keyword, "UTF-8");
			
		} catch(UnsupportedEncodingException e) {
			return "";
		}
	}
}
