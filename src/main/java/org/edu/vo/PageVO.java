package org.edu.vo;

public class PageVO {
	private int startNo;
	private int perPageNum;
	private Integer page; // jsp에서 null로 값이 올때 에러가 발생하지 않도록 Integer 사용
	private int startPage;
	private int endPage;
	private int totalCount;
	private boolean prev;
	private boolean next;
	// 검색용 변수 2개 추가
	private String searchType;
	private String searchKeyword;
	
	private void calcPage() {
		// page변수는 현재 jsp에서 클릭한 페이지번호
		int tempEnd = (int)(Math.ceil(page / (double)this.perPageNum) * this.perPageNum); 
		// ceil함수는 천장함수로 1.1은 -> 2출력, 2.1은 -> 3출력
		// 반대 되는 바닥함수로 floor(), 반올림 함수로 round() 가 있다.
		// jsp에서 클릭한 페이지번호를 기준으로 끝 페이지를 계산한다.
		this.startPage = (tempEnd - this.perPageNum)+1;
		// 시작 페이지 계산 클릭한 page번호가 10일때 까지 시작페이지는 1
		if (tempEnd * this.perPageNum > this.totalCount) { 
			// 클릭한 page번호로 계산된 게시물수가 실제 게시물 개수가 totalCount보다 클 때
			this.endPage = (int) Math.ceil(this.totalCount / (double)this.perPageNum);
		} else {
			// 클릭한 page번호로 계산된 게시물수가 실제 게시물 개수가 totalCount보다 작을 때
			this.endPage = tempEnd;
		}
		this.prev = this.startPage != 1; //시작페이지가 1보다 크면 무조건 이전 페이지가 있음. true
		this.next = this.endPage * this.perPageNum < this.totalCount; 
		// 클릭한 page번호로 계산된 게시물수가 실제 게시물 개수 보다 작으면 다음 페이지가 있음. true
	}
	
	public int getStartNo() {
		//DB쿼리에서 사용... 시작 데이터 번호 = (jsp 클리한 페이지 수 -1) * 페이지당 보여지는 개수
		startNo = (this.page - 1) * perPageNum;
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcPage(); // totalCount 전체 게시물 개수가 있어야 페이지 계산을 할 수 있기 때문
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
}
