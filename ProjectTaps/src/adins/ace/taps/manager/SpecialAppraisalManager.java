package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.List;

import adins.ace.taps.bean.specialAppraisal.SpecialAppraisalBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;


public class SpecialAppraisalManager {
	public SqlMapClient ibatisSqlMap = null;

	public SpecialAppraisalManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}

	public List getAll(){
		List list = null;
		SpecialAppraisalBean bean = new SpecialAppraisalBean();
		try {
			System.out.println("masuk list");
			ibatisSqlMap.startTransaction();
			list = ibatisSqlMap.queryForList("SpecialAppraisal.getAllSpecialAppraisal",null);			
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("gagal list");
			e.printStackTrace();
		} finally{
			try{
				ibatisSqlMap.endTransaction();
			}
			catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List getDetail(Integer starId){
		List list = null;
		SpecialAppraisalBean bean = new SpecialAppraisalBean();
		try {
			ibatisSqlMap.startTransaction();
			list = ibatisSqlMap.queryForList("SpecialAppraisal.getDetailSpecialAppraisal",starId);			
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				ibatisSqlMap.endTransaction();
			}
			catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public void Insert(SpecialAppraisalBean Bean){
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("SpecialAppraisal.insertSpecialAppraisal", Bean);
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				ibatisSqlMap.endTransaction();
			}
			catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}