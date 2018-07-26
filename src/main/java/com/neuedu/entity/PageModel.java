package com.neuedu.entity;
/**
 * 
 * @作者： 最后一个人
 * @描述： 分页模型
 * @对象： 暂时没有
 * @潜力：爱编码的小伙，有未来，加油！
 * @学校：不太喜欢的太原科技大学，啰嗦的大学
 */

import java.io.Serializable;
import java.util.List;

public class PageModel<T>  implements Serializable{
	//每一页数据集合
    private List<T> data;
  //总共多少页
    private int totalPage;
  //当前页面
    private int currentPage;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	

}
