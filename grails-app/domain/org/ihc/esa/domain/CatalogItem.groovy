package org.ihc.esa.domain

import java.util.Date
import java.math.BigDecimal

class CatalogItem {

    BigDecimal itemId
    BigDecimal catalogId
    BigDecimal itemVersionId
    Date dateCreated
    String createdBy
    Date lastUpdated
    String updatedBy

    static belongsTo = [
        catalog: Catalog,
        item: Item,
        itemVersion: ItemVersion
    ]

    static mapping = {

        id generator:'sequence', params:[sequence:'CATALOG_ITEM_SEQ']
        table 'CATALOG_ITEM'
        version false

        catalog joinTable: [ name:'CATALOG', key: 'CATALOG_ID' ]
        item joinTable: [ name:'ITEM', key: 'ITEM_ID' ]
        itemVersion joinTable: [ name:'ITEM_VERSION', key: 'ITEM_VERSION_ID' ]

        itemId column: 'ITEM_ID'
        catalogId column: 'CATALOG_ID'
        itemVersionId column: 'ITEM_VERSION_ID'
        dateCreated column: 'DATE_CREATED'
        createdBy column: 'CREATED_BY'
        lastUpdated column: 'LAST_UPDATED'
        updatedBy column: 'UPDATED_BY'

    }

    static constraints = {

        itemId nullable: false
        catalogId nullable: false
        dateCreated nullable: false
        createdBy nullable: false
        lastUpdated nullable: false
        updatedBy nullable: false

    }

}