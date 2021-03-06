package com.blood.coding.controller.common;

public class MemberPageMaker {

	private int totalCount; // 전체 board 개수
	private int startPage; // 시작 페이지 번호
	private int endPage; // 마지막 페이지 번호
	private int realEndPage; // 끝 페이지 번호
	private boolean prev; // 이전페이지 버튼 유무
	private boolean next; // 다음페이지 버튼 유무

	private int displayPageNum = 10; // 한 페이지에 보여줄 페이지번호 개수

	private MemberCriteria cri; // 현재 페이지 정보
	
	
	public MemberPageMaker() {
		super();
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
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

	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
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

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public MemberCriteria getCri() {
		return cri;
	}

	public void setCri(MemberCriteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", realEndPage=" + realEndPage + ", prev=" + prev + ", next=" + next + ", displayPageNum="
				+ displayPageNum + ", cri=" + cri + "]";
	}

	// starPage,endPage, prev, next 설정. by totalCount
	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) 
																	* displayPageNum);
		startPage = (endPage - displayPageNum) + 1;

		realEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));

		if (endPage > realEndPage) {
			endPage = realEndPage;
		}

		prev = (cri.getPage() == 1) ? false : true;
		next = (cri.getPage() * cri.getPerPageNum()) >= totalCount ? false : true;
	}
	
	public String makeQuery(){	
		String query="?page="+cri.getPage()
				    +"&perPageNum="+cri.getPerPageNum()
				    +"&sort="+((MemberCriteria)cri).getSort()
					+"&alignment="+((MemberCriteria)cri).getAlignment()
					+"&mem_id="+((MemberCriteria)cri).getMem_id()
					+"&mem_name="+((MemberCriteria)cri).getMem_name();
				    
		if (((MemberCriteria) cri).getSearchType() != null) {
			query = query + "&searchType=" + ((MemberCriteria) cri).getSearchType() + "&keyword="+((MemberCriteria) cri).getKeyword();
		}
		return query;
	}
	
	public String makeQuery(int page){	
		String query="?page="+page
				    +"&perPageNum="+cri.getPerPageNum()
				    +"&sort="+((MemberCriteria)cri).getSort()
				    +"&alignment="+((MemberCriteria)cri).getAlignment()
				    +"&mem_id="+((MemberCriteria)cri).getMem_id()
					+"&mem_name="+((MemberCriteria)cri).getMem_name();
		
	    if (((MemberCriteria) cri).getSearchType() != null) {
			query = query + "&searchType=" + ((MemberCriteria) cri).getSearchType() + "&keyword="+((MemberCriteria) cri).getKeyword();
		}
		return query;
	}

}







