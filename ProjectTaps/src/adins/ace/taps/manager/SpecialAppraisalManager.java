package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.organization.OrganizationBean;
import adins.ace.taps.bean.specialAppraisal.SpecialAppraisalBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class SpecialAppraisalManager {
	public SqlMapClient ibatisSqlMap = null;

	public SpecialAppraisalManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}

	public List getAll() {
		List list = null;
		SpecialAppraisalBean bean = new SpecialAppraisalBean();
		try {
			System.out.println("masuk list");
			ibatisSqlMap.startTransaction();
			list = ibatisSqlMap.queryForList(
					"SpecialAppraisal.getAllSpecialAppraisal", null);
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("gagal list");
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return list;
	}

	public SpecialAppraisalBean getUserDomain(String starId) {
		List list = null;
		SpecialAppraisalBean bean = new SpecialAppraisalBean();
		try {
			ibatisSqlMap.startTransaction();
			bean = (SpecialAppraisalBean) ibatisSqlMap.queryForObject("SpecialAppraisal.ViewSpecialAppraisal", starId);
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return bean;
	}

//	public SpecialAppraisalBean getUserDomain(String userDomain) {
//		SpecialAppraisalBean mBean = new SpecialAppraisalBean();
//
//		try {
//			ibatisSqlMap.startTransaction();
//			mBean = (SpecialAppraisalBean) ibatisSqlMap.queryForObject("SpecialAppraisal.ViewSpecialAppraisal", userDomain);
//			//mBean = (SpecialAppraisalBean) ibatisSqlMap.queryForList("SpecialAppraisal.ViewSpecialAppraisal", userDomain);
//			ibatisSqlMap.commitTransaction();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				ibatisSqlMap.endTransaction();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return mBean;
//
//	}

	// public List ViewSpecialAppraisal(String userDomain)
	// {
	// List projectMemberList = null;
	// try {
	// ibatisSqlMap.startTransaction();
	// projectMemberList =
	// ibatisSqlMap.queryForObject("SpecialAppraisal.ViewSpecialAppraisal",
	// userDomain);
	// System.out.println("ud :    "+userDomain);
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally{
	// try {
	// ibatisSqlMap.endTransaction();
	// } catch (Exception e2) {
	// e2.printStackTrace();
	// }
	// }
	// return projectMemberList;
	// }

	//
	// public void Insert(SpecialAppraisalBean Bean){
	// try {
	// ibatisSqlMap.startTransaction();
	// ibatisSqlMap.insert("SpecialAppraisal.insertSpecialAppraisal", Bean);
	// ibatisSqlMap.commitTransaction();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }finally{
	// try{
	// ibatisSqlMap.endTransaction();
	// }
	// catch (Exception e2) {
	// // TODO: handle exception
	// e2.printStackTrace();
	// }
	// }
	// }
	//
	// public List<SpecialAppraisalBean> searchOrganizations(Map params) {
	// List<SpecialAppraisalBean> spcList = null;
	// try {
	// ibatisSqlMap.startTransaction();
	// spcList = ibatisSqlMap.queryForList(
	// "SpecialAppraisal.searchSpecialAppraisal.", params);
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// ibatisSqlMap.endTransaction();
	// } catch (Exception e2) {
	// e2.printStackTrace();
	// }
	// }
	// return spcList;
	// }
	//
	// public Integer countSpecialAppraisal(Map params) {
	// Integer count = null;
	// try {
	// ibatisSqlMap.startTransaction();
	// count = (Integer) ibatisSqlMap.queryForObject(
	// "SpecialAppraisal.countSpecialAppraisal", params);
	// ibatisSqlMap.commitTransaction();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// ibatisSqlMap.endTransaction();
	// } catch (Exception e2) {
	// e2.printStackTrace();
	// }
	// }
	// return count;
	// }
}