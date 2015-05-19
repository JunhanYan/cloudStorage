# cloudStorage

5.19创建了表folder，修改了resource complete字段到folderId
CREATE TABLE `folder` (
  `folderId` int(11) NOT NULL AUTO_INCREMENT,
  `folderName` varchar(255) NOT NULL,
  `parentId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  PRIMARY KEY (`folderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
