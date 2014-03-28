package adins.ace.taps.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.employee.EmployeeBean;
import adins.ace.taps.bean.employee.EmployeeOrganizationBean;
import adins.ace.taps.bean.employee.EmployeeProjectStructureBean;
import adins.ace.taps.bean.employee.NewEmployeeBean;
import adins.ace.taps.bean.organization.OrganizationBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class EmployeeManager {
	public SqlMapClient ibatisSqlMap = null;

	public EmployeeManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}

	public boolean deleteEmployee(Map params) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.update("employee.deleteEmployee", params);
			ibatisSqlMap.update("employee.deleteAssignment", params);
			ibatisSqlMap.delete("employee.deleteRoleEMP", params);
			ibatisSqlMap.delete("employee.deleteEmpOnProject", params);
			flag = true;
			ibatisSqlMap.commitTransaction();

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
			photo = (NewEmployeeBean) ibatisSqlMap.queryForObject(
					"employee.getPhotoEmployees", employeeDomain);
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

	public List<EmployeeOrganizationBean> checkEmplooyeeOrganization(Map params) {
		List<EmployeeOrganizationBean> listEmpOrg = null;
		try {
			ibatisSqlMap.startTransaction();
			listEmpOrg = ibatisSqlMap.queryForList(
					"employee.checkEmplooyeeOrganization", params);
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
		return listEmpOrg;
	}

	public List<EmployeeProjectStructureBean> checkProjectStructure(Map params) {
		List<EmployeeProjectStructureBean> listEmpProject = null;
		try {
			ibatisSqlMap.startTransaction();
			listEmpProject = ibatisSqlMap.queryForList(
					"employee.checkProjectStructure", params);
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
		return listEmpProject;
	}
	

	public Integer countEmplooyeeOrganization(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"employee.countEmplooyeeOrganization", params);
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

	public boolean updateLoginEmployee(Map params) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.update("employee.saveEditLoginEmployees", params);
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

	public boolean insertLoginEmployee(Map params) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("employee.insertLoginEmployee", params);
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
	
	public boolean insertRoleEmp(NewEmployeeBean newEmployee){
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("employee.insertRoleEmployee", newEmployee);
			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
