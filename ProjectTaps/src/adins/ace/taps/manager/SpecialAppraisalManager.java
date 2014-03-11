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
			// System.out.println("masuk list");
			ibatisSqlMap.startTransaction();
			list = ibatisSqlMap.queryForList(
					"SpecialAppraisal.getAllSpecialAppraisal", null);
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// System.out.println("gagal list");
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
			bean = (SpecialAppraisalBean) ibatisSqlMap.queryForObject(
					"SpecialAppraisal.ViewSpecialAppraisal", starId);
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

	public void Insert(SpecialAppraisalBean Bean) {
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap
					.insert("SpecialAppraisal.insertSpecialAppraisal", Bean);
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
	}

	public List searchSpecialAppraisal(Map params) {
		List list = null;
		try {
			ibatisSqlMap.startTransaction();
			list = ibatisSqlMap.queryForList(
					"SpecialAppraisal.searchSpecialAppraisal", params);
			ibatisSqlMap.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
}