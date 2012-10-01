package org.ihc.esa

/***************************************************************************
	Generated code by GenGroovyObjects [09-Aug-2012 20:45:44 -0600]
	Copyright 2012 by Intermountain Healthcare
***************************************************************************/

import java.util.Date
class PartyAddress {

    BigDecimal partyId
    BigDecimal addressId
    Date dateCreated
    String createdBy
    Date lastUpdated
    String updatedBy

    static belongsTo = [
        address: Address,
        party: Party
    ]

    static mapping = {

        id generator:'sequence', params:[sequence:'PARTY_ADDRESS_SEQ']
        table 'PARTY_ADDRESS'
        version false

        address joinTable: [ name:'ADDRESS', key: 'ADDRESS_ID' ]
        party joinTable: [ name:'PARTY', key: 'PARTY_ID' ]

        partyId column: 'PARTY_ID'
        addressId column: 'ADDRESS_ID'
        dateCreated column: 'DATE_CREATED'
        createdBy column: 'CREATED_BY'
        lastUpdated column: 'LAST_UPDATED'
        updatedBy column: 'UPDATED_BY'

    }

    static constraints = {

        partyId nullable: false
        addressId nullable: false
        createdBy nullable: false
        updatedBy nullable: false

    }

}