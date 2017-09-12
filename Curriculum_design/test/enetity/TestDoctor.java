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
			// �������ö���
			Configuration config = new Configuration().configure();
			// ��������ע�����
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(config.getProperties()).buildServiceRegistry();
			// �����Ự����
			SessionFactory sessionFactory = config
					.buildSessionFactory(serviceRegistry);
			// ����session����
			Session session = sessionFactory.getCurrentSession();
			// ����SchemaExport����
			SchemaExport export = new SchemaExport(config);
			export.create(true,true);
			}
			
}