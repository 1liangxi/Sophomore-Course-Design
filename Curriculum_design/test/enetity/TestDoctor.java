package enetity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.relational.Exportable;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestDoctor {
		
	@Test
			public void TestDoctordb()
			{
			// 创建配置对象
			Configuration config = new Configuration().configure();
			// 创建服务注册对象
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(config.getProperties()).buildServiceRegistry();
			// 创建会话工厂
			SessionFactory sessionFactory = config
					.buildSessionFactory(serviceRegistry);
			// 创建session对象
			Session session = sessionFactory.getCurrentSession();
			// 创建SchemaExport对象
			SchemaExport export = new SchemaExport(config);
			export.create(true,true);
			}
			
}
