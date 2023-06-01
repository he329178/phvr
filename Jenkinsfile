pipeline {
    agent any

    stages {
        stage('Maven Version') {
            steps {
                sh 'mvn --version'    
            }
        }
        stage('Check Out') {
            steps {
                checkout scmGit(branches: [[name: 'main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/he329178/phvr.git']])
            }
        }
        stage('RunTest Cases') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Publich Test Reports') {
            steps {
                sh 'ls **/target/surefire-reports/'
                jacoco()
            }
        }
        stage('Build Code') {
            steps {
                sh 'mvn package -DskipTests=true'
            }
        }
//        stage('Archive Results') {
//            steps {
//                archiveArtifacts 'webapp/target/*.war'
//            }
//        }
        stage('Deploy Application') {
            steps {
                sh 'echo Deployment done'
                //deploy adapters: [tomcat9(credentialsId: 'Tomcat_Deployer', path: '', url: 'http://44.203.156.188:8090/')], contextPath: 'Calculator', war: '**/target/*.war'
            }
        }
    }
}
