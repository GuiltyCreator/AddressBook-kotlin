package Demo.db.factory

import Demo.db.DAO.FriendDAOProxy
import Demo.db.DAO.IFriendDAO

/**
 * 工厂类，通过工厂类取得一个DAO的实例化对象。
 *
 */
object DAOFactory{
    fun getIFriendDAOInstance():IFriendDAO=FriendDAOProxy()
}