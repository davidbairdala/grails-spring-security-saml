grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

////grails.release.scm.enabled = false
//
grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {
    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()

        mavenRepo "http://maven.cbsmgmt.int:8081/nexus/content/repositories/releases/"
    }

    dependencies {

        String springSecurityVersion = '3.2.8.RELEASE'

        compile 'org.springframework.security.extensions:spring-security-saml2-core:1.0.1.RELEASE'
        compile "org.springframework.security:spring-security-web:$springSecurityVersion", {
            excludes 'aopalliance', 'commons-codec', 'commons-logging', 'fest-assert', 'groovy', 'hsqldb',
                    'jcl-over-slf4j', 'junit', 'logback-classic', 'mockito-core', 'powermock-api-mockito',
                    'powermock-api-support', 'powermock-core', 'powermock-module-junit4',
                    'powermock-module-junit4-common', 'powermock-reflect', 'spock-core', 'spring-beans',
                    'spring-context', 'spring-core', 'spring-expression', 'spring-jdbc',
                    'spring-security-core', 'spring-test', 'spring-tx', 'spring-web', 'spring-webmvc',
                    'tomcat-servlet-api'
        }
    }

    plugins {

        test ":code-coverage:1.2.5"

        compile(":spring-security-core:2.0-RC5")

        compile(":build-test-data:2.2.1",
                ":hibernate4:4.3.10") {
            export = false
        }

        build(":tomcat:7.0.54") {
            export = false
        }

        build ':release:3.0.1', ':rest-client-builder:2.0.1', {
            export = false
        }
    }
}

codenarc.reports = {
    CodeNarcReport('xml') {
        outputFile = 'target/test-reports/CodeNarcReport.xml'
        title = 'CodeNarc Report'
    }
}

grails.project.repos.buttonwood.url = "http://maven.cbsmgmt.int:8081/nexus/content/repositories/releases/"
grails.project.repos.default = "buttonwood"