package cn.ds.page;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> {
	// 当前页码
	private int pageNo;
	// 一页显示的条数
	private int pageSize;
	// 总的记录数
	private int totalRows;
	// 总的页数:计算出来
	private int totalPages;
	// 当前页的数据
	private List<T> rows = new ArrayList<T>();

	public Pager(int pageNo, int pageSize, int totalRows) {
		System.out.println("baseQuery pageNo:"+pageNo);
		System.out.println("baseQuery pageSize:"+pageSize);
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalRows = totalRows;

		// 做错误处理
		if (this.pageNo < 1) {
			this.pageNo = 1;
		}
		if (this.pageSize < 1) {
			this.pageSize = 10;
		}

		this.totalPages = (this.totalRows + this.pageSize - 1) / this.pageSize;

		if (this.pageNo > this.totalPages) {
			this.pageNo = this.totalPages;
		}
		System.out.println("Pager pageNo:"+this.pageNo);
		System.out.println("Pager pageSize:"+this.pageSize);
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
