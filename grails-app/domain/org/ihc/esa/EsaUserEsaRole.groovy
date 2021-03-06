package org.ihc.esa

import org.apache.commons.lang.builder.HashCodeBuilder

class EsaUserEsaRole implements Serializable {

	EsaUser esaUser
	EsaRole esaRole
	
	static mapping = {
		id generator:'sequence', params:[sequence:'ESA_USER_ESA_ROLE_SEQ']
		table 'ESA_USER_ESA_ROLE'
		
		id composite: ['esaRole', 'esaUser']
		version false
		
		esaUser column: 'ESA_USER_ID'
		esaRole column: 'ESA_ROLE_ID'
	}
	
	static constraints =
	{
		esaUser nullable: false
		esaRole nullable: false
	}

	boolean equals(other) {
		if (!(other instanceof EsaUserEsaRole)) {
			return false
		}

		other.esaUser?.id == esaUser?.id &&
			other.esaRole?.id == esaRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (esaUser) builder.append(esaUser.id)
		if (esaRole) builder.append(esaRole.id)
		builder.toHashCode()
	}

	static EsaUserEsaRole get(long esaUserId, long esaRoleId) {
		find 'from EsaUserEsaRole where esaUser.id=:esaUserId and esaRole.id=:esaRoleId',
			[esaUserId: esaUserId, esaRoleId: esaRoleId]
	}

	static EsaUserEsaRole create(EsaUser esaUser, EsaRole esaRole, boolean flush = false) {
		new EsaUserEsaRole(esaUser: esaUser, esaRole: esaRole).save(flush: flush, insert: true)
	}

	static boolean remove(EsaUser esaUser, EsaRole esaRole, boolean flush = false) {
		EsaUserEsaRole instance = EsaUserEsaRole.findByEsaUserAndEsaRole(esaUser, esaRole)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(EsaUser esaUser) {
		executeUpdate 'DELETE FROM EsaUserEsaRole WHERE esaUser=:esaUser', [esaUser: esaUser]
	}

	static void removeAll(EsaRole esaRole) {
		executeUpdate 'DELETE FROM EsaUserEsaRole WHERE esaRole=:esaRole', [esaRole: esaRole]
	}
}
