package org.ihc.esa


/*--------------------------------------------------------------------------
 Copyright 2012 by Intermountain Healthcare
 --------------------------------------------------------------------------*/

/**
 * Project class used to represent all projects, evaluations, exceptions that ESA is working on.
 * Required field is {@link #name}. All others are optional.
 *
 * Many Project(s) can reference One {@link Note}
 *
 * @author lpjharri
 * @since 0.9
 * @see Party
 */

class Project
{
	/**
	 * Required. Name of project.
	 */
	String name

	/**
	 * Optional, has default value or ProjectType.PROJECT. Type of the project.
	 */
	ProjectType type = ProjectType.PROJECT

	enum ProjectType
	{
		EXCEPTION("Exception"),
		EVALUATION("Evaluation"),
		PROJECT("Project"),
		LIGHTSON("Lights On"),
		RD("Research & Development")

		final String value

		ProjectType(String value)
		{
			this.value = value
		}

		String toString()
		{
			value
		}
		String getKey()
		{
			name()
		}
	}

	/**
	 * Optional, has default value of ProjectStatus.ACTIVE. Status of the project.
	 */
	ProjectStatus status = ProjectStatus.ACTIVE

	enum ProjectStatus
	{
		ACTIVE("Active"),
		CLOSED("Closed"),
		ONHOLD("On Hold")

		final String value

		ProjectStatus(String value)
		{
			this.value = value
		}

		String toString()
		{
			value
		}
		String getKey()
		{
			name()
		}
	}

	/**
	 * Optional. An external project number to associate with this ESA project.
	 * An example would be the ISSA SIRP, or the PMT project number.
	 */
	String externalProjectNumber

	/**
	 * Optional. The architect assigned to this project.
	 */
	Party architect

	/**
	 * Optional. The project manager assigned to this project.
	 */
	Party projectManager

	/**
	 * Optional. The start date of this project. Initialized to time of instance creation.
	 */
	Date dateStart = new Date()

	/**
	 * Optional. The completion date of this project.
	 */
	Date dateCompleted

	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy

	int hashCode = 0

	static transients = ['hashCode']

	/**
	 * Project maps to table PROJECT
	 */
	static mapping =
	{
		id generator:'sequence', params:[sequence:'PROJECT_SEQ']
		table 'PROJECT'
		version false

		name column: 'NAME'
		type column: 'TYPE'
		status column: 'STATUS'
		externalProjectNumber column: 'EXTERNAL_PROJECT_NUMBER'
		architect column: 'ARCHITECT_PARTY_ID'
		projectManager column: 'PROJECT_MANAGER_PARTY_ID'
		dateStart column: 'DATE_START'
		dateCompleted column: 'DATE_COMPLETED'
		dateCreated column: 'DATE_CREATED'
		createdBy column: 'CREATED_BY'
		lastUpdated column: 'LAST_UPDATED'
		updatedBy column: 'UPDATED_BY'
	}

	static constraints =
	{
		name nullable: false, size: 0..256
		type nullable: true, size: 0..40
		status nullable: true, size: 0..40
		externalProjectNumber nullable: true, size: 0..64
		architect nullable: true
		projectManager nullable: true
		dateStart nullable: true, format: 'yyyy-MM-dd'
		dateCompleted nullable: true, format: 'yyyy-MM-dd'
		dateCreated nullable: true, display: false, format: 'yyyy-MM-dd'
		createdBy nullable: false, size: 1..40
		lastUpdated nullable: true, display: false, format: 'yyyy-MM-dd'
		updatedBy nullable: false, size: 1..40
	}

	/**
	 * name, type, status, dateStart, dateCreated and createdBy
	 *
	 * @param project to compare to
	 * @return boolean
	 */
	@Override public boolean equals(Project project)
	{

		if (this.is(project)) return true

		if (project == null) return false

		if (project.getClass() != getClass()) return false

		if (project.name.equalsIgnoreCase(this.name) && project.type(this.type) && project.status.equals(this.status) && project.dateStart.equals(this.dateStart))
		{
			if (project.dateCreated.equals(this.dateCreated) && project.createdBy.equalsIgnoreCase(this.createdBy))
			{
				return true
			}
		}

		return false
	}

	@Override public int hashCode()
	{

		if (this.hashCode==0)
		{
			int result = 17
			result = (37*result) + this.name.toLowerCase().hashCode()
			result = (37*result) + (this.type ? this.type.hashCode() : 0)
			result = (37*result) + (this.status ? this.status.hashCode() : 0)
			result = (37*result) + this.dateStart.hashCode()
			result = (37*result) + this.dateCreated.hashCode()
			result = (37*result) + this.createdBy.toLowerCase().hashCode()
			this.hashCode = result
		}

		return this.hashCode
	}
}