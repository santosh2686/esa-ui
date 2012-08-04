package org.ihc.esa.domain

import java.util.Date
import java.math.BigDecimal

class RoleService {

    BigDecimal roleId
    BigDecimal serviceId
    Date dateCreated
    String createdBy
    Date lastUpdated
    String updatedBy

    static belongsTo = [
        role: Role,
        service: Service
    ]

    static mapping = {

        id generator:'sequence', params:[sequence:'ROLE_SERVICE_SEQ']
        table 'ROLE_SERVICE'
        version false

        role joinTable: [ name:'ROLE', key: 'ROLE_ID' ]
        service joinTable: [ name:'SERVICE', key: 'SERVICE_ID' ]

        roleId column: 'ROLE_ID'
        serviceId column: 'SERVICE_ID'
        dateCreated column: 'DATE_CREATED'
        createdBy column: 'CREATED_BY'
        lastUpdated column: 'LAST_UPDATED'
        updatedBy column: 'UPDATED_BY'

    }

    static constraints = {

        roleId nullable: false
        serviceId nullable: false
        dateCreated nullable: false
        createdBy nullable: false
        lastUpdated nullable: false
        updatedBy nullable: false

    }

}