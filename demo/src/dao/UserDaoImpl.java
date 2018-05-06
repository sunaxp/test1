package dao;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * ���ܣ�Dao�ľ���ʵ�ֲ�
 * @author sun
 *
 */
public class UserDaoImpl implements UserDao{
	private Connection conn=null;//�������ݿ����Ӷ���
	private PreparedStatement stmt=null;//�������ݿ��������
	public UserDaoImpl() {
		this.conn=conn;
	}

	@Override
	public boolean findLogin(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			String sql="select * from user where name=?and password=?";//��user����в�ѯ����
			stmt=conn.prepareStatement(sql);//ʵ��������
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			ResultSet rSet = stmt.executeQuery();//ȡ�ý��
			if(rSet.next()){
		    	user.setName(rSet.getString(1));//ȡ���û���
		    	flag=true;   	
		    }
		}catch(Exception e) {
			throw e;	
		}finally {
			//�رղ���
			if(stmt!=null){
				try {
					stmt.close();
				} catch (Exception e) {
					throw e;				
			}		
		}
		}
		return flag;
	}

}
