//测试表
CREATE TABLE pb_user (                                
   id varchar(40) NOT NULL COMMENT '用户ID',           
   name varchar(40) NOT NULL COMMENT '用户名字',       
   password varchar(100) NOT NULL COMMENT '用户密码',  
   email varchar(100) DEFAULT NULL,                    
   PRIMARY KEY (id)                                    
 ) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='用户表' 