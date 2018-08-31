# 建立数据库
CREATE DATABASE YBMonitor;
USE YBMonitor;
# 建立通知用户表 接受异常信息的账号
CREATE TABLE msgUser(
  `yiban_id` VARCHAR(10) NOT NULL COMMENT '易班id',
  `nick_name` VARCHAR(20) COMMENT '昵称',
  PRIMARY KEY (yiban_id)
)ENGINE = InnoDB CHARSET = utf8;

# 建立监控网址表 标识是否扫描过及是否含有敏感字
CREATE TABLE urlMonitor(
  `url_id` INT NOT NULL AUTO_INCREMENT COMMENT '网址id',
  `url` VARCHAR(20) COMMENT '网址',
  `sensitive_work` VARCHAR(20) COMMENT '出现的敏感字，null即为没有',
  PRIMARY KEY (url_id)
)ENGINE = InnoDB CHARSET = utf8;