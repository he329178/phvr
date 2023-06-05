@Library('global-shared-library') _
pipeline {
    agent any

    stages {
         stage('Check Out') {
            steps {
                checkOut(
                    branch: "main",
                    url: "https://github.com/he329178/phvr.git"
                )
            }
        }
        stage('Maven Version') {
            steps {
                mavenVersion()    
            }
        }
        stage('RunTest Cases') {
            steps {
                runTests()
            }
        }
        stage('Publich Test Reports') {
            steps {
                publishReports()
            }
        }
        stage('Build Code') {
            steps {
                sh 'mvn clean compile -P jacoco:report sonar:sonar war:war'
                //sh 'mvn package -DskipTests=true'
            }
        }
//        stage('Archive Results') {
//            steps {
//                archiveArtifacts 'webapp/target/*.war'
//            }
//        }
//
        stage('Deploy Application') {
            steps {
                sh 'echo Deployment done'
                //deploy adapters: [tomcat9(credentialsId: 'Tomcat_Deployer', path: '', url: 'http://44.203.156.188:8090/')], contextPath: 'Calculator', war: '**/target/*.war'
            }
        }
    }
}
