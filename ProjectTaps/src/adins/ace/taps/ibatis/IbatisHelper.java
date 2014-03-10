package adins.ace.taps.ibatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.io.Reader;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.common.resources.Resources;

public class IbatisHelper {
    private static final SqlMapClient sqlMap;
    static {
        try {
            String resource = "ibatis-cfg.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(
                    "Error initializing IbatisHelper class. Cause: " + e);
        }
    }

    public static SqlMapClient getSqlMapInstance() {
        return sqlMap;
    }
}
