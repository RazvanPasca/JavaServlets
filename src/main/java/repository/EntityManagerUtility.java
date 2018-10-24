package repository;

import entities.CityEntity;
import entities.FlightEntity;
import entities.UserEntity;
import entities.UserRoleEntity;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class EntityManagerUtility {

    private String dbUrl = "jdbc:mysql://localhost:3306/flights-one";
    private String dbUser = "root";
    private String dbPass = "root";
    private String hbm2ddl = "update";

    public EntityManager createEntityManager() {

        Properties props = new Properties();
        props.put("hibernate.connection.url", dbUrl);
        props.put("hibernate.connection.username", dbUser);
        props.put("hibernate.connection.password", dbPass);
        props.put("hibernate.hbm2ddl.auto", hbm2ddl);


        PersistenceUnitInfo persistenceUnitInfo = new PersistenceUnitInfo() {

            @Override
            public Properties getProperties() {
                return props;
            }

            @Override
            public List<String> getManagedClassNames() {
                return Arrays
                        .asList(UserEntity.class.getName(), UserRoleEntity.class.getName(), FlightEntity.class.getName()
                                , CityEntity.class.getName());
            }

            @Override
            public String getPersistenceUnitName() {
                return "TestUnit";
            }

            @Override
            public String getPersistenceProviderClassName() {
                return HibernatePersistenceProvider.class.getName();
            }

            @Override
            public PersistenceUnitTransactionType getTransactionType() {
                return null;
            }

            @Override
            public DataSource getJtaDataSource() {
                return null;
            }

            @Override
            public DataSource getNonJtaDataSource() {
                return null;
            }

            @Override
            public List<String> getMappingFileNames() {
                return null;
            }

            @Override
            public List<URL> getJarFileUrls() {
                return null;
            }

            @Override
            public URL getPersistenceUnitRootUrl() {
                return null;
            }

            @Override
            public boolean excludeUnlistedClasses() {
                return false;
            }

            @Override
            public SharedCacheMode getSharedCacheMode() {
                return null;
            }

            @Override
            public ValidationMode getValidationMode() {
                return null;
            }

            @Override
            public String getPersistenceXMLSchemaVersion() {
                return null;
            }

            @Override
            public ClassLoader getClassLoader() {
                return null;
            }


            @Override
            public void addTransformer(ClassTransformer transformer) {

            }

            @Override
            public ClassLoader getNewTempClassLoader() {
                return null;
            }
        };

        HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();

        EntityManagerFactory entityManagerFactory = hibernatePersistenceProvider
                .createContainerEntityManagerFactory(persistenceUnitInfo, Collections.EMPTY_MAP);

        return entityManagerFactory.createEntityManager();

    }

}
