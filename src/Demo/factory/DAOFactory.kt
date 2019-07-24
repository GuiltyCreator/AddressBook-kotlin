package Demo.factory

import Demo.DAO.FriendDAOProxy
import Demo.DAO.IFriendDAO

object DAOFactory{
    fun getIFriendDAOInstance():IFriendDAO=FriendDAOProxy()

}