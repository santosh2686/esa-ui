log4j =
{
	
	environments
	{
		
		development
		{
			error   'org.codehaus.groovy.grails.web.servlet',  //  controllers
							'org.codehaus.groovy.grails.web.pages', //  GSP
							'org.codehaus.groovy.grails.web.sitemesh', //  layouts
							'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
							'org.codehaus.groovy.grails.web.mapping', // URL mapping
							'org.codehaus.groovy.grails.commons', // core / classloading
							'org.codehaus.groovy.grails.plugins', // plugins
							'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
							'org.springframework',
							'org.hibernate',
							'net.sf.ehcache.hibernate'
			
			debug	'grails.app.controller',
							'grails.app.service',
							'grails.app.domain',
							'grails.app',
							'org.hibernate.SQL',
							'grails.plugins.twitterbootstrap'
			
			trace	'org.hibernate.type'
			
			warn 	'grails.app.services.grails.plugins.springsecurity.ui.SpringSecurityUiService'
		}
		
		test
		{
			error   'org.codehaus.groovy.grails.web.servlet',  //  controllers
							'org.codehaus.groovy.grails.web.pages', //  GSP
							'org.codehaus.groovy.grails.web.sitemesh', //  layouts
							'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
							'org.codehaus.groovy.grails.web.mapping', // URL mapping
							'org.codehaus.groovy.grails.commons', // core / classloading
							'org.codehaus.groovy.grails.plugins', // plugins
							'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
							'org.springframework',
							'org.hibernate',
							'net.sf.ehcache.hibernate'
			
			debug	'grails.app.controller',
							'grails.app.service',
							'grails.app.domain',
							'grails.app',
							'org.hibernate.SQL',
							'grails.plugins.twitterbootstrap'
			
			trace	'org.hibernate.type'
			
			warn 	'grails.app.services.grails.plugins.springsecurity.ui.SpringSecurityUiService'
		}
		
		production
		{
			error   'org.codehaus.groovy.grails.web.servlet',  //  controllers
							'org.codehaus.groovy.grails.web.pages', //  GSP
							'org.codehaus.groovy.grails.web.sitemesh', //  layouts
							'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
							'org.codehaus.groovy.grails.web.mapping', // URL mapping
							'org.codehaus.groovy.grails.commons', // core / classloading
							'org.codehaus.groovy.grails.plugins', // plugins
							'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
							'org.springframework',
							'org.hibernate',
							'net.sf.ehcache.hibernate',
							'grails.app.controller',
							'grails.app.service',
							'grails.app.domain',
							'grails.app',
							'org.hibernate.SQL',
							'grails.plugins.twitterbootstrap',
							'org.hibernate.type',
							'grails.app.services.grails.plugins.springsecurity.ui.SpringSecurityUiService'
		}
	}
	
	root
	{
		error 'stdout', 'errorlog'
		additivity = true
	}
}
