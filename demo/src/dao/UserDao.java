package dao;

import entity.User;

/**
 * 功能：定义Dao接口，用户登陆验证
 * @author sun
 *
 */
public interface UserDao {
	public boolean findLogin(User user) throws Exception;
}
