package dao.dao;

import dao.entity.User;

/**
 * ���ܣ�����Dao�ӿڣ��û���½��֤
 * @author sun
 *
 */
public interface UserDao {
	public boolean findLogin(User user) throws Exception;
}
