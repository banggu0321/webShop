package com.kosta.dto;

import java.sql.Date;

public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private int writer;
	private Date regdate;
	private Date updatedate;
	 
	 
	private EmpVO emp;
	
	public EmpVO getEmp() {
		System.out.println("getEmp...."+emp);
		return emp;
	}
	public void setEmp(EmpVO emp) {
		System.out.println("setEmp...."+emp);
		this.emp = emp;
	}
	public BoardVO(String title, String content, int writer, EmpVO emp) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.emp = emp;
	}
	
	public BoardVO() {}
	public BoardVO(String title, String content, int writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public BoardVO(int bno, String title, String content, int writer, Date regdate, Date updatedate) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardVO [bno=").append(bno).append(", title=").append(title).append(", content=")
				.append(content).append(", writer=").append(writer).append(", regdate=").append(regdate)
				.append(", updatedate=").append(updatedate).append("]");
		return builder.toString();
	}
}