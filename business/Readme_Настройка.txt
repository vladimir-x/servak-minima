Настройка в Glassfish 4.1.2
1) в glassfish\domains\polygon\lib\ добавить jdbc-драйвер postgresql-42.1.4.jar
2) создать connection-pool с параметрами подключения к бд и datasource с jndi-name="java:/jdbc/minima_psql" (через  админку гласфиша)
3) в glassfish\modules\ заменить jboss-logging.jar на jboss-logging-3.3.1.Final.jar (нужно для последнего гибера)
4) в проекте \servak\business\pom.xml
    у зависимости гибернейта поставить <scope>compile</scope>
    (можно вместо этого добавить его в glassfish\domains\polygon\lib, но мне так большще нравится)
5) в persistence.xml указать jta.platform
    <property name="hibernate.transaction.jta.platform" value="org.hibernate.service.jta.platform.internal.SunOneJtaPlatform" />

Для настройки в Wildfly
1) в \modules\system\layers\base\ добавить структуру org\postgresql\main\  с файлами
    1.1) jdbc-драйвер postgresql-42.1.4.jar
    1.2) module.xml
        <module xmlns="urn:jboss:module:1.0" name="org.postgresql">
          <resources>
            <resource-root path="postgresql-42.1.4.jar"/>
          </resources>
           <dependencies>
             <module name="javax.api"/>
             <module name="javax.transaction.api"/>
           </dependencies>
        </module>

2) через jboss-cli добавить в подсиситемы новый jdbc-драйвер
    /subsystem=datasources/jdbc-driver=postgresql:add(driver-name=postgresql,driver-module-name=org.postgresql,driver-class-name=org.postgresql.Driver,driver-datasource-class-name=org.postgresql.ds.PGSimpleDataSource,driver-xa-datasource-class-name=org.postgresql.xa.PGXADataSource)

3) добавить последнюю(нужную) версию гибернейта в wilfly
     Выкачать из мавена нужный артефакт
       <dependency>
                 <groupId>org.hibernate</groupId>
                 <artifactId>hibernate-orm-modules</artifactId>
                 <version>5.2.10.Final</version>
                 <classifier>wildfly-10-dist</classifier>
                 <type>zip</type>
       </dependency>

     Содержимое архива вставить в \modules\system\layers\base\
     (доп модули к существующему гибернейту )

4) в persistence.xml указать jta.platform и версию гибернейта для использования
       <property name="hibernate.transaction.jta.platform" value="org.hibernate.service.jta.platform.internal.JBossAppServerJtaPlatform" />
       <property name="jboss.as.jpa.providerModule" value="org.hibernate:5.2.10.Final"/>


5)в standalone\deployments\ добавить spo-ds.xml с описанием datasources. (можно и через jboss-cli, но мне так больше нравится)
<datasources>
	<xa-datasource jndi-name="java:/jdbc/minima_psql" pool-name="jdbc/minima_pool" enabled="true">
		<xa-datasource-property name="ServerName">
			127.0.0.1
		</xa-datasource-property>
		<xa-datasource-property name="PortNumber">
			5432
		</xa-datasource-property>
		<xa-datasource-property name="DatabaseName">
			minima
		</xa-datasource-property>
		<driver>postgresql</driver>
		<xa-pool>
			<min-pool-size>5</min-pool-size>
			<max-pool-size>20</max-pool-size>
			<prefill>true</prefill>
			<use-strict-min>false</use-strict-min>
			<flush-strategy>FailingConnectionOnly</flush-strategy>
		</xa-pool>
		<security>
			<user-name>postgres</user-name>
			<password>postgres</password>
		</security>
		<timeout>
			<blocking-timeout-millis>30000</blocking-timeout-millis>
			<idle-timeout-minutes>10</idle-timeout-minutes>
		</timeout>
	</xa-datasource>
	<drivers>
		<driver name="postgresql" module="org.postgresql">
			<xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
		</driver>
	</drivers>
</datasources>

Он будет деплоиться и создавать "поключение" к БД