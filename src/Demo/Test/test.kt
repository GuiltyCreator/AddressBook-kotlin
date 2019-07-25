package Demo.test

import Demo.db.factory.DAOFactory
import Demo.db.vo.Friend
import Demo.service.FriendService

fun main() {
    val friend:Friend=DAOFactory.getIFriendDAOInstance().find(1)!!
    println("Id:${friend.id}")
    println("姓名:${friend.name}")
    println("电话:${friend.phone}")
    println("备注:${friend.note}")

    FriendService.writeFriendsToFile("""D:\work""","通讯录.txt")
}