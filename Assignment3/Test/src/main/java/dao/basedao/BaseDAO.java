package dao.basedao;

import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> {
    protected Connection conn ;
    protected PreparedStatement psmt ;
    protected ResultSet rs ;

    // Class object of T
    private Class entityClass ;

    public BaseDAO() {

        //getGenericSuperclass() obtains the Class of BaseDAO.
        Type genericType = getClass().getGenericSuperclass();
        // ParameterizedType
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
        // Get the real type of T in <>
        Type actualType = actualTypeArguments[0];

        try {
            entityClass = Class.forName(actualType.getTypeName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("Error occurred in BaseDAO constructor, possibly due to unspecified type in <>");
        }

    }

    protected Connection getConn(){
        return ConnUtil.getConn();
    }

    protected void close(ResultSet rs , PreparedStatement psmt , Connection conn){

    }

    // Set parameters for prepared statement
    private void setParams(PreparedStatement psmt , Object... params) throws SQLException {
        if(params!=null && params.length>0){
            for (int i = 0; i < params.length; i++) {
                psmt.setObject(i+1,params[i]);
            }
        }
    }

    // Execute update and return the number of affected rows
    protected int executeUpdate(String sql , Object... params) {
        boolean insertFlag = false ;
        insertFlag = sql.trim().toUpperCase().startsWith("INSERT");

        conn = getConn();
        try{
            if(insertFlag){
                psmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            }else {
                psmt = conn.prepareStatement(sql);
            }
            setParams(psmt,params);
            int count = psmt.executeUpdate() ;

            if(insertFlag){
                rs = psmt.getGeneratedKeys();
                if(rs.next()){
                    return ((Long)rs.getLong(1)).intValue();
                }
            }
            return 0 ;
        }catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("Error occurred in BaseDAO executeUpdate");
        }
    }

    // Set value for obj's property using reflection
    private void setValue(Object obj ,  String property , Object propertyValue) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class clazz = obj.getClass();

        // Get the attribute name corresponding to property string, e.g., "fid" matches the fid attribute in obj
        Field field = clazz.getDeclaredField(property);
        if(field!=null){

            // Get the type name of current field
            String typeName = field.getType().getName();
            // If it's a custom type, call the constructor with one parameter of this custom class to create an instance,
            // then assign this instance to the property
            if(isMyType(typeName)){
                // Suppose typeName is "com.atguigu.qqzone.pojo.UserBasic"
                Class typeNameClass = Class.forName(typeName);
                Constructor constructor = null;
                if(typeName.equals("java.lang.Double")){
                    constructor= typeNameClass.getDeclaredConstructor(double.class);
                }else{
                    constructor=typeNameClass.getDeclaredConstructor(Integer.class);
                }
                propertyValue = constructor.newInstance(propertyValue);

            }
            field.setAccessible(true);
            field.set(obj,propertyValue);
        }
    }

    private static boolean isNotMyType(String typeName){
        return "java.lang.Integer".equals(typeName)
                || "java.lang.String".equals(typeName)
                || "java.util.Date".equals(typeName)
                || "java.sql.Date".equals(typeName);
    }

    private static boolean isMyType(String typeName){
        return !isNotMyType(typeName);
    }

    // Execute complex query and return, e.g., statistical results
    protected Object[] executeComplexQuery(String sql , Object... params){
        conn = getConn() ;
        try{
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            rs = psmt.executeQuery();

            // ResultSet metadata
            ResultSetMetaData rsmd = rs.getMetaData();
            // Get column count
            int columnCount = rsmd.getColumnCount();
            Object[] columnValueArr = new Object[columnCount];
            // Parse rs
            if(rs.next()){
                for(int i = 0 ; i<columnCount;i++){
                    Object columnValue = rs.getObject(i+1);
                    columnValueArr[i]=columnValue;
                }
                return columnValueArr ;
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new DAOException("Error occurred in BaseDAO executeComplexQuery");
        }

        return null ;
    }

    // Execute query and return a single entity object
    protected T load(String sql , Object... params){
        conn = getConn() ;
        try{
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            rs = psmt.executeQuery();

            // ResultSet metadata
            ResultSetMetaData rsmd = rs.getMetaData();
            // Get column count
            int columnCount = rsmd.getColumnCount();
            // Parse rs
            if(rs.next()){
                T entity = (T)entityClass.newInstance();

                for(int i = 0 ; i<columnCount;i++){
                    String columnName = rsmd.getColumnName(i+1);
                    Object columnValue = rs.getObject(i+1);
                    setValue(entity,columnName,columnValue);
                }
                return entity ;
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new DAOException("Error occurred in BaseDAO load");
        }

        return null ;
    }

    // Execute query and return a List
    protected List<T> executeQuery(String sql , Object... params){
        List<T> list = new ArrayList<>();
        conn = getConn() ;
        try{
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            rs = psmt.executeQuery();

            // ResultSet metadata
            ResultSetMetaData rsmd = rs.getMetaData();
            // Get column count
            int columnCount = rsmd.getColumnCount();
            // Parse rs
            while(rs.next()){
                T entity = (T)entityClass.newInstance();

                for(int i = 0 ; i<columnCount;i++){
                    String columnName = rsmd.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(i+1);
                    setValue(entity,columnName,columnValue);
//                    System.out.println(columnValue.getClass().getName());
////                    System.out.println(i);
                }
                list.add(entity);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new DAOException("Error occurred in BaseDAO executeQuery");
        }
        return list ;
    }
}
