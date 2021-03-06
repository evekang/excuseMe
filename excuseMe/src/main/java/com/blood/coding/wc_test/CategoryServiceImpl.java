
package com.blood.coding.wc_test;

import java.sql.SQLException;
import java.util.List;

import com.blood.coding.dao.category.CategoryDAO;
import com.blood.coding.dto.category.CategoryVO;

//?λΉμ€ ?????―
public class CategoryServiceImpl {

	private CategoryDAO categoryDAO;
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO  = categoryDAO;
	}
	
	
	//??λΆλ₯ μΉ΄νκ³ λ¦¬ μ‘°ν
	public List<CategoryVO> getCategoryList() throws SQLException {
		//μ»€λ°?λ¬Έμ ?? ?¨
		return categoryDAO.selectCategoryList();
	}
	
	//??λΆλ₯ μΉ΄νκ³ λ¦¬λ₯? μ°Έμ‘°? ?λΆλ₯ μΉ΄νκ³ λ¦¬ λ¦¬μ€?Έ μ‘°ν
	public List<CategoryVO> getSubCategoryList(int cate_no) throws SQLException {
		
		return categoryDAO.selectSubCategoryList(cate_no);
	}
	

}
