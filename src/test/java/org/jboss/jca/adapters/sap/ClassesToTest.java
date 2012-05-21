package org.jboss.jca.adapters.sap;

public interface ClassesToTest {

	public static final Class<?>[] CLASSES_TO_TEST = new Class[] { JBossDestinationDataProvider.class,
			JBossSAPCciConnection.class, JBossSAPCciConnection.class, JBossSAPConnectionMetaData.class,
			JBossSAPConnectionSpec.class, JBossSAPIndexedRecord.class, JBossSAPInteraction.class,
			JBossSAPInteractionSpec.class, JBossSAPManagedConnection.class, JBossSAPManagedConnectionFactory.class,
			JBossSAPMappedRecord.class, JBossSAPRecordFactory.class, JBossSAPResourceAdapter.class,
			JBossSAPResourceAdapterMetaData.class };

}
