package Demo.service

import Demo.db.factory.DAOFactory
import Demo.db.vo.Friend
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import java.lang.Exception

object FriendService{

    /**
     * 将好友信息写入到文件 注意：绝对路径与相对路径的使用
     *@param path 写入文件的路径
     *@param fileName 写入文件的文件名
     *@return
     */
    fun writeFriendsToFile(path:String,fileName:String){
        var fileWriter:FileWriter?=null
        var printWriter:PrintWriter?=null
        try {
            val file=File(path)
            if(!file.exists()) file.createNewFile()
            //如果文件不存在，则创建文件
            val fullName=if(!path.isEmpty())"$path/$fileName" else fileName
            fileWriter= FileWriter(fullName)
            printWriter= PrintWriter(fileWriter)

            val friends:List<Friend> = DAOFactory.getIFriendDAOInstance().findAll()

            for( friend in friends){
                printWriter.println(friend.getInfo())
            }
            // 刷出缓冲区，将内容写入文件
            printWriter.flush()

            println("通讯录数据导出成功！")

        }catch (e:Exception){e.printStackTrace()}
        finally {
            fileWriter?.let { fileWriter.close()}
            printWriter?.let { printWriter.close() }
        }


    }

}