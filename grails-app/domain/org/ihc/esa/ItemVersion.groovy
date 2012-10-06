package org.ihc.esa

/***************************************************************************
 Generated code by GenGroovyObjects [09-Aug-2012 20:45:44 -0600]
 Copyright 2012 by Intermountain Healthcare
 ***************************************************************************/

class ItemVersion
{
	Item item
	String versionNumber
	Date ihcActualDecomission
	Date ihcProposedDecomissioned
	Date vendorDecomission
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	
	static hasMany = [
		catalogItems: CatalogItem,						//fixed
		configurationVersionIs: ConfigurationCatalog,
		elementVersionIs: ConfigurationCatalog
	]
	
	static mappedBy = [
		configurationVersionIs:"parentItemVersion",
		elementVersionIs:"elementItemVersion"
	]
	
	static belongsTo = Item
	
	static mapping =
	{
		id generator:'sequence', params:[sequence:'ITEM_VERSION_SEQ']
		table 'ITEM_VERSION'
		version false
		
		
		item column: 'ITEM_ID'
		versionNumber column: 'VERSION_NUMBER'
		ihcActualDecomission column: 'IHC_ACTUAL_DECOMISSION'
		ihcProposedDecomissioned column: 'IHC_PROPOSED_DECOMISSIONED'
		vendorDecomission column: 'VENDOR_DECOMISSION'
		dateCreated column: 'DATE_CREATED'
		createdBy column: 'CREATED_BY'
		lastUpdated column: 'LAST_UPDATED'
		updatedBy column: 'UPDATED_BY'
		
		catalogItems joinTable: [ name: 'CATALOG_ITEM', key: 'ITEM_VERSION_ID']
		configurationVersionIs joinTable: [ name: 'CONFIGURATION_CATALOG', key: 'PARENT_ITEM_VERSION_ID']
		elementVersionIs joinTable: [ name: 'CONFIGURATION_CATALOG', key: 'ELEMENT_ITEM_VERSION_ID']
	}
	
	static constraints =
	{
		item nullable: false
		versionNumber nullable: false, blank: false, size: 1..256
		ihcActualDecomission nullable: true, display: true, format: 'yyyy-MM-dd'
		ihcProposedDecomissioned nullable: true, display: true, format: 'yyyy-MM-dd'
		vendorDecomission nullable: true, display: true, format: 'yyyy-MM-dd'
		dateCreated nullable: true, display: false, format: 'yyyy-MM-dd'
		createdBy nullable: false, size: 1..40
		lastUpdated nullable: true, display: false, format: 'yyyy-MM-dd'
		updatedBy nullable: false, size: 1..40
	}
}