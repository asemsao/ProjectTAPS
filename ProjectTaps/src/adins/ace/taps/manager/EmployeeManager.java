package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.employee.EmployeeBean;
import adins.ace.taps.bean.employee.NewEmployeeBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class EmployeeManager {
	public SqlMapClient ibatisSqlMap = null;

	public EmployeeManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}
	
	public boolean deleteEmployee(String employeeDomain) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.update("employee.deleteEmployee",employeeDomain);
			ibatisSqlMap.commitTransaction();
			flag = true;

		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				flag = false;
				e2.printStackTrace();
			}
		}
		return flag;
	}

	public boolean updateEmployee(NewEmployeeBean newEmployee) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.update("employee.saveEditEmployees", newEmployee);
			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}

	public boolean insertNewEmployee(NewEmployeeBean newEmployee) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("employee.insertEmployee", newEmployee);
			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}

	public List<EmployeeBean> searchEmployees(Map params) {
		List<EmployeeBean> empList = null;
		try {
			ibatisSqlMap.startTransaction();
			empList = ibatisSqlMap.queryForList("employee.searchEmployees",
					params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return empList;
	}

	public NewEmployeeBean getPhotoEmployees(String employeeDomain) {
		NewEmployeeBean photo = null;
		try {
			ibatisSqlMap.startTransaction();
			photo = (NewEmployeeBean) ibatisSqlMap.queryForObject("employee.getPhotoEmployees", employeeDomain);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return photo;
	}

	public NewEmployeeBean getEditEmployees(Map params) {
		NewEmployeeBean empEdit = null;
		try {
			ibatisSqlMap.startTransaction();
			empEdit = (NewEmployeeBean) ibatisSqlMap.queryForObject(
					"employee.getEditEmployees", params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return empEdit;
	}

	public Integer countEmployees(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"employee.countEmployees", params);
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}

	public List<EmployeeBean> searchEmployeesOnProject(Map params) {
		List<EmployeeBean> empList = null;
		try {
			ibatisSqlMap.startTransaction();
			empList = ibatisSqlMap.queryForList(
					"employee.searchEmployeesOnProject", params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return empList;
	}

	public Integer countEmployeesOnProject(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"employee.countEmployeesOnProject", params);
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}
}
