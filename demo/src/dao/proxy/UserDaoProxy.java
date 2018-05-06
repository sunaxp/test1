package dao.proxy;

import dao.UserDao;
import entity.User;
import util.DBHelper;

/**
 * ���ܣ�����Dao������
 * @author sun
 *
 */
public class UserDaoProxy implements UserDao {
	private DBHelper dbc = null;
	private UserDao dao = null;

	@Override
	public boolean findLogin(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			flag=dao.findLogin(user);//������ʵ����
		}catch(Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return flag;
	}

}
