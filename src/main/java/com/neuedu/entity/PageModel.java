package com.neuedu.entity;
/**
 * 
 * @���ߣ� ���һ����
 * @������ ��ҳģ��
 * @���� ��ʱû��
 * @Ǳ�����������С���δ�������ͣ�
 * @ѧУ����̫ϲ����̫ԭ�Ƽ���ѧ�����µĴ�ѧ
 */

import java.io.Serializable;
import java.util.List;

public class PageModel<T>  implements Serializable{
	//ÿһҳ���ݼ���
    private List<T> data;
  //�ܹ�����ҳ
    private int totalPage;
  //��ǰҳ��
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
