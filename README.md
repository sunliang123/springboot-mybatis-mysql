# springboot-mybatis-mysql

mybatis自动创建数据表（目前仅限mysql）

1、使用时，需要添加pom文件中的关键包
	<dependency>
	  <groupId>com.gitee.sunchenbin.mybatis.actable</groupId>
	  <artifactId>mybatis-enhance-actable</artifactId>
	  <version>1.0.1</version>
	</dependency>
	<dependency>
	  <groupId>org.apache.commons</groupId>
	  <artifactId>commons-lang3</artifactId>
	  <version>3.4</version>
	</dependency>
	<dependency>
	  <groupId>net.sf.json-lib</groupId>
	  <artifactId>json-lib</artifactId>
	  <version>2.4</version>
	  <classifier>jdk15</classifier>
	  <exclusions>
		<exclusion>
		  <artifactId>commons-logging</artifactId>
		  <groupId>commons-logging</groupId>
		</exclusion>
	  </exclusions>
	</dependency>
以上三个包，第一个是自动创建表的关键包，剩下的两个是第一个包中必须要用到的两个包，这三个都要导入，其他的类似于Mysql、Mybatis的包我这里就不累赘了

2、在properties中，放置的是自动创建表的配置信息，如下

mybatis.table.auto=update
mybatis.model.pack=com.example.entity
mybatis.database.type=mysql

#当mybatis.table.auto=create时，系统启动后，会将所有的表删除掉，然后根据model中配置的结构重新建表，该操作会破坏原有数据。
#当mybatis.table.auto=update时，系统会自动判断哪些表是新建的，哪些字段要修改类型等，哪些字段要删除，哪些字段要新增，该操作不会破坏原有数据。
#当mybatis.table.auto=none时，系统不做任何处理。
#mybatis.model.pack这个配置是用来配置要扫描的用于创建表的对象的包名

spring.datasource.url=jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

3、注意点：
	1、注意MyBatisMapperScannerConfig和TestConfig不能合并，不然会出现@Value为空的错误。
	2、在配置文件中的，com.example.demo.entity.*需要换成自己项目中的实体层目录，com.example.demo.mapper.*需要换成自己项目中的mapper目录