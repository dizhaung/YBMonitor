# �������ݿ�
CREATE DATABASE YBMonitor;
USE YBMonitor;
# ����֪ͨ�û��� �����쳣��Ϣ���˺�
CREATE TABLE msgUser(
  `yiban_id` VARCHAR(10) NOT NULL COMMENT '�װ�id',
  `nick_name` VARCHAR(20) COMMENT '�ǳ�',
  PRIMARY KEY (yiban_id)
)ENGINE = InnoDB CHARSET = utf8;

# ���������ַ�� ��ʶ�Ƿ�ɨ������Ƿ���������
CREATE TABLE urlMonitor(
  `url_id` INT NOT NULL AUTO_INCREMENT COMMENT '��ַid',
  `url` VARCHAR(20) COMMENT '��ַ',
  `sensitive_work` VARCHAR(20) COMMENT '���ֵ������֣�null��Ϊû��',
  PRIMARY KEY (url_id)
)ENGINE = InnoDB CHARSET = utf8;