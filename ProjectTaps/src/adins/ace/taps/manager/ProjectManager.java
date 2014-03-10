package adins.ace.taps.manager;

import java.util.List;

import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class ProjectManager 
{
	public SqlMapClient ibatisSqlMap = null;

	public ProjectManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}

	public List getAllProject()
	{
		List projectList = null;
		try {
			ibatisSqlMap.startTransaction();
			projectList = ibatisSqlMap.queryForList("project.getAllProject", null);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return projectList;		
	}
}
